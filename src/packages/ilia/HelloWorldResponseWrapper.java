package packages.ilia;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class HelloWorldResponseWrapper extends HttpServletResponseWrapper {

	public HelloWorldResponseWrapper(HttpServletResponse response) {
		super(response);
		// TODO Auto-generated constructor stub
	}

}
