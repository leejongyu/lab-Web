package edu.web.jsp02.datasource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

// HikariCP 라이브러리를 사용한 DataSource를 이용할 수 있는 유틸리티 클래스.
// Single-tone 패턴 설계
public class HikariDataSourceUtil {

    private static HikariDataSourceUtil instance = null;

    private HikariDataSource ds;

    private HikariDataSourceUtil() {
        // HikariCP를 사용하기 위한 설정(configuration)
        HikariConfig config = new HikariConfig();

        config.setDriverClassName("oracle.jdbc.OracleDriver"); // 연결을 맺기 위한 DB 드라이버.
        config.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:xe");
        config.setUsername("scott");
        config.setPassword("tiger");
        config.addDataSourceProperty("cachePrepStmt", "ture");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        
        // HikariDataSource 객체 생성.
        
        ds = new HikariDataSource(config);

    }

    public static HikariDataSourceUtil getinstance() {
        if (instance == null) {
            instance = new HikariDataSourceUtil();
        }
        return instance;
    }

    public HikariDataSource getdaDataSource() {
        return ds;
    }

}
