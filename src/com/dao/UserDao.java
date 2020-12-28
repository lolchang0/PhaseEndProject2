package com.dao;
 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.dal.DBConnection;
import com.model.User;
 
public class UserDao {
	public static String loginCheck(User user){
		try{
			Connection con=DBConnection.initializeDatabase();
			PreparedStatement ps=con.prepareStatement("select * from users where email=? and password=?");
			ps.setString(1,user.getEmail());
			ps.setString(2,user.getPassword());
			
			ResultSet rs=ps.executeQuery();

			if(rs.next()){
				return "true";
			}
			else{
				return "false";
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return "error";
	}
}