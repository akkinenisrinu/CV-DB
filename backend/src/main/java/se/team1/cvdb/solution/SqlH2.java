package se.team1.cvdb.solution;

import java.sql.*;

public class SqlH2 {
	
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "org.h2.Driver";
	static final String DB_URL = "jdbc:h2:~/test";

	// Database credentials
	static final String USER = "grkt";
	static final String PASS = "kamal29";

	Connection conn = null;
	Statement stmt = null;
	
	public void initializeConnections() {
		try {
			// STEP 2: Register JDBC driver
			Class.forName("org.h2.Driver");

			// STEP 3: Open a connection
			System.out.println("Connecting to a selected database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Connected database successfully...");
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		}
	}
	
	public void closeConnections() {
		try {
			if (stmt != null)
				conn.close();
		} catch (SQLException se) {
			se.printStackTrace();
		} // do nothing
		
		try {
			if (conn != null)
				conn.close();
		} catch (SQLException se) {
			se.printStackTrace();
		} // end finally try
	}

	public void createNewTable() {
		try {
			// Execute a query
			System.out.println("Creating table in given database...");
			stmt = conn.createStatement();
			
			String sql = "CREATE TABLE IF NOT EXISTS CV_DB "
					+ "(id INT NOT NULL auto_increment,"
					+ "firstName VARCHAR(255) NOT NULL,"
					+ "lastName VARCHAR(255) NOT NULL,"
					+ "email VARCHAR(255) NOT NULL,"
					+ "password VARCHAR(255) NOT NULL,"
					+ "confirmPassword VARCHAR(255) NOT NULL,"
					+ "site VARCHAR(255) NOT NULL,"
					+ "designation VARCHAR(255) NOT NULL,"
					+ "PRIMARY KEY (id)) AUTO_INCREMENT=1";
			stmt.executeUpdate(sql);
			System.out.println("Created table in given database...");
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		}
	}
	
	public void insertRow(User user) {
		
		  try {
	          //STEP 4: Execute a query
	          System.out.println("Inserting records into the table...");
	          stmt = conn.createStatement();

	          String sql = "INSERT INTO CV_DB "
	          		+ "(firstName,lastName,email,password,confirmPassword,site,designation)"
	          		+ "VALUES (" + "'" + user.getFirstName() +"'"
	          		+ ", " + "'" + user.getLastName() + "'"
	          		+ ", " + "'" + user.getEmail() + "'"
	          		+ ", " + "'" + user.getPassword() + "'"
	          		+ ", " + "'" + user.getConfirmPassword() + "'"
	          		+ ", " + "'" + user.getSite() + "'"
	          		+ ", " + "'" + user.getDesignation() + "'"
	          		+ ")";

	          stmt.executeUpdate(sql);

	          System.out.println("Inserted records into the table...");

	      } catch (SQLException se) {
	          //Handle errors for JDBC
	          se.printStackTrace();
	      } catch (Exception e) {
	          //Handle errors for Class.forName
	          e.printStackTrace();
	      }
	}
}