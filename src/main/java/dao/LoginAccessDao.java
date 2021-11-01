package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import beans.User;
import beans.dbConnection;

public class LoginAccessDao {
	
	public static boolean validateLogin(User user)  {
		boolean loginstatus = false;
		

		try {
			String name = user.getName();
			String password = user.getPassword();
			
			
			Connection con = dbConnection.openConnection();
			String sql = "SELECT u FROM User u WHERE u.idusers = '"+name+"' AND u.password = '"+password+"'";
			PreparedStatement stm = con.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			
			loginstatus = rs.next();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}
		return loginstatus;
	}
}
		
	
