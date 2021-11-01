package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.User;
import beans.UserSession;
import dao.LoginDao;
import dao.UserDao;
import dao.UserSessionDao;


/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/userLogin")
public class LoginUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    /**
     * Logs in user by setting session attribute and then creating a usersession.
     * Then the the time of the user session start is also set as an attribute
     * Redirects an exsitis user to the home page and a new user to a page to
     * set their name and surname
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sUsername = request.getParameter("username");
		String sPassword = request.getParameter("password");
		
		User user = new User(sUsername, sPassword);
		HttpSession session = request.getSession();
		session.setAttribute("username", user.getUserId());
		
		try {
			boolean oldUser = LoginDao.validateLogin(user);
			String redirect = "";
			
			if(oldUser) {
				redirect = "waem8906.jsp";
			}else {
				UserDao.createUser(user);
				redirect = "newUser.jsp";
			}
			
			UserSession userSession = new UserSession(user.getUserId());
			UserSessionDao.createUserSession(userSession);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			session.setAttribute("start", sdf.format(userSession.getStartDateTime()));
			request.getRequestDispatcher(redirect).forward(request, response);

			} catch (SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
}
