package store;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

public class TheStore 
{
	public static Connection cn = null;
	
	public static void SelectVendorProduct()
	{
		int id, pHand,pOrder,pUnit;
		String desc;
		try
		{
			// Call Connection method connectDB() to connect to database
			Connect();
			// Prompt user input
			id = Integer.parseInt(JOptionPane.showInputDialog("Enter product id here: "));
			PreparedStatement sta = cn.prepareStatement("SELECT * FROM product where vendor_v_ID = '" + id + "'");
			ResultSet res = sta.executeQuery();
			//JOptionPane.showMessageDialog(null, "database table accessed");
			
			System.out.println("+++=========Product Record(s)========+++");
			
			while (res.next())
			{
				id = res.getInt("p_ID");
				desc = res.getString("desc");
				pHand= res.getInt("p_onhand");
				pOrder = res.getInt("p_reorder_level");
				pUnit = res.getInt("p_unit_price");
				
				
				System.out.println("Product Id: " + id + "| Description: " + desc + "| Product onHand: " + pHand+
						"| Order Levels: " + pOrder+ "| Unit Price: " + pUnit+
						"\n_______________________________________"); 
				
			}
			
			cn.close();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			//JOptionPane.showMessageDialog(null, e.getMessage().toString());
			JOptionPane.showMessageDialog(null, "Not connected to database");
		}
		
	}
	/*
	 * retrieve data from Vendor table 
	 */
	public static void SelectVendor()
	{
		int id, von;
		String name,contact,province;
		try
		{
			// Call Connection method connectDB() to connect to database
			Connect();
			
			PreparedStatement sta = cn.prepareStatement("SELECT * FROM vendor");
			ResultSet res = sta.executeQuery();
			//JOptionPane.showMessageDialog(null, "database table accessed");
			
			System.out.println("+++=========Vendor Records========+++");
			
			while (res.next())
			{
				id = res.getInt("v_ID");
				name = res.getString("v_name");
				contact = res.getString("v_c_no");
				province = res.getString("v_province");
				von = res.getInt("v_orderNo");
				
				
				System.out.println("Vendor Id: " + id + "| Name: " + name + "| Contact No: " + contact+
						"| Province: " + province+ "| order No: " + von+
						"\n_______________________________________"); 
				
			}
			
			cn.close();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			//JOptionPane.showMessageDialog(null, e.getMessage().toString());
			JOptionPane.showMessageDialog(null, "Not connected to database");
		}
		
	}
	
	public static void Connect()
	{
		//Connection conn = null;
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");

			cn = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/thmstore","root","thabang");
			
			if(cn != null)
			{
				System.out.println("");
				System.out.println("!!!!!!!!!!!!!!!");
				System.out.println("");
			}
		}
		catch(Exception e)
		{
			System.out.println("not connected to database");
		}
	}
}
