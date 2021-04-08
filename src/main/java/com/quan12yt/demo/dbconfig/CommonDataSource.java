package com.quan12yt.demo.dbconfig;

import com.quan12yt.demo.exception.CreateHikariDataSourceFailedException;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CommonDataSource {

    private final static Logger logger = LoggerFactory.getLogger(CommonDataSource.class);

    public static HikariDataSource getHikariDataSource() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:postgresql://199.30.30.57:5432/postgres");
        config.setUsername("postgres");
        config.setPassword("s3training");
        config.setMinimumIdle(1);
        config.setMaximumPoolSize(200);
        config.setDriverClassName("org.postgresql.Driver");
        config.setLeakDetectionThreshold(300000);
        config.setConnectionTimeout(300000);
        config.setPoolName("Network-packet-pool");
        try {
            logger.info("Creating Hikari Datasource ...");
            return new HikariDataSource(config);
        }catch (Exception e) {
            logger.error("Cant create Datasource", config.toString());
            throw new CreateHikariDataSourceFailedException("Failed to create Data source");
        }
    }
}
