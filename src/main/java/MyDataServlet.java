

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class MyDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	try {
		double p = Double.parseDouble(request.getParameter("principle"));
		double t = Double.parseDouble(request.getParameter("time"));
		double r = Double.parseDouble(request.getParameter("rate"));
		if(p<0||t<0||r<0){
			
			RequestDispatcher rd = request.getRequestDispatcher("error.html");
			rd.forward(request, response);
		}
		else {
			double si = (p*t*r)/100;
			PrintWriter out = response.getWriter();
			out.println("Simple Interest: "+si);
		}
	} catch (Exception e) {
		RequestDispatcher rd = request.getRequestDispatcher("trycatch.html");
		rd.forward(request, response);
	}
	}

	

}
