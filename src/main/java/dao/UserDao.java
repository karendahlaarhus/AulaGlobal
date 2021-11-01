package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.NamingException;

import beans.User;
import beans.dbConnection;

public class UserDao {
	
	/**
	 * Creates a user (this is not a student)
	 * Does not set name and surname as this is allowed by the user later
	 * @param user
	 * @throws SQLException
	 * @throws NamingException
	 */
	
	public static void createUser(User user) throws SQLException, NamingException {
		Connection con = dbConnection.openConnection();
		
		String sql = "INSERT INTO Users (idusers, password) VALUES (?,?)";
		PreparedStatement stm = con.prepareStatement(sql);
		
		stm.setString(1, user.getUserId());
		stm.setString(2, user.getPassword());
		stm.executeUpdate();
		
		con.close();
		
		}
	
	/**
	 * Updates the user by setting name and surname
	 * @param userId
	 * @param name
	 * @param surname
	 * @throws SQLException
	 * @throws NamingException
	 */
	public static void updateUser(String userId, String name, String surname) throws SQLException, NamingException {
		Connection con = dbConnection.openConnection();
		
		String sql = "UPDATE Users SET name = ?, surname = ? WHERE idusers = ?";
		PreparedStatement stm = con.prepareStatement(sql);
		
		stm.setString(1, name);
		stm.setString(2, surname);
		stm.setString(3, userId);
		stm.executeUpdate();
		
		con.close();

	}
}