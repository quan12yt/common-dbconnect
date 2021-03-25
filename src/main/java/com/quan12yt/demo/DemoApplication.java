package com.quan12yt.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) throws SQLException {
		SpringApplication.run(DemoApplication.class, args);
		System.out.println(CommonDataSource.getDataSource().getConnection());
	}

}
