package edu.globant.day2.exceptions.exercices.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import edu.globant.day1.oop.exercices.models.Sale;
import edu.globant.day2.exceptions.exercices.exceptions.SaleNotFoundException;

public class SaleDao {
	//methods to access the underlying db
	
	public void saveSale(Sale sale){
		Connection conn = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("db_url","user","pass");
			//save sale
		}catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   }catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }finally{
		      //finally block used to close resources
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }
		   }
	}
	
	public Sale getSale(Integer saleId) throws SaleNotFoundException{
		if(saleId==null) throw new IllegalArgumentException("Sale id cannot be empty.");
		try{
			//get sale with id saleId
			return null;
		}catch(Exception e){
			throw new SaleNotFoundException("Sale with id "+saleId+" was not found");
		}
	}
	
}
