package backend;
//STEP 1. Import required packages
import java.sql.*;

public class InsertRow {
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
          Class.forName(JDBC_DRIVER);

          //STEP 3: Open a connection
          System.out.println("Connecting to a selected database...");
          conn = DriverManager.getConnection(DB_URL, USER, PASS);
          System.out.println("Connected database successfully...");

          //STEP 4: Execute a query
          System.out.println("Inserting records into the table...");
          stmt = conn.createStatement();

          String sql = "INSERT INTO SOFTHOUSE_PERSONELL " + 
                       "VALUES (1, 'Young', 'Young', 'young@young.com')";

          stmt.executeUpdate(sql);

          System.out.println("Inserted records into the table...");

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
              if (conn!=null)
                  conn.close();
          } catch (SQLException se) {
              se.printStackTrace();
          } //end finally try
      } //end try

      System.out.println("Goodbye!");

  } //end main
} //end JDBCExample