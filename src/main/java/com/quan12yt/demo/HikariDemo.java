package com.quan12yt.demo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;

public class HikariDemo {

    private static DataSource dataSource = CommonDataSource.getHikariDataSource();

    public static void main(String[] args) throws SQLException, InterruptedException {
        for (int i = 0; i < 113; i++) {
                DBConnection connection = new DBConnection(dataSource);
                connection.printDBData(i);
            System.out.println("connection : " +i);
        }
    }
}