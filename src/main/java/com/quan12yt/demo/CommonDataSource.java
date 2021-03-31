package com.quan12yt.demo;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;


import javax.sql.DataSource;

public class CommonDataSource {

    public static DataSource getHikariDataSource(){
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:postgresql://199.30.30.57:5432/postgres");
        config.setUsername("postgres");
        config.setPassword("s3training");
        config.setMinimumIdle(5);
        config.setMaximumPoolSize(100);
        config.setDriverClassName("org.postgresql.Driver");
        config.setLeakDetectionThreshold(300000);
        config.setConnectionTimeout(300000);
        config.setPoolName("Network-packet-pool");
        return new HikariDataSource(config);
    }


}
