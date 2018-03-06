package pl.coderslab.homework;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Servlet_02")
public class Servlet_02 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");

		String binNum = request.getParameter("binary");

		double counter = binNum.length() - 1;

		double sum = 0;

		for (int i = 0; i < binNum.length(); i++) {

			if (binNum.charAt(i) == '0' || binNum.charAt(i) == '1') {
				if (binNum.charAt(i) == '1') {
					sum = sum + Math.pow(2, counter);

				}
				counter--;

			} else {
				response.getWriter().append("<h4>To nie jest liczba binarna</h4>");
				return;
			}

		}
		response.getWriter().append("<h3>Liczba binarna: " + binNum + " to następująca liczba dziesiętna: " + sum + "</h3>");

	}

}
