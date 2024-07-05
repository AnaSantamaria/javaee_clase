package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/FrontController")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op=request.getParameter("operation");
		String urlView="";
		switch(op) {
			case "doTemas"->{
				request.getRequestDispatcher("TemasAction").include(request, response);
				urlView="buscador.jsp";
			}
			case "doLibros"->{
				request.getRequestDispatcher("LibrosAction").forward(request, response);
				return;
			}
			
			default->urlView="inicio.html";
		};
		request.getRequestDispatcher(urlView).forward(request, response);
	}


}
