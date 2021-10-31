package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		
		User user = new User(name, password);
		
	
		boolean loggedin = LoginAccessDao.validateLogin(user);
		
		if(loggedin) {
			HttpSession session = request.getSession();
			session.setAttribute("name", user.getName());
			session.setAttribute("surname", user.getSurname());
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("noAccess.jsp").forward(request, response);
		}
	
	}	
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		doPost(request, response);
	}
    
    
}
