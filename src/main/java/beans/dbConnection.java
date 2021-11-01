package beans;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class dbConnection {
	
	//TODO: CHANGE USERNAME AND PASSWORD TO FIT YOUR CREDENTIALS
	static final String DB_URL = "jdbc:mysql://localhost:3306/BD89_06_aulamaster";
	static final String USER = "USERNAME";
	static final String PASSWORD = "PASSWORD";
	static final String DATA_SOURCE = "BD89_06_aulamaster";
	
	/**
	 * This function is used to connect with the database.
	 * IMPORTANT!! that you remember to change username and password to fit your
	 * credentials
	 * @return a connection to the database
	 * @throws SQLException
	 * @throws NamingException
	 */
	
	public static Connection openConnection() throws SQLException, NamingException{
		System.out.print("openConnection");
		Context ctx = new InitialContext();
		DataSource ds = (DataSource) ctx.lookup("TIWDS");		
		Connection con = ds.getConnection();
		return con;
	}

}
