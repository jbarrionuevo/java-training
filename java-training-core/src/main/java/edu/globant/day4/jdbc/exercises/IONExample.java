package edu.globant.day4.jdbc.exercises;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class IONExample {

	public static void main(String[] args) {

		IONSimpleConnectionProvider simple = new IONSimpleConnectionProvider();
		try (Connection con = simple.getConnection()) {

			String select = "SELECT c.id, c.price, c.stock, des.name, dev.name " + "	from case c inner join des d on c.des_id=des.id"
					+ "	inner join device dev on c.dev_id=dev.id";
			try (PreparedStatement pstmt = con.prepareStatement(select)) {
				try (ResultSet rs = pstmt.executeQuery()) {
					while (rs.next()) {
						System.out.println(String.format(
								"Retrieved row for id %d with price %f, design name %s, device name %s, and stock %f", rs.getInt("c.id"),
								rs.getFloat("p.price"), rs.getString("des.name"), rs.getString("dev.name"), rs.getFloat("c.stock")));
					}
				}
			}

			String insert = "INSERT INTO device VALUES (?,?)";
			try (PreparedStatement pstmt = con.prepareStatement(insert)) {
				pstmt.setNull(1, java.sql.Types.INTEGER);
				pstmt.setString(2, "Device");
				pstmt.executeUpdate();
				System.out.println("Device succesfully inserted");
			}

			String update = "UPDATE device SET name='Device updated' WHERE name='Device'";
			try (PreparedStatement pstmt = con.prepareStatement(update)) {
				pstmt.executeUpdate();
				System.out.println("Device succesfully updated");
			}

			String delete = "DELETE FROM device WHERE name='Device updated'";
			try (PreparedStatement pstmt = con.prepareStatement(delete)) {
				pstmt.execute();
				System.out.println("Device succesfully deleted");
			}

		} catch (SQLException e) {
			System.out.println("Issues when working with database.");
			e.printStackTrace(System.out);
		} catch (Exception e) {
			System.out.println("Unexpected problem.");
			e.printStackTrace(System.out);
		}
	}

}
