package edu.globant.day4.jdbc.exercices;

import static edu.globant.utils.DateUtils.parseDate;
import static edu.globant.utils.DateUtils.toSqlDate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import edu.globant.utils.DateUtils;

public class IonAccesingExample {
	public static void main(String[] args) {
		IonConnectionProvider conection = new IonConnectionProvider();
		try (Connection con = conection.getConnection()) {
			System.out.println("Connection to MySQL was successful.");
			
			String select = "SELECT cp.id, cp.price, des.name, dev.name "
					+ "		from case_product cp inner join case_design des on cp.design_id=des.id"
					+ "							inner join case_device dev on cp.device_id=dev.id";
			try (PreparedStatement pstmt = con.prepareStatement(select)) {
				try (ResultSet rs = pstmt.executeQuery()) {
					while (rs.next()) {
						System.out.println(String.format(
								"Retrieved row for id %d with price %f, design name %s and device name %s",
								rs.getInt("cp.id"), rs.getFloat("cp.price"), rs.getString("des.name"),
								rs.getString("dev.name")));
					}
				}
			}
			
			String insert = "INSERT INTO case_design VALUES (?,?)";
			try (PreparedStatement pstmt = con.prepareStatement(insert)) {
				pstmt.setNull(1, java.sql.Types.INTEGER);
				pstmt.setString(2, "New design");
				pstmt.executeUpdate();
				System.out.println("New Design succesfully inserted");
			}
			
			String update = "UPDATE case_design SET name='New Design updated' WHERE name='New Design'";
			try (PreparedStatement pstmt = con.prepareStatement(update)) {
				pstmt.executeUpdate();
				System.out.println("New Design succesfully updated");
			}
			
			String delete = "DELETE FROM case_design WHERE name='New Design updated'";
			try (PreparedStatement pstmt = con.prepareStatement(delete)) {
				pstmt.execute();
				System.out.println("New Design succesfully deleted");
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
