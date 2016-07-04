package edu.globant.day4.jdbc.exercises.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource {
	
	public Connection getConnection() throws SQLException {
		String url = String.format("jdbc:mysql://localhost:3306/training");
		String user = "root";
		String password = ""; //set your password here
		return DriverManager.getConnection(url, user, password);
	}
	
}
