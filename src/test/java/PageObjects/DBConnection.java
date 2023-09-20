package PageObjects;

import  java.sql.Connection;		
import  java.sql.Statement;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import  java.sql.ResultSet;		
import  java.sql.DriverManager;		
import  java.sql.SQLException;	

public class DBConnection {
	//THIS CLASS IS FOR CHECKING THE RECORD IS CREATED/NOT CREATED IN DATABASE
	
	// Connection object
    static Connection con = null;
    // Statement object
    private static Statement stmt;
    // Constant for Database URL
    public static String DB_URL = "jdbc:mysql://localhost:3306/testdb";   
    // Constant for Database Username
    public static String DB_USER = "user";
    // Constant for Database Password
    public static String DB_PASSWORD = "userpassword";

 
    @SuppressWarnings("deprecation")
	public static void setUp() throws Exception {
           try{
                  // Make the database connection
                  String dbClass = "com.mysql.jdbc.Driver";
                  Class.forName(dbClass).newInstance();
                  // Get connection to DB
                  Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                  // Statement object to send the SQL statement to the Database
                  stmt = con.createStatement();
          }catch (Exception e){
                   e.printStackTrace();
          }
    }
    
    @Test
    @SuppressWarnings("deprecation")
    public static void checkDBforNatid(String natid) {
	       try{
	    	   //Thread.sleep(2000);
	           setUp();
        	   //String natid = "natid-6";
	           String query = "select * from working_class_heroes where natid=" + "'"+ natid + "'";
        	   //String query = "select * from working_class_heroes";
	           System.out.println(query);
	           
	           ResultSet res = stmt.executeQuery(query);   
	   
	           Boolean hasRecord = res.next();
	           if(hasRecord){
//	        	   System.out.print(res.getString(5));
//	        	   System.out.print("\t" + res.getString(6));
//	               System.out.print("\t" + res.getString(7));
//	               System.out.print("\t" + res.getString(8));
//	               System.out.print("\t" + res.getString(9));
//	               System.out.print("\t" + res.getString(10));
//	               System.out.print("\t" + res.getString(11));
//	               System.out.println("\t" + res.getString(12));
	        	   System.out.println(res.getString(11));
	        	   System.out.println("record :" + natid + " is verifed created in database");
	           }else {
	        	   System.out.println("record :" + natid + " is verified not created in database");
	           }
           }
           catch(Exception e)
           {
                  e.printStackTrace();
           }     
    
	       try {
			tearDown();
		   } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		   }
    }
    
    
    @Test
    @SuppressWarnings("deprecation")
    public static void checkDBforVoucher(String voucherName) {
	       try{
	    	   //Thread.sleep(2000);
	           setUp();
        	   //String voucher = "VOUCHER 1";
	           String query = "select * from vouchers where name=" + "'"+ voucherName + "'";
        	   //String query = "select * from working_class_heroes";
	           System.out.println(query);
	           
	           ResultSet res = stmt.executeQuery(query);   
	   
	           Boolean hasRecord = res.next();
	           if(hasRecord){
	        	   System.out.println(res.getString(6));
	        	   System.out.println("record :" + voucherName + " is verifed created in database");
	           }else {
	        	   System.out.println("record :" + voucherName + " is verified not created in database");
	           }
           }
           catch(Exception e)
           {
                  e.printStackTrace();
           }     
    
	       try {
			tearDown();
		   } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		   }
    }
    
    @Test
    public static void checkDBAllRecords() {
	       try{
	    	   //Thread.sleep(2000);
	           setUp();
	           String natid = "natid-6";
	           //String query = "select * from working_class_heroes where natid=" + "'"+ natid + "'";
	           String query = "select * from working_class_heroes";
	           System.out.println(query);
	           
	           ResultSet res = stmt.executeQuery(query);   
	           //System.out.println(res.next());
	           //System.out.print(res.getString(11));
	           Boolean hasRecord = res.next();
	           while(res.next()){
	        	   System.out.print(res.getString(5));
//	               System.out.print("\t" + res.getString(2));
//	               System.out.print("\t" + res.getString(3));
//	               System.out.print("\t" + res.getString(4));
//	               System.out.print("\t" + res.getString(5));
	               System.out.print("\t" + res.getString(6));
	               System.out.print("\t" + res.getString(7));
	               System.out.print("\t" + res.getString(8));
	               System.out.print("\t" + res.getString(9));
	               System.out.print("\t" + res.getString(10));
	               System.out.print("\t" + res.getString(11));
	               System.out.println("\t" + res.getString(12));
	              
	           }
        }
        catch(Exception e)
        {
               e.printStackTrace();
        }     
 }
    
    
    @Test
    public static void checkDBAllRecordsVouchers() {
	       try{
	    	   //Thread.sleep(2000);
	           setUp();
	           String natid = "natid-6";
	           //String query = "select * from working_class_heroes where natid=" + "'"+ natid + "'";
	           //String query = "show columns from vouchers";
	           String query = "select *  from vouchers";
	           System.out.println(query);
	           
	           ResultSet res = stmt.executeQuery(query);   
	           System.out.println(res.next());
	           //System.out.print(res.getString(1));
	           
	           while(res.next()){
	        	   System.out.print(res.getString(1));
	               System.out.print("\t" + res.getString(2));
	               System.out.print("\t" + res.getString(3));
	               System.out.print("\t" + res.getString(4));
	               System.out.print("\t" + res.getString(5));
	               System.out.print("\t" + res.getString(6));
	               System.out.print("\t" + res.getString(7));
	               System.out.println("\t" + res.getString(8));
//	               System.out.println("\t" + res.getString(9));
//	               System.out.print("\t" + res.getString(10));
//	               System.out.print("\t" + res.getString(11));
//	               System.out.println("\t" + res.getString(12));
	              
	           }
        }
        catch(Exception e)
        {
               e.printStackTrace();
        }     
 }
    
    
    public static void tearDown() throws Exception {
        // Close DB connection
        if (con != null) {
        con.close();
        }
 }
    
    
	
	

}
