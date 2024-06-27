package servlets;


import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/FrontController")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String urlVista="";    // declaro una variable inicialzada a vacio para empezar 
		String operation = request.getParameter("operation");
		
		urlVista=switch(operation) {
		case "doguardar"->{
			request.getRequestDispatcher("GuardarAction").include(request, response);
			yield "inicio.html";
		}
		case "doeliminar"->{
			request.getRequestDispatcher("EliminarAction").include(request, response);
			yield "inicio.html";
		}
		case "dobuscar"->{
			request.getRequestDispatcher("BuscarProductoAction").include(request, response);
			yield "productos.jsp";
		}
		
		case "toalta"->"alta.html";
		case "toProducto"->"producto.jsp";
		default->"inicio.html";
		};
		
		//Transferimoa el control a la vista definitiva
		request.getRequestDispatcher(urlVista).forward(request, response);
	}

	}


