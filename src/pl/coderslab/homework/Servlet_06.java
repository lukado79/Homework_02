package pl.coderslab.homework;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Servlet_06")
public class Servlet_06 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");

		String[] numbers = request.getParameterValues("num");
		Double sum = (double) 0;
		Double mult = (double) 1;

		try {
			response.getWriter().append("<p>Liczby:").append("</p>");
			for (int i = 0; i < numbers.length; i++) {
				Double num = Double.parseDouble(numbers[i]);
				response.getWriter().append("<p> - " + num + "</p>");
				sum += num;
				mult *= num;

			}
			response.getWriter().append("<p>Średnia: <br>" + " - " + sum / (numbers.length) + "</p>");
			response.getWriter().append("<p>Suma: <br>" + " - " + sum + "</p>");
			response.getWriter().append("<p>Iloczyn: <br>" + " - " + mult + "</p>");
		} catch (NumberFormatException e) {
			response.getWriter().append("<p>Nie podano liczby</p>");
		}

	}

}

// W projekcie stwórz servlet Servlet_06, oraz stronę HTML index.html, w której
// zawarty jest formularz przesyłający (metodą GET) 4 parametry liczbowe o
// nazwie num. Po przejściu do servletu oblicz ich średnią, sumę oraz iloczyn i
// zwróć wynik w przeglądarce:
//
// Liczby:
// - x1
// - x2
// - x3
// - x4
// Średnia:
// - średnia
// Suma:
// - suma
// Iloczyn:
// - iloczyn
