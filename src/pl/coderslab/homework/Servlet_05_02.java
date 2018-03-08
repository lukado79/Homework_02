package pl.coderslab.homework;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Servlet_05_02")
public class Servlet_05_02 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] name = request.getParameterValues("names");
		String[] price = request.getParameterValues("price");
		String[] volume = request.getParameterValues("numbers");
		
		for(int i = 0; i < name.length; i++) {
			Double priceD = Double.parseDouble(price[i]);
			Double volD = Double.parseDouble(volume[i]);
			
			if (priceD != 0 && volD != 0) {
				response.getWriter().append("<p>" + name[i] + " - " + volD + " x " + priceD + "zł = " + volD * priceD + " zł </p>");
				
			} else {
				response.getWriter().append("<p> Nie wprowadzono danych </p>");
			}
		}
	}

}
