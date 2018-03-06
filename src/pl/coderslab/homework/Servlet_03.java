package pl.coderslab.homework;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Servlet_03")
public class Servlet_03 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().append("<form action='' method='post'>");

		for (int i = 0; i < 5; i++) {
			response.getWriter().append("<form action=' 'method='post'><input name='numbers' /><br>");

		}
		response.getWriter().append("<input type='submit'/>");
		response.getWriter().append("</form>");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		HttpSession sess = request.getSession();
		Object number = sess.getAttribute("numbers");
		
		if(number !=null) {
			sess.setAttribute("number", number);
			response.getWriter().append("<h3>" + number + "</h3>");
		}
		
		
		
		

	}

}
