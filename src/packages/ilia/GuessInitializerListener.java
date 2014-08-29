package packages.ilia;

import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionEvent;

public class GuessInitializerListener implements HttpSessionListener {

	public static String MAX = "max";
	public static String MIN = "min";
	public static String NUMBER_TO_GUESS = "number_to_guess";
	public static String MAX_NUM_OF_ATTEMPTS = "max_num_of_attempts";
	public static String NUM_OF_ATTEMPTS = "num_of_attempts";


	@Override
	public void sessionCreated(HttpSessionEvent event) {
		int imin = Integer.parseInt(event.getSession().getServletContext().getInitParameter(MIN));
		int imax = Integer.parseInt(event.getSession().getServletContext().getInitParameter(MAX));
		int inumber_to_guess = (int) (Math.random()*(imax - imin + 1));

		event.getSession().setAttribute(NUMBER_TO_GUESS, inumber_to_guess);
		event.getSession().setAttribute(NUM_OF_ATTEMPTS, 0);

		System.out.println("sessionCreated Called");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		System.out.println("sessionDestroyed Called");
		
	}

}
