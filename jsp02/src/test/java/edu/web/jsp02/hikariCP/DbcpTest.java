package edu.web.jsp02.hikariCP;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

// Database Connection Pool
public class DbcpTest {

    // Log4j2 기능을 구현한 slf4j의 로깅 기능을 사용.
    private final Logger log = LoggerFactory.getLogger(DbcpTest.class);
    
    
    @Test
    public void testHikariCP() throws SQLException {
        
        // HikariCP 설정을 위한 객체 생성.
        HikariConfig config = new HikariConfig();
        
        // Connection Pool(Data source) 생성을 위한 환경 설정 세팅.
        config.setDriverClassName("oracle.jdbc.OracleDriver"); // 연결을 맺기 위한 DB 드라이버.
        config.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:xe");
        config.setUsername("scott");
        config.setPassword("tiger");
        config.addDataSourceProperty("cachePrepStmt", "ture");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        
        // 위의 설정들을 갖는 Connection Pool (Data Source) 객체 생성.
        HikariDataSource ds = new HikariDataSource(config);
        Assertions.assertNotNull(ds);
        System.out.println(ds);
        log.info("ds={}",ds);
        
        // connection pool(data source)에서 connection 객체를 빌려옴
        Connection conn = ds.getConnection();
        Assertions.assertNotNull(conn);
        System.out.println(conn);
        log.info("conn={}",conn);
        
        // 사용했던 Connection을 Connection Pool(Data source)에 반환.
    }
    
}
