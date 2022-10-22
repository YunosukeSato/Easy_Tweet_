package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.LoginLogic;
import model.User;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  // Get the request parameter
	  request.setCharacterEncoding("UTF-8");
	  String name = request.getParameter("name");
	  String pass = request.getParameter("pass");
	  
	  // Create instance of User
	  User user = new User(name, pass);
	  
	  // Process the login
	  LoginLogic loginLogic = new LoginLogic();
	  boolean isLogin = loginLogic.execute(user);
	  
	  // If this login succesful
	  if(isLogin) {
	    HttpSession session = request.getSession();
	    session.setAttribute("loginUser", user);
	  }
	  
	  // Forward to the loginResult
	  RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/loginResult.jsp");
	  dispatcher.forward(request, response);
	}

}
