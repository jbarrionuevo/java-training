package edu.globant.day4.jdbc.exercises;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class IONSimpleConnectionProvider {

	public static Connection getConnection() throws SQLException {
		String url = String.format("jdbc:mysql://localhost:3306/ion");
		String user = "root";
		String password = ""; // set your password here
		return DriverManager.getConnection(url, user, password);
	}
}
