package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import beans.Course;
import beans.dbConnection;

public class CourseDao {
	
	
	public static List<Course> getCourses() throws SQLException, NamingException {
		Connection con = dbConnection.openConnection();
		
		String sql = "SELECT * from Courses";
		PreparedStatement stm = con.prepareStatement(sql);
		ResultSet rs = stm.executeQuery();
		
		
		
		List<Course> courses = new ArrayList<Course>();
		while (rs.next()) {
			Course s = new Course(rs.getInt("id_course"), rs.getString("name"), rs.getString("school"), rs.getString("description"), rs.getString("academic_course"));
			courses.add(s);
		}
		
		con.close();
		
		return courses;
	}

}
