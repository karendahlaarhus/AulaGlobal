package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import beans.UserSession;
import beans.dbConnection;

public class UserSessionDao {
	
	/**
	 * Creates a UserSession in the database. 
	 * Happens when a user logs in.
	 * @param us
	 * @throws SQLException
	 * @throws NamingException
	 */
	
	public static void createUserSession(UserSession us) throws SQLException, NamingException {
		Connection con = dbConnection.openConnection();
		
		String sql = "INSERT INTO UserSessions (id_user, start_date_time) VALUES (?, ?)"; 
		PreparedStatement stm = con.prepareStatement(sql);
		
		stm.setString(1, us.getIdUser());
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String sqlStartDateTime = sdf.format(us.getStartDateTime());
		stm.setString(2, sqlStartDateTime);
		
		stm.executeUpdate();
		
		con.close();
	}
	
	/**
	 * Updates a usersession by setting endtime. Happens when a user logs out
	 * @param us
	 * @throws SQLException
	 * @throws NamingException
	 */
	public static void endUserSession(UserSession us) throws SQLException, NamingException {
		Connection con = dbConnection.openConnection();
		
		String sql = "UPDATE UserSessions SET end_date_time = ? WHERE id_user = ? AND start_date_time = ?";
		PreparedStatement stm = con.prepareStatement(sql);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String sqlEndDateTime = sdf.format(us.getEndDateTime());
		stm.setString(1, sqlEndDateTime);
		
		stm.setString(2, us.getIdUser());
		
		String sqlStartDateTime = sdf.format(us.getStartDateTime());
		stm.setString(3, sqlStartDateTime);
		
		stm.executeUpdate();
		
		con.close();

	}
	
	public static List<UserSession> getUserSessions() throws SQLException, NamingException{
		Connection con = dbConnection.openConnection();
		
		String sql = "SELECT * From UserSessions JOIN Users WHERE id_user = Users.idusers";
		PreparedStatement stm = con.prepareStatement(sql);
		ResultSet rs = stm.executeQuery();
		
		List<UserSession> userSessions = new ArrayList<UserSession>();
		while (rs.next()) {
			UserSession us = new UserSession(rs.getString("id_user"), rs.getDate("start_date_time"), rs.getDate("end_date_time"));
			userSessions.add(us);
		}
		
		return userSessions;
		
	}

}
