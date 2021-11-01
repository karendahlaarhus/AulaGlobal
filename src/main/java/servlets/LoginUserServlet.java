package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.User;
import dao.LoginAccessDao;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/userlogin")
public class LoginUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	boolean loggedin = false;
    	String sName = request.getParameter("name");
		String sPassword = request.getParameter("password");
		
		User newUser = new User(sName, sPassword);
		
		loggedin = LoginAccessDao.validateLogin(newUser);
		
		if(loggedin) {
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("noAccess.jsp").forward(request, response);
		}
		
	}	
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    	doPost(request, response);
    }

}
