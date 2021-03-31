package com.quan12yt.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.DataSourceUtils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {

    private final Logger logger = LoggerFactory.getLogger(DBConnection.class);
    public Connection connection;

    public DBConnection(DataSource dataSource) throws SQLException {
        this.connection = DataSourceUtils.getConnection(dataSource);
    }

    public void printDBData(Integer i) throws SQLException, InterruptedException {
        if(connection.isClosed()){
            return;
        }
        Statement statement = this.connection.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * from users");
        while(rs.next()){
            logger.info(rs.getString("user_id"));
        }
        if(i == 99 || i == 100) {
            Thread.sleep(10000);
            this.connection.close();
        }
    }

    public void close() throws SQLException {
        this.connection.close();
    }


}
