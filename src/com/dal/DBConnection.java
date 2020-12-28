package com.dal;

import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.SQLException; 
  
// This class can be used to initialize the database connection 
public class DBConnection { 
    public static Connection initializeDatabase() 
        throws SQLException, ClassNotFoundException 
    { 
        Class.forName("org.h2.Driver"); 
        Connection con = DriverManager.getConnection("jdbc:h2:~/test", "sa", ""); 
        return con; 
    } 
} 