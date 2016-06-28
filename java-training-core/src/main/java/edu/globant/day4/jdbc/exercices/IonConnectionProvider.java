package edu.globant.day4.jdbc.exercices;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class IonConnectionProvider {
	public static Connection getConnection() throws SQLException {
		String url = String.format("jdbc:mysql://localhost:3306/ion_solid");
		String user = "root";
		String password = ""; //set your password here
		return DriverManager.getConnection(url, user, password);
	}
}
