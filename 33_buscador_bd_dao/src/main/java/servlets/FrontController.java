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
		
		urlVista=switch(operation) {
		case "doAlta"->{
			request.getRequestDispatcher("AltaAction").include(request, response);
			yield "inicio.html";
		}
		case "doEliminar"->{
			request.getRequestDispatcher("EliminarAction").include(request, response);
			yield "inicio.html";
		}
		case "doBuscar"->{
			request.getRequestDispatcher("BuscarAction").include(request, response);
			yield "resultado.jsp";
		}
		case "doBuscarGeneral"->{
			request.getRequestDispatcher("BuscadorGeneralAction").include(request, response);
			yield "resultados.jsp";
		}
		case "toBuscarGeneral"->"tobuscarGeneral";
		case "toAlta"->"alta.html";
		case "toBuscar"->"buscar.jsp";
		case "toEliminar"->"eliminar.html";
		default->"inicio.html";
		};
		
		//Transferimoa el control a la vista definitiva
		request.getRequestDispatcher(urlVista).forward(request, response);
	}

	}


