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
		String urlVista="";    // declaro una variable inicialzada a vacio para empezar 
		String operation = request.getParameter("operation");
		
		switch(operation) {
		case "doAlta":
			request.getRequestDispatcher("AltaAction").include(request, response);
			urlVista= "inicio.html";
			break;
		case "doEliminar":
			request.getRequestDispatcher("EliminarAction").include(request, response);
			urlVista= "inicio.html";
			break;
		
		case "doBuscar":
			request.getRequestDispatcher("BuscarAction").include(request, response);
			urlVista ="resultado.jsp";
			break;
		
		case "doBuscarGeneral":
			request.getRequestDispatcher("BuscadorGeneralAction").forward(request, response);
			urlVista= "buscarResultados.html";
			break;
		
		case "toBuscarGeneral":urlVista="tobuscarGeneral";break;
		case "toAlta":urlVista="alta.html";break;
		case "toBuscar":urlVista="buscar.jsp";break;
		case "toEliminar":urlVista="eliminar.html";break;
		default:urlVista="inicio.html";
		};
		
		//Transferimoa el control a la vista definitiva
		request.getRequestDispatcher(urlVista).forward(request, response);
	}

	}


