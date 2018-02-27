package pl.coderslab.homework;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Servlet_01")
public class Servlet_01 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		
		String currency = request.getParameter("waluta");
		
		Double[] rate = {4.37, 4.11}; //EUR, USD
		
		
		
		if (currency == null) {
			response.getWriter().append("Nie wprowadzono ilości waluty");
		} else {
			
		}
		
	}

}
