package edu.web.jsp02.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.zaxxer.hikari.HikariDataSource;

import edu.web.jsp02.datasource.HikariDataSourceUtil;
import edu.web.jsp02.domain.Post;
import edu.web.jsp02.domain.User;
import lombok.Cleanup;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserDaoImpl implements UserDao {

    private static UserDaoImpl instance = null;

    private HikariDataSource ds;

    private UserDaoImpl() {

        ds = HikariDataSourceUtil.getinstance().getdaDataSource();
    }

    public static UserDaoImpl getinstance() {
        if (instance == null) {

            instance = new UserDaoImpl();
        }

        return instance;
    }

    private User autoUser(ResultSet rs) throws SQLException {

        Integer id = rs.getInt("ID");
        String name = rs.getString("NAME");
        String password = rs.getString("PASSWORD");
        String email = rs.getString("EMAIL");
        Integer points = rs.getInt("POINTS");

        User user = User.builder().id(id).name(name).password(password).email(email).points(points).build();

        return user;
    }

    // SQL_SELECT 문장
    public static final String SQL_SELECT = "select * from USERLIST order by ID";

    @Override
    public List<User> select() {
        List<User> list = new ArrayList<>();

        try {
            @Cleanup
            Connection conn = ds.getConnection();

            @Cleanup
            PreparedStatement stmt = conn.prepareStatement(SQL_SELECT);

            @Cleanup
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                User user = autoUser(rs);

                list.add(user);
            }
        } catch (SQLException e) {

            e.printStackTrace();

        }
        return list;
    }

    // SQL_insert 문장
    private static final String SQL_INSERT = "insert into USERLIST (NAME,PASSWORD,EMAIL) values (?,?,?)";

    @Override
    public int insert(User entity) {
        int result = 0;

        try {
            @Cleanup
            Connection conn = ds.getConnection();

            @Cleanup
            PreparedStatement stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, entity.getName());
            stmt.setString(2, entity.getPassword());
            stmt.setString(3, entity.getEmail());

            result = stmt.executeUpdate();

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return result;
    }

    // SQL_SELECT_BY_ID 문장
    private static final String SQL_SELECTBYID = "select * from USERLIST where id = ? order by ID desc";

    @Override
    public User selectById(Integer id) {
        User entity = null;

        try {
            @Cleanup
            Connection conn = ds.getConnection();

            @Cleanup
            PreparedStatement stmt = conn.prepareStatement(SQL_SELECTBYID);
            stmt.setInt(1, id);

            @Cleanup
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                entity = autoUser(rs);
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
        return entity;
    }

    // SQL_DELETE 문장
    private static final String SQL_DELETE = "delete from USERLIST where ID = ?";

    @Override
    public int delete(Integer id) {
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
    private static final String SQL_UPDATE = "update USERLIST set PASSWORD = ?, EMAIL = ?, POINTS = ? where id = ?";

    @Override
    public int update(User entity) {
        int result = 0;

        try {
            @Cleanup
            Connection conn = ds.getConnection();

            @Cleanup
            PreparedStatement stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, entity.getPassword());
            stmt.setString(2, entity.getEmail());
            stmt.setInt(3, entity.getPoints());
            stmt.setInt(4, entity.getId());

            result = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    // SQL_SEARCH 문장
    private static final String SELECT_BY_NAME = "select * from USERLIST where lower(NAME) like ? order by ID desc";
    private static final String SELECT_BY_EMAIL = "select * from USERLIST where lower(EMAIL) like ? order by ID desc";
    private static final String SELECT_BY_NAME_OR_EMAIL = "select * from USERLIST where lower(NAME) like ? or lower(EMAIL) like ? order by ID desc";

    @Override
    public List<User> search(String type, String keyword) {
        List<User> list = new ArrayList<>();

        try {
            @Cleanup
            Connection conn = ds.getConnection();
            @Cleanup
            PreparedStatement stmt = null;
            switch (type) {
            case "n":
                stmt = conn.prepareStatement(SELECT_BY_NAME);
                stmt.setString(1, "%" + keyword.toLowerCase() + "%");
                break;
            case "m":
                stmt = conn.prepareStatement(SELECT_BY_EMAIL);
                stmt.setString(1, "%" + keyword.toLowerCase() + "%");
                break;
            case "nm":
                stmt = conn.prepareStatement(SELECT_BY_NAME_OR_EMAIL);
                stmt.setString(1, "%" + keyword.toLowerCase() + "%");
                stmt.setString(2, "%" + keyword.toLowerCase() + "%");
                break;
            }
            @Cleanup
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                User user = autoUser(rs);

                list.add(user);
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return list;
    }

    // SQL_SIGNCHECK 문장
    private static final String SQL_SIGN_CHECK ="select * from USERLIST where NAME = ? and PASSWORD = ?";
    
    @Override
    public User signCheck(User user) {
        User entity = null;
        
        try {
            @Cleanup
            Connection conn = ds.getConnection();
            
            @Cleanup
            PreparedStatement stmt = conn.prepareStatement(SQL_SIGN_CHECK);
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getPassword());
            
            @Cleanup
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
            
                entity = autoUser(rs);
                
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return entity;
    }
}
