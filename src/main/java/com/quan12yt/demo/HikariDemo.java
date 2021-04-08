package com.quan12yt.demo;

import java.sql.SQLException;

import com.quan12yt.demo.dbconfig.CommonDataSource;
import com.quan12yt.demo.dbconfig.DBConnection;

import javax.sql.DataSource;

public class HikariDemo {

    private static DataSource dataSource = CommonDataSource.getHikariDataSource();

    public static void main(String[] args) throws SQLException, InterruptedException {
        for (int i = 0; i < 200; i++) {
                DBConnection connection = new DBConnection(dataSource);
                connection.printDBData(i);
            System.out.println("connection : " +i);
        }

    }
}