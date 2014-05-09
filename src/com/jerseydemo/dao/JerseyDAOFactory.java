package com.jerseydemo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JerseyDAOFactory {
	

	public static Connection createconnection() {
		
		final String DRIVER = "com.mysql.jdbc.Driver";
		final String DBURL = "jdbc:mysql://localhost/employee";
		final String DBUSER = "root";
		final String DBPASS = "root";
		
		Connection connection = null;
		
		try {
			Class.forName(DRIVER);
			connection = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
			System.out.println("Database connection is established");
		} catch (ClassNotFoundException ce) {
			System.out.println("CLASS exception occured");
		} catch (SQLException e) {
			System.out.println("SQL Sexception occured");
		}
		return connection;

	}
	
	
}
