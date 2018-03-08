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
		HttpSession sess = request.getSession();
		Object numsV = sess.getAttribute("numbers");
		

		response.getWriter().append("<form action='Servlet_03' method='post'>");

		for (int i = 0; i < 5; i++) {
			response.getWriter().append("<input name='numbers' /><br>");
		     if (numsV != null) {
	                String[] tablica = (String[]) numsV;
	                for (int j = i - 1; j < tablica.length; j++) {
	                    response.getWriter().append("value = '" + tablica[j] + "'");
	                }

	            }
		}
		response.getWriter().append("<input type='submit'/>");
		response.getWriter().append("</form>");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		
		String[] nums = request.getParameterValues("numbers");
		
		
		
		HttpSession sess = request.getSession();
		
		sess.setAttribute("numbers", nums);
		
		Object numsV = sess.getAttribute("numbers");
		
		if(numsV != null) {
			String[] arrnum	= (String[]) numsV;
			for (int i = 0; i < arrnum.length; i++) {
				response.getWriter().append(nums[i] + "<br>");
			}
		} else {
			response.getWriter().append("<p>Nie ma obiektu w sesji</p>");
		}
		
		
		

	}

}
