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
 		 
		 
 		System.out.println("The following are records of the database"); 
 		/* 
		 * Call methods from class TheStore 
		 */ 
 		 
 		TheStore.SelectVendor(); 
 		TheStore.SelectVendorProduct(); 
 	} 
 
 
 } 
