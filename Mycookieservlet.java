
import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * Servlet implementation class Mycookieservlet
 */
@WebServlet("/Mycookieservlet")
public class Mycookieservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Mycookieservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPOST(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		   String userInput = request.getParameter("userInput");

	        // Create a cookie with the entered value
	        Cookie userCookie = new Cookie("savedUser", userInput);
	        userCookie.setMaxAge(60*60*24*365); // Cookie will last for one year
	        response.addCookie(userCookie);

	        // Redirect back to the form page
	        response.sendRedirect("Login.html");
	    }

	    @Override
	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        // Get the cookies
	        Cookie[] cookies = request.getCookies();
	        String savedUser = null;

	        // Check if the savedUser cookie exists
	        if (cookies != null) {
	            for (Cookie cookie : cookies) {
	                if (cookie.getName().equals("savedUser")) {
	                    savedUser = cookie.getValue();
	                    break;
	                }
	            }
	        }

	        // Forward the value to the JSP page
	        request.setAttribute("savedUser", savedUser);
	        request.getRequestDispatcher("/Myfile.jsp").forward(request, response);


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost1(request, response);
	}

}