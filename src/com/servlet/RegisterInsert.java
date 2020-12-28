package com.servlet;

import java.io.IOException;  
import java.sql.Connection; 
import java.sql.PreparedStatement; 
  
import javax.servlet.ServletException; 
import javax.servlet.annotation.WebServlet; 
import javax.servlet.http.HttpServlet; 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse; 
  
// Import Database Connection Class file 
import com.dal.DBConnection; 
  
// Servlet Name 
@WebServlet("/RegisterInsert") 
public class RegisterInsert extends HttpServlet { 
    private static final long serialVersionUID = 1L; 
  
    protected void doPost(HttpServletRequest request,  HttpServletResponse response) throws ServletException, IOException { 
        try { 
            Connection con = DBConnection.initializeDatabase(); 

            PreparedStatement st = con.prepareStatement("insert into users(name,email,city,password) values(?, ?, ?, ?)"); 

            st.setString(1, request.getParameter("name")); 
            st.setString(2, request.getParameter("email")); 
            st.setString(3, request.getParameter("city")); 
            st.setString(4, request.getParameter("password")); 
            st.executeUpdate(); 
  
            st.close(); 
            con.close(); 
 
            response.sendRedirect("registerSuccess.html");
        } 
        catch (Exception e) { 
            e.printStackTrace(); 
        } 
    } 
} 