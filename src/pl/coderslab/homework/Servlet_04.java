package pl.coderslab.homework;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Servlet_04")
public class Servlet_04 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//To działa ale chyba nie do końca tak jak powinno

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		Cookie[] cookies = request.getCookies();
		Integer counter = 0;
		String cookieValue = null;
		if (cookies != null) {
			for(Cookie c: cookies) {
				counter++;
				if("visitored".equals(c.getName())) {
					response.getWriter().append("<h3>Wartość ciasteczka: " + c.getValue() + "</h3><br>");
					response.getWriter().append("<h3> Odwiedziłeś nas już: " + counter + " razy</h3>");
					
				}else {
					response.getWriter().append("<h3>Witaj pierwszy raz na naszej stronie</h3>");
					Cookie newCookie = new Cookie("visitored", "1");
					newCookie.setMaxAge(60 * 60 * 24 * 365);
					response.addCookie(newCookie);
				}
			}
			
		}
		response.getWriter().append("Nie ma takiego ciasteczka");
// Tu próbowałem alternatywy ale nie działało
		
		
//		if (cookies != null) {
//			for (int i = 0; i < cookies.length; i++) {
//				Cookie c = cookies[i];
//				if (c.getName() != "visitsd") {
//					response.getWriter().append("<h3>Witaj pierwszy raz na naszej stronie</h3>");
//					Cookie newCookie = new Cookie("visitsd", "1");
//					newCookie.setMaxAge(60 * 60 * 24 * 365);
//					response.addCookie(newCookie);
//
//				} else {
//					response.getWriter().append("<h3>Wartość ciasteczka: " + c.getValue() + "</h3><br>");
//					response.getWriter().append("<h3> Odwiedziłeś nas już: " + i + " razy</h3>");
//
//				}
//			}
//		} else {
//			response.getWriter().append("Brak ciasteczek");
//		}

	}

}
// W projekcie stwórz servlet Servlet_04. Celem zadania jest wyświetlanie ilości
// wizyt na stronie. W servlecie:
//
// Sprawdź czy użytkownik posiada zapisane ciasteczko o nazwie visits:
// jeśli nie, wyświetl komunikat: Witaj pierwszy raz na naszej stronie oraz
// dodaj ciasteczko o nazwie visits zapisując mu wartość 1 i czas ważności 1
// rok.
// jeśli ciasteczko jest zapisane, pobierz jego aktualną wartość i wypisz na
// stronie komunikat Witaj, odwiedziłeś nas już X razy. Zwiększ też wartość
// ciasteczka o 1.
