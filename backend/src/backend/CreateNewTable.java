package backend;
// Import required packages
import java.sql.*;

public class CreateNewTable {

	 // JDBC driver name and database URL
	 static final String JDBC_DRIVER = "org.h2.Driver";
	 static final String DB_URL = "jdbc:h2:~/test";

	 //  Database credentials
	 static final String USER = "jsp99";
	 static final String PASS = "vinnova";

	 public static void main (String[] args) {
	     Connection conn = null;
	     Statement stmt = null;

	     try {
	         //STEP 2: Register JDBC driver
	         Class.forName("org.h2.Driver");

	         //STEP 3: Open a connection
	         System.out.println("Connecting to a selected database...");
	         conn = DriverManager.getConnection(DB_URL, USER, PASS);
	         System.out.println("Connected database successfully...");

	         //STEP 4: Execute a query
	         System.out.println("Creating table in given database...");
	         stmt = conn.createStatement();

	         String sql = "CREATE TABLE SOFTHOUSE_PERSONELL" +
	                 "(userid INTEGER not NULL, " +
	                 " firstName VARCHAR(255), " +
	                 " lastName VARCHAR(255), " +
	                 " email VARCHAR(255))";

	         stmt.executeUpdate(sql);
	         System.out.println("Created table in given database...");
	     } catch (SQLException se) {
	         //Handle errors for JDBC
	         se.printStackTrace();
	     } catch (Exception e) {
	         //Handle errors for Class.forName
	         e.printStackTrace();
	     } finally {
	         //finally block used to close resources
	         try {
	             if (stmt!=null)
	                 conn.close();
	         } catch (SQLException se) {
	         } // do nothing
	         try {
	             if (conn!= null)
	                 conn.close();
	         } catch (SQLException se) {
	             se.printStackTrace();
	         } // end finally try
	     } // end try
	     System.out.println("Goodbye!");
	 } // end main
}
