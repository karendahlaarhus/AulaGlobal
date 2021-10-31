package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.EnrolledStudent;
import dao.EnrolledStudentsDao;

/**
 * Servlet implementation class EnrollStudentServlet
 */
@WebServlet({ "/EnrollStudentServlet", "/enrollStudent" })
public class EnrollStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnrollStudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sNie = request.getParameter("nie");
		String sCourse = request.getParameter("course");
		
		int iCourse = Integer.parseInt(sCourse);
		EnrolledStudent es = new EnrolledStudent(sNie, iCourse);
		
		try {
			EnrolledStudentsDao.enrollStudent(es);
		} catch (SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect(request.getHeader("Referer"));

		
		
	}

}
