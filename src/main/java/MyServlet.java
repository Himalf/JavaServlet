
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
//request .send redirect

import jakarta.servlet.RequestDispatcher;

public class MyServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String principle =(request.getParameter("principle"));    
		String time = (request.getParameter("time"));  
		String rate = (request.getParameter("rate"));  
//		int si = (principle*time*rate)/100;
//		PrintWriter out = response.getWriter();
//		out.println("Simple Interest: "+si);
		request.setAttribute("principle", principle);
		request.setAttribute("time", time);
		request.setAttribute("rate", rate);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("MyDataServlet");
		rd.forward(request, response);
	
		
	}

	
}
