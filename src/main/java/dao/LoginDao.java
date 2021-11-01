package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.NamingException;

import beans.User;
import beans.dbConnection;

public class LoginDao {
	
	public static boolean validateLogin(User user) throws SQLException, NamingException {
		Connection con = dbConnection.openConnection();
		
		String sql = "SELECT * FROM Users WHERE idusers = ? AND password = ?";
		PreparedStatement stm = con.prepareStatement(sql);
		stm.setString(1, user.getUserId());
		stm.setString(2, user.getPassword());
		
		ResultSet rs = stm.executeQuery();
		boolean oldUser = rs.next();
		
		con.close();
		
		return oldUser;
		
	
  }
}
		
	
