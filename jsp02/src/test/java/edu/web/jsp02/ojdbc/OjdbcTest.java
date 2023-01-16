package edu.web.jsp02.ojdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import oracle.jdbc.OracleDriver;

// JUnit Test(자바 단위 테스트)
// JDBC (Java Database Connectivity) - ojdbc8 라이브러리 연결 테스트
@TestMethodOrder(OrderAnnotation.class) // 테스트 메서드의 호출 순서를 지정하기위한 메서드
public class OjdbcTest {

    private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";

    private static final String USER = "scott";

    private static final String PASSWORD = "tiger";

    private static final String SQL_SELECT = "select * from POSTS order by ID desc";

    private static final String SQL_INSERT = "insert into posts (title, content, author, created_time, modified_time) "
            + "values (?, ?, ?, sysdate, sysdate)";

    // JUnit test : Junit 모듈에서 테스트르 하기 위해서 호출하는 메서드

    // (1) 가시성 : public (2) 리턴타입 : void, (3) 파라미터를 갖지 않음.
    @Test
    @Order(2)
    public void testSelect() throws SQLException {
        // 1. OJDBC 라이브러리 로딩.
        DriverManager.registerDriver(new OracleDriver());

        // 2. 등록된 JDBC 라이브러리를 사용해서 Oracle DB와 연결
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        Assertions.assertNotNull(conn); // connection 객체가 null이 아님
        // junit test -> conn이 null이 아니면 단위 테스트 성공. null이면 실패.

        // 3. statement 준비
        PreparedStatement stmt = conn.prepareStatement(SQL_SELECT);

        // 4. SQL 실행
        ResultSet rs = stmt.executeQuery();

        // 5. 결과처리
        while (rs.next()) {
            Integer id = rs.getInt("ID");
            String title = rs.getString("TITLE");
            String content = rs.getString("CONTENT");
            String author = rs.getString("AUTHOR");
            LocalDateTime createdDate = rs.getTimestamp("CREATED_TIME").toLocalDateTime();
            LocalDateTime modifiedDate = rs.getTimestamp("MODIFIED_TIME").toLocalDateTime();

            String row = String.format("%d | %s | %s | %s | %s | %s", id, title, content, author, createdDate,
                    modifiedDate);

            System.out.println(row);
        }

        // 사용했던 리소스 해제

        rs.close();
        stmt.close();
        conn.close();
    }

    @Test
    @Order(1)
    public void testInsert() throws SQLException {
        DriverManager.registerDriver(new OracleDriver());

        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);

        PreparedStatement stmt = conn.prepareStatement(SQL_INSERT);
        
        // preparedStatement의 파라미터들 '?' 을 세팅.
        stmt.setString(1, "김뚤딸2의 국내지도2");
        stmt.setString(2, "이건 국내지도 내용2야");
        stmt.setString(3, "김뚤딸2");

        int rs = stmt.executeUpdate();
        Assertions.assertEquals(1, rs); // rs(SQL UPDATE)가 성공한다면, 행이 1개가 추가되기 때문에 1을 rs는 return한다. 만약 1이 아니라면, sql
                                        // update가 실패했다는 것이다.

        stmt.close();
        conn.close();

    }

}
