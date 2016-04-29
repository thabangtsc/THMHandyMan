package store;

import javax.swing.JOptionPane;
/**
 * Main Class
 * @author Thabang Moepi
 *
 */
public class FrontDesk {

	public static void main(String[] args) 
	{
		
		JOptionPane.showMessageDialog(null, "Welcome to THM Handyman Store");
		JOptionPane.showMessageDialog(null, "The following are records of the database");
		/*
		 * Call methods from class TheStore
		 */
		
		TheStore.SelectVendor();
		TheStore.SelectVendorProduct();
	}

}
