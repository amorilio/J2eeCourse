package packages.ilia;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static packages.ilia.GuessInitializerListener.*;

public class GuessStartServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)	throws ServletException, IOException 
	{
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>");

		int max_num_of_attempts = Integer.parseInt(req.getServletContext().getInitParameter(MAX_NUM_OF_ATTEMPTS));
		
		int number_of_attempts = (int)req.getSession().getAttribute(NUM_OF_ATTEMPTS);
		number_of_attempts = number_of_attempts + 1;
		req.getSession().setAttribute(NUM_OF_ATTEMPTS, number_of_attempts);		
				
		int number_to_guess = (int)req.getSession().getAttribute(NUMBER_TO_GUESS);
		
		int number_guess = Integer.parseInt(req.getParameter("guess_number"));
		
		if ( number_of_attempts >= max_num_of_attempts ){
			out.println("You Lost! The number to guess is:"+ number_to_guess);
		} else if (number_to_guess > number_guess) {			
			req.getSession().setAttribute("message", "Too low.");
			RequestDispatcher RequetsDispatcherObj =req.getRequestDispatcher("/Main.jsp");
			RequetsDispatcherObj.forward(req, resp);
			
		} else if (number_to_guess < number_guess) {			
			req.getSession().setAttribute("message", "Too high.");
			RequestDispatcher RequetsDispatcherObj =req.getRequestDispatcher("/Main.jsp");
			RequetsDispatcherObj.forward(req, resp);
		} else {
			out.println("Too Won. In " + number_of_attempts + " attempts");
		}
				
		out.println("</h1>");
		out.println("</body>");
		out.println("</html>");
	}
}
