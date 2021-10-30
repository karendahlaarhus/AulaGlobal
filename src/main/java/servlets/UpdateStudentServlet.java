package servlets;

import java.io.IOException;
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

import beans.Student;
import dao.StudentDao;

/**
 * Servlet implementation class UpdateStudentServlet
 */
@WebServlet("/updateStudent")
public class UpdateStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateStudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sNie = request.getParameter("nie");
		String sFirstname = request.getParameter("firstname");
		String sSurname = request.getParameter("surname");
		String sBirthDate = request.getParameter("birthdate");
		
		try {
			SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd");
			Date dBirthDate = dateFormater.parse(sBirthDate);
			StudentDao.updateStudent(sNie, sFirstname, sSurname, dBirthDate);
		} catch (ParseException | SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
