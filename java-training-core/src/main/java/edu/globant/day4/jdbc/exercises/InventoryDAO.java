package edu.globant.day4.jdbc.exercises;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import edu.globant.day1.ddd.exercises.model.Inventory;

public class InventoryDAO {

	private Connection connection;
	private Statement statement;

	public InventoryDAO() {

	}

	public Inventory getInventory() throws SQLException {
		String query = "SELECT * FROM inventory";
		ResultSet rs = null;
		Inventory inv = null;
		try {
			connection = IONSimpleConnectionProvider.getConnection();
			statement = connection.createStatement();
			rs = statement.executeQuery(query);
			if (rs.next()) {
				rs.next();
				System.out.println(rs);
			}
		} finally {
			connection.close();
		}
		return inv;
	}
}
