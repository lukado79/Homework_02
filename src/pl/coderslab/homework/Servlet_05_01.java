package pl.coderslab.homework;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Servlet_05_01")
public class Servlet_05_01 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter w = response.getWriter();
		
		w.append("<form action='Servlet_05_01' method='post'>");
		w.append("<h3>Dodaj produkt do koszyka</h3>");
		w.append("Nazwa: <input type='text' name='names'/><br>");
		w.append("Ilość: <input type='number' name='numbers'/><br>");
		w.append("Cena: <input type='number' name='price'/><br>");
		w.append("<div><input type='submit' value='Wyślij' /></div></form>"); // zamiast tego damy href i prześlemy dane to będzie post
	
		w.append("<a href='Servlet_05_02'> Sprawdź zawartość koszyka </a><br>"); // to tylko sprawdzi nam zawartość koszyka tu damy form action i method get
		

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		//tu utworzymy sesję i pobierzemy dane 
		
		
		String[] name = request.getParameterValues("names");
		String[] price = request.getParameterValues("price");
		String[] volume = request.getParameterValues("numbers");
		
		for(int i = 0; i < name.length; i++) {
			Double priceD = Double.parseDouble(price[i]); // to do drugiego pliku jak pobierzemy dane z sesji 
			Double volD = Double.parseDouble(volume[i]);
			
			if (priceD != 0 && volD != 0) {
				response.getWriter().append("<p>" + name[i] + " - " + volD + " x " + priceD + "zł = " + volD * priceD + " zł </p>");
				
			} else {
				response.getWriter().append("<p> Nie wprowadzono danych </p>");
			}
		}
		

	}

}
// W projekcie stwórz servlet Servlet_05_1 oraz Servlet_05_2. Celem zadania jest
// przechowywanie koszyka zakupowego.
//
// 1.Stwórz formularz z polem tekstowym (nazwa) oraz dwoma numerycznymi (ilość i
// cena) służącymi do dodawania produktu do koszyka. Formularz powinien być
// przesłany na tą samą stronę metodą POST.
// 2.Po przesłaniu danych metodą POST przesłany produkt wraz z ceną i ilością
// dodaj do sesji pod kluczem basket. Pamiętaj, iż klucz basket w sesji musi
// przechowywać więcej niż 1 produkt (użyj tablicy). Po dodaniu elementu do
// koszyka wyświetl komunikat Produkt dodany i formularz służący do dodanie
// następnego produktu (taki sam jak w punkcie 1).
// 3.Na stronie formularza dodaj odnośnik do strony wyświetlającej zawartość
// koszyka.
// 4.W servlecie Servlet_05_2 wyświetl zawartość koszyka oraz sumę cen
// produktów,
// pamiętaj iż każdy produkt ma dodaną ilość.
//
// Przykład - strona koszyka:
//
// Produkt 1 - 4 x 5.20zł = 20.80zł
// Produkt 2 - 1 x 9.99zł = 9.99zł
// Produkt 3 - 1 x 2.20zł = 2.20zł
// SUMA: 32.99zł
