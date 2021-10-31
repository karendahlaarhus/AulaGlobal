package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import beans.EnrolledStudent;
import beans.Student;
import beans.dbConnection;

public class EnrolledStudentsDao {
	
	public static List<Student> getStudentsInCourse(int courseId) throws SQLException, NamingException {
		Connection con = dbConnection.openConnection();
		
		String sql = "SELECT nie, name, surname, date_of_birth FROM Students JOIN EnrolledStudent "
				+ "ON Students.nie = EnrolledStudent.nie_student"
				+ " WHERE EnrolledStudent.id_course = ?";
		PreparedStatement stm = con.prepareStatement(sql);
		stm.setInt(1, courseId);
		ResultSet rs = stm.executeQuery();
		
		List<Student> students = new ArrayList<Student>();
		while (rs.next()) {
			Student s = new Student(rs.getString("nie"), rs.getString("name"), rs.getString("surname"), rs.getDate("date_of_birth"));
			students.add(s);
		}
		
		con.close();
		
		return students;
	}
	
	public static void enrollStudent(EnrolledStudent es) throws SQLException, NamingException {
		Connection con = dbConnection.openConnection();
		
		String sql = "INSERT INTO EnrolledStudent (nie_student, id_course) VALUES (?, ?)";
		PreparedStatement stm = con.prepareStatement(sql);
		stm.setString(1, es.getNieStudent());
		stm.setInt(2, es.getIdCourse());
		stm.executeUpdate();
		
		con.close();
		
	}
	
	public static void removeStudent(EnrolledStudent es) throws SQLException, NamingException {
		Connection con = dbConnection.openConnection();
		
		String sql = "DELETE FROM EnrolledStudent WHERE nie_student = ? AND id_course = ?";
		PreparedStatement stm = con.prepareStatement(sql);
		stm.setString(1, es.getNieStudent());
		stm.setInt(2, es.getIdCourse());
		stm.executeUpdate();
		
		con.close();
	}
	
}
