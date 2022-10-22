package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Mutter;
import model.PostMutterLogic;
import model.User;
/**
 * Servlet implementation class Main
 */
@WebServlet("/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Get the tweet list from application scope
	  ServletContext application = request.getServletContext();
	  @SuppressWarnings("unchecked")
    List<Mutter> mutterList = (List<Mutter>) application.getAttribute("mutterList");
	  
	  // If it cannot get tweet list, create new tweet list
	  // and save to the application scope
	  if(mutterList == null) {
	    mutterList = new ArrayList<>();
	    application.setAttribute("mutterList", mutterList);
	  }
	  
	  // Get the user information to check if the user already login
	  HttpSession session = request.getSession();
	  User loginUser = (User) session.getAttribute("loginUser");
	  
	  if(loginUser == null) { // If the user wasn't login
	    // Redirect
	    response.sendRedirect("/EasyTweetApp/");
	  } else { // If the user already login
	    // Forward
	    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
	    dispatcher.forward(request, response);
	  }
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  // Get the request parameter
	  request.setCharacterEncoding("UTF-8");
	  String text = request.getParameter("text");
	  
	  // Check the text
	  if(text != null && text.length() != 0) {
	    // Get the tweet list from application scope
	    ServletContext application = this.getServletContext();
	    @SuppressWarnings("unchecked")
      List<Mutter> mutterList = (List<Mutter>) application.getAttribute("mutterList");
	    
	    // Get the user information from session scope
	    HttpSession session = request.getSession();
	    User loginUser = (User) session.getAttribute("loginUser");
	    
	    // Add the tweet to the tweet list
	    Mutter mutter = new Mutter(loginUser.getName(), text);
	    PostMutterLogic pml = new PostMutterLogic();
	    pml.execute(mutter, mutterList);
	  } else {
	    // Save the error message to request scope
	    request.setAttribute("errorMsg", "Tweet is empty");
	  }
	  
	  // Forward to the main.jsp
	  RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
	  dispatcher.forward(request, response);
	}

}
