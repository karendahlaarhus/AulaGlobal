package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import beans.User;
import beans.dbConnection;

public class LoginAccessDao {
	
	public static boolean validateLogin(User user) {
		boolean loginstatus = false;
		
		try {
			String name = user.getName();
			String password = user.getPassword();
			
			
			Connection con = dbConnection.openConnection();
			String sql = "SELECT * FROM Users where name = '"+  name + "' AND password ='" + password + "'";
			PreparedStatement stm = con.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();	
			loginstatus = rs.next();
			
			if(loginstatus) {
				user.setName(rs.getString("name"));
				user.setSurname(rs.getString("surname"));
			}
				
			
			
		}catch(Exception e){
			
			e.printStackTrace();
		}
		
		return loginstatus;
		
	
  }
}
		
	
