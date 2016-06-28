package edu.globant.day4.jdbc.exercices;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import edu.globant.day1.ddd.exercices.models.Sale;
import edu.globant.day1.oop.exercices.models.Case;
import edu.globant.day1.oop.exercices.models.Inventory;



public class InventoryDao {
	private Connection connection;
    private Statement statement;
    
    public InventoryDao(){}
    
    public Inventory getInventory() throws SQLException {
        String query = "SELECT * FROM inventory ";
        ResultSet rs = null;
        Inventory inventory= null;
        try {
            connection = IonConnectionProvider.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(query);
            if (rs.next()){
            	rs.next();
            	//create inventory from the result
            	System.out.println(rs.getString(0));
            }
        } finally {
            connection.close();
        }
        return inventory;
    }
    
    public void insertProduct(Case aCase, int quantity) throws SQLException{
    	Inventory inv = this.getInventory();
    	/** update inv **/
    	/** if we follow the final project model, we should retrieve the casewrapper from that case and update it**/
    }
}
