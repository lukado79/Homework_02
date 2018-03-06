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
		String money = request.getParameter("calc");

		Double eur = 4.37;
		Double usd = 4.11;

		Double[] rate = { eur / usd, usd / eur, eur, usd }; 

		if (currency == null && money == null) {
			response.getWriter().append("<h1>Nie wprowadzono danych</h1>");
		} else {

			try {
				

				Double currD = Double.parseDouble(currency);
				if ("EuUs".equals(money)) {
					response.getWriter().append("<h3>Przeliczam waluty</h3><br>");
					response.getWriter().append(currency + " EUR to " + currD * rate[0] + " USD.").append("<br>");

				} else if ("UsEu".equals(money)) {
					response.getWriter().append("<h3>Przeliczam waluty</h3><br>");
					response.getWriter().append(currency + " USD to " + currD * rate[1] + " EUR.").append("<br>");

				} else if ("EuPl".equals(money)) {
					response.getWriter().append("<h3>Przeliczam waluty</h3><br>");
					response.getWriter().append(currency + " EUR to " + currD * rate[2] + " PLN.").append("<br>");

				} else if ("PlEu".equals(money)) {
					response.getWriter().append("<h3>Przeliczam waluty</h3><br>");
					response.getWriter().append(currency + " PLN to " + currD / rate[2] + " EUR.").append("<br>");

				} else if ("UsPl".equals(money)) {
					response.getWriter().append("<h3>Przeliczam waluty</h3><br>");
					response.getWriter().append(currency + " USD to " + currD * rate[3] + " PLN.").append("<br>");

				} else {
					response.getWriter().append("<h3>Przeliczam waluty</h3><br>");
					response.getWriter().append(currency + " PLN to " + currD / rate[3] + " USD.").append("<br>");

				}
			} catch (NumberFormatException e) {
				response.getWriter().append("Błędne parametry");
			}

		}

	}

}
