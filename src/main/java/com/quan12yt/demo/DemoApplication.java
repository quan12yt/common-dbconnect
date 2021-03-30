package com.quan12yt.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;

@SpringBootApplication
public class DemoApplication {



	public static void main(String[] args) throws SQLException {
		SpringApplication.run(DemoApplication.class, args);
		System.out.println(CommonDataSource.getDataSource().getConnection());
		Logger logger = LoggerFactory.getLogger(DemoApplication.class);

		for(int i=0; i<3; i++){
			logger.info(""+i);
			DBConnection dbConnection = new DBConnection(CommonDataSource.getHikariDataSource());
			dbConnection.printDBData();
		}
	}

}
