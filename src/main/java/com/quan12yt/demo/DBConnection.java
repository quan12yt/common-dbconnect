package com.quan12yt.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {

    private final Logger logger = LoggerFactory.getLogger(DBConnection.class);
    private Connection connection;

    public DBConnection(DataSource dataSource) throws SQLException {
        this.connection = dataSource.getConnection();
    }

    public void printDBData() throws SQLException {
        if(connection.isClosed()){
            return;
        }
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * from users");
        while(rs.next()){
            logger.info(rs.toString());
        }
    }


}
