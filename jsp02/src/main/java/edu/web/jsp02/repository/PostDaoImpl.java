package edu.web.jsp02.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zaxxer.hikari.HikariDataSource;

import edu.web.jsp02.datasource.HikariDataSourceUtil;
import edu.web.jsp02.domain.Post;
import lombok.Cleanup;

// MVC 아키택처에서 Controller의 계층들 중 DB 관련 작업을 수행하는 계층..
// Controller 계층 : Web layer(Servlet) - Service layer - Repository layer(DAO)
public class PostDaoImpl implements PostDao {

    // slf4j log를 사용하기 위해서
    private static final Logger log = LoggerFactory.getLogger(PostDaoImpl.class);

    // singleton
    private static PostDaoImpl instance = null;

    private HikariDataSource ds;

    private PostDaoImpl() {
        ds = HikariDataSourceUtil.getinstance().getdaDataSource();
    }

    public static PostDaoImpl getinstance() {

        if (instance == null) {
            instance = new PostDaoImpl();
        }

        return instance;
    }

    private Post autoPost(ResultSet rs) throws SQLException {

        Integer id = rs.getInt("ID");
        String title = rs.getString("TITLE");
        String content = rs.getString("CONTENT");
        String author = rs.getString("AUTHOR");
        LocalDateTime createdDate = rs.getTimestamp("CREATED_TIME").toLocalDateTime();
        LocalDateTime modifiedDate = rs.getTimestamp("MODIFIED_TIME").toLocalDateTime();

        Post post = Post.builder().id(id).title(title).content(content).author(author).createdTime(createdDate)
                .modifiedTime(modifiedDate).build();

        return post;

    }

    // SQL_SELECT 문장
    public static final String SQL_SELECT = "select * from POSTS order by ID desc";

    @Override
    public List<Post> select() {
        log.info("select()");
        log.info("SQL : {}", SQL_SELECT);

        List<Post> list = new ArrayList<>();

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = ds.getConnection(); // Connection pool (Data source)에서 Connection을 빌려옴.
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Post post = autoPost(rs);

                list.add(post);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                stmt.close();
                conn.close(); // Data source에서 빌려온 Connection을 반환.
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return list;
    }

    // SQL_INSERT 문장
    public static final String SQL_INSERT = "insert into POSTS (TITLE, CONTENT, AUTHOR, CREATED_TIME, MODIFIED_TIME) values (?, ?, ?, sysdate, sysdate)";

    @Override
    public int insert(Post entity) {
        log.info("insert = {}", entity);
        log.info(SQL_INSERT);

        int result = 0; // DB에 insert 성공 했을 때 시퀀스로 생성된 글 번호를 return;

        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = ds.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, entity.getTitle()); // title
            stmt.setString(2, entity.getContent()); // content
            stmt.setString(3, entity.getAuthor()); // author

            result = stmt.executeUpdate(); // insert된 행의 개수 (성공하면 1, 그렇지 않으면 0)

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return result;
    }

    // SQL_SELECTBYID 문장
    private static final String SQL_SELECTBYID = "select * from POSTS where id = ? order by ID desc";

    @Override
    public Post selectById(Integer id) {

        // 엔터티 : DB 테이블의 행에 저장된 데이터. 레코드
        Post entity = null;

        log.info("select(id)");
        log.info("SQL : {}", SQL_SELECTBYID);

        try {
            @Cleanup // 리소스 사용이 끝난 후에 close() 메서드를 자동으로 호출.
            Connection conn = ds.getConnection(); // Connection pool (Data source)에서 Connection을 빌려옴.
            @Cleanup
            PreparedStatement stmt = conn.prepareStatement(SQL_SELECTBYID);
            stmt.setInt(1, id);

            @Cleanup
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                entity = autoPost(rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } // @Cleanup을 사용해서 finally에서 close 메서드를 호출할 필요 없이, 모든 리소스는 자동으로 해제됨

        return entity;
    }

    // SQL_DELETE 문장
    private static final String SQL_DELETE = "delete from POSTS where ID = ?";

    @Override
    public int delete(Integer id) {

        log.info("delete()");
        log.info(SQL_DELETE);

        int result = 0;

        try {
            @Cleanup
            Connection conn = ds.getConnection();
            @Cleanup
            PreparedStatement stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, id);

            result = stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();

        }
        return result;
    }

    // SQL_UPDATE 문장
    private static final String SQL_UPDATE = "update POSTS set TITLE = ?, CONTENT = ?, MODIFIED_TIME = sysdate where id = ?";

    @Override
    public int update(Integer id, String title, String content) {
        int result = 0;

        log.info(SQL_UPDATE);

        try {
            @Cleanup
            Connection conn = ds.getConnection();
            @Cleanup
            PreparedStatement stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, title);
            stmt.setString(2, content);
            stmt.setInt(3, id);

            result = stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();

        }

        return result;
    }

    // SQL_SEARCH문장
    private static final String SELECT_BY_TITLE = "select * from POSTS where lower(TITLE) like ? order by ID desc";
    private static final String SELECT_BY_CONTENT = "select * from POSTS where lower(CONTENT) like ? order by ID desc";
    private static final String SELECT_BY_TITLE_OR_CONTENT = "select * from POSTS where lower(TITLE) like ? or lower(CONTENT) like ? order by ID desc";
    private static final String SELECT_BY_AUTHOR = "select * from POSTS where lower(AUTHOR) like ? order by ID desc";

    @Override
    public List<Post> selectByKeyword(String type, String keyword) {
        List<Post> list = new ArrayList<>();

        try {
            @Cleanup
            Connection conn = ds.getConnection();
            @Cleanup
            PreparedStatement stmt = null;
            switch (type) {

            case "t":
                stmt = conn.prepareStatement(SELECT_BY_TITLE);
                stmt.setString(1, "%"+keyword.toLowerCase() +"%");
                break;
            case "c":
                stmt = conn.prepareStatement(SELECT_BY_CONTENT);
                stmt.setString(1, "%"+keyword.toLowerCase() +"%");
                break;
            case "tc":
                stmt = conn.prepareStatement(SELECT_BY_TITLE_OR_CONTENT);
                stmt.setString(1, "%"+keyword.toLowerCase() +"%");
                stmt.setString(2, "%"+keyword.toLowerCase() +"%");
                break;
            case "a":
                stmt = conn.prepareStatement(SELECT_BY_AUTHOR);
                stmt.setString(1, "%"+keyword.toLowerCase() +"%");
                break;
            }
            
            @Cleanup
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()) {
                
                Post post = autoPost(rs);
                
                list.add(post);
            }
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        

        return list;
    }

}
