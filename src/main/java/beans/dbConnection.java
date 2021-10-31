package beans;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class dbConnection {
	
	static final String DB_URL = "jdbc:mysql://localhost:3306/BD89_06_aulamaster";
	static final String USER = "admin";
	static final String PASSWORD = "Klinkekule3";
	static final String DATA_SOURCE = "BD89_06_aulamaster";
	
	public static Connection openConnection() throws SQLException, NamingException{
		System.out.print("openConnection");
		Context ctx = new InitialContext();
		DataSource ds = (DataSource) ctx.lookup("TIWDS");		
		Connection con = ds.getConnection();
		return con;
	}

}
