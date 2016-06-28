package edu.globant.day4.jdbc.exercices;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import edu.globant.day1.ddd.exercices.models.Sale;
import edu.globant.day1.oop.exercices.enums.SaleStatus;

public class SaleDao {
	private Connection connection;
    private Statement statement;
 
    public SaleDao() { }
     
    public void saveSale(Sale sale) throws SQLException{
    	String query = 
    			"INSERT INTO `sale` "
    			+ "VALUES (?,?,?,?,?)";
    	try (PreparedStatement pstmt = connection.prepareStatement(query)) {
        	pstmt.setNull(1, java.sql.Types.INTEGER);
			pstmt.setString(2,sale.getStatus().toString());
			pstmt.setInt(3, sale.getOrder().getId());
			pstmt.setInt(4, sale.getReceipt().getId());
			pstmt.setInt(5, sale.getSeller().getId());
			pstmt.executeUpdate();
        } finally {
            connection.close();
        }
    }
    public Sale getSale(int saleId) throws SQLException {
        String query = "SELECT * FROM sale WHERE id=" + saleId;
        ResultSet rs = null;
        Sale sale= null;
        try {
            connection = IonConnectionProvider.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(query);
            if (rs.next()){
            	rs.next();
            	/** get order receipt and seller from the next values and then create the sale **/
            	//sale = new Sale(rs.getInt(3), rs.getInt(4), rs.getInt(5));
            }
        } finally {
            connection.close();
        }
        return sale;
    }
    
}
