package edu.globant.day4.jdbc.exercises;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import edu.globant.day1.ddd.exercises.model.Sale;

public class SaleDAO {
	private Connection connection;
	private Statement statement;

	public SaleDAO() {

	}

	public void saveSale(Sale sale) throws SQLException {
		String query = "INSERT INTO `sale` " + "VALUES (?,?,?,?,?)";
		try (PreparedStatement pstmt = connection.prepareStatement(query)) {
			pstmt.setNull(1, java.sql.Types.INTEGER);
			pstmt.setInt(2, sale.getReceipt().getId());
			pstmt.setString(3, sale.getStatus().toString());
			pstmt.setDouble(4, sale.getTotal());
			pstmt.executeUpdate();
		} finally {
			connection.close();
		}
	}

	public Sale getSale(int saleId) throws SQLException {
		String query = "SELECT * FROM sale WHERE id=" + saleId;
		ResultSet rs = null;
		Sale sale = null;
		try {
			connection = IONSimpleConnectionProvider.getConnection();
			statement = connection.createStatement();
			rs = statement.executeQuery(query);
			if (rs.next()) {
				rs.next();
				// Create Sale with data from query
				// sale = new Sale(rs.getInt(2),rs.getString(3),rs.getDouble(4));
			}
		} finally {
			connection.close();
		}
		return sale;
	}
}
