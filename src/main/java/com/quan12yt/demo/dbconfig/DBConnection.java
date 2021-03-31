package com.quan12yt.demo.dbconfig;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.jdbc.datasource.DataSourceUtils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DBConnection {

    private final Logger logger = LoggerFactory.getLogger(DBConnection.class);
    public Connection connection;

    public DBConnection(DataSource dataSource) throws SQLException {
        this.connection = dataSource.getConnection();
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
    }

    public void close() throws SQLException {
        this.connection.close();
    }


}
