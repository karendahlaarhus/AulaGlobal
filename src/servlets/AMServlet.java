package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Course;

/**
 * Servlet implementation class AMServlet
 */
@WebServlet({"/AMServlet", "*.html"})
public class AMServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "AulaMaster")
	private EntityManager em;
    /**
     * Default constructor. 
     */
    //public AMServlet() {
        // TODO Auto-generated constructor stub
    //}
   
    public void init() {
    	ServletContext context = getServletContext();
    }
		
	
    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<HTML>");
		out.println("<HEAD><TITLE>AMServlet</TITLE></HEAD>");
		out.println("<BODY bgcolor=\"#ffff66\">");
		out.println("<H1><FONT color=\"#666600\">Database: Users</FONT></H1></BR>");
		
		
		

		//Print the name of all sections
		Query query = em.createQuery("Select c from Courses c");
		List<Course> listCourses = query.getResultList();
		for (Course c : listCourses) {
			out.println("<h2> " +c.getName() +"</h2>");
		}
		
		
		
		
		out.println("</BODY></HTML>");

		out.close();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
