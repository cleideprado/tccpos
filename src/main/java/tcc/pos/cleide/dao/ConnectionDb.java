package tcc.pos.cleide.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionDb {
   // JDBC driver name and database URL
   static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://lmag6s0zwmcswp5w.cbetxkdyhwsb.us-east-1.rds.amazonaws.com:3306/toqkkbomlyhiuz96?useTimezone=true&serverTimezone=UTC";

   //  Database credentials
   static final String USER = "ukw6b2qsg7q4hmua";
   static final String PASS = "f8o1qeltmw6xaz2e";
   
   public static Connection getConnection(){
   Connection conn = null;
   try{
       try {
           //STEP 2: Register JDBC driver
           Class.forName(JDBC_DRIVER);
       } catch (ClassNotFoundException ex) {
           throw new RuntimeException("Connection Error: ", ex);
       }

      //STEP 3: Open a connection
      System.out.println("Connecting to database...");
      conn = DriverManager.getConnection(DB_URL,USER,PASS); 
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }//end try
        return conn;
   }
   public static void closeConnection(Connection conn) {
       try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }
   }
   
   public static void closeConnection(Connection conn,PreparedStatement stmt) {
       closeConnection(conn);
        try{
         if(stmt!=null)
            stmt.close();
      }catch(SQLException se){
          se.printStackTrace();
      }//
   }
   
   public static void closeConnection(Connection conn,PreparedStatement stmt, ResultSet rs){
       closeConnection(conn, stmt);
        try{
         if(rs!=null)
            rs.close();
      }catch(SQLException se){
         se.printStackTrace();
      }
       
   }
}//end ConnectionDb