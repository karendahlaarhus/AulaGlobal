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
import javax.servlet.http.HttpSession;

import beans.UserSession;
import dao.UserSessionDao;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/userLogout")
public class LogoutUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * Logs out a user by deliting the session attribute "username" and then updates
	 * the user session created to the user by adding the end time of the session
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String sUsername = session.getAttribute("username").toString();
		session.removeAttribute("username");
		
		String sUserSessionStart = session.getAttribute("start").toString();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			Date dUserSessionStart = sdf.parse(sUserSessionStart);
			UserSession userSession = new UserSession(sUsername, dUserSessionStart);
			UserSessionDao.endUserSession(userSession);
		} catch (ParseException | SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		
		
		response.sendRedirect("index.jsp");
		
	}

}
