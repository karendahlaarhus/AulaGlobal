package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.User;
import dao.LoginDao;
import dao.UserDao;


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
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		User user = new User(username, password);
		HttpSession session = request.getSession();
		session.setAttribute("username", user.getUserId());
		
		boolean loggedin;
		try {
			loggedin = LoginDao.validateLogin(user);
			if(loggedin) {
				request.getRequestDispatcher("students.jsp").forward(request, response);
			}else {
				UserDao.createUser(user);
				request.getRequestDispatcher("newUser.jsp").forward(request, response);
			}} catch (SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}	
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		doPost(request, response);
	}
    
    
}
