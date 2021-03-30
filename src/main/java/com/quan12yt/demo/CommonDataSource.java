package com.quan12yt.demo;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;
import java.sql.SQLException;


public class CommonDataSource {

    public static DataSource getDataSource() throws SQLException {
        return DataSourceBuilder.create()
                .url("jdbc:postgresql://199.30.30.57:5432/postgres")
                .password("s3training")
                .username("postgres")
                .driverClassName("org.postgresql.Driver")
                .build();
    }

    public static DataSource getHikariDataSource(){
        HikariConfig configuration = new HikariConfig();
        configuration.setJdbcUrl("jdbc:postgresql://localhost:5432/BrowserMonitorDB");
        configuration.setDriverClassName("org.postgresql.Driver");
        configuration.setUsername("postgres");
        configuration.setPassword("quanpro99");
        configuration.setRegisterMbeans(true);
        configuration.setAllowPoolSuspension(true);
        configuration.setMinimumIdle(2);
        configuration.setMaximumPoolSize(2);
        try (HikariDataSource hikariDataSource = new HikariDataSource(configuration)) {
            return hikariDataSource;
        }

    }
}
