package beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginAccess {
	
	public static boolean validateLogin(User user) {
		boolean loginstatus = true;
		
		try {
			String name = user.getName();
			String password = user.getPassword();
			
			Connection con = dbConnection.openConnection();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM Users where name='"+name+"' AND password='"+password+"'");
			ResultSet rs = ps.executeQuery();	
			
			loginstatus = rs.next();
		
		}
		catch(Exception e){
			
			e.printStackTrace();
		}
		
		return loginstatus;
		
		
		
	
     }	
  }

		
	
