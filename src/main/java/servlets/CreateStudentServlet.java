package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StudentDao;
import beans.Student;

/**
 * Servlet implementation class StudentServlet
 */
@WebServlet("/createStudent")
public class CreateStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateStudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sNie = request.getParameter("nie");
		String sFirstname = request.getParameter("firstname");
		String sSurname = request.getParameter("surname");
		String sBirthDate = request.getParameter("birthdate");
		
		try {
			SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd");
			Date dBirthDate = dateFormater.parse(sBirthDate);
			Student newStudent = new Student(sNie, sFirstname, sSurname, dBirthDate);
			StudentDao.createStudent(newStudent);
		} catch (ParseException | SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}


}
