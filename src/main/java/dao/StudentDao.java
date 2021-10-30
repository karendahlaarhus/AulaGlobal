package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import beans.dbConnection;
import beans.Student;

public class StudentDao {
	
	public static void createStudent(Student student) throws SQLException, NamingException {		
		Connection con = dbConnection.openConnection();
		
		String sql = "INSERT INTO Students (nie, name, surname, date_of_birth) VALUES (?,?,?,?)";
		PreparedStatement stm = con.prepareStatement(sql);
		
		stm.setString(1, student.getNie());
		stm.setString(2, student.getName());
		stm.setString(3, student.getSurname());
		
		Date sqlBirthdate = new Date(student.getBirthdate().getTime());
		stm.setDate(4, sqlBirthdate);
		stm.executeUpdate();
		
		con.close();
	}
	
	public static List<Student> getStudents() throws SQLException, NamingException {
		Connection con = dbConnection.openConnection();
		
		String sql = "SELECT * from Students";
		PreparedStatement stm = con.prepareStatement(sql);
		ResultSet rs = stm.executeQuery();
		
		
		
		List<Student> students = new ArrayList<Student>();
		while (rs.next()) {
			Student s = new Student(rs.getString("nie"), rs.getString("name"), rs.getString("surname"), rs.getDate("date_of_birth"));
			students.add(s);
		}
		
		con.close();
		
		return students;
	}
	
	public static void deleteStudent(String nie) throws SQLException, NamingException {
		Connection con = dbConnection.openConnection();
		
		String sql =  "DELETE FROM Students WHERE nie = ?";
		PreparedStatement stm = con.prepareStatement(sql);
		stm.setString(1, nie);
		
		stm.executeUpdate();
		
		con.close();
		
	}
}
