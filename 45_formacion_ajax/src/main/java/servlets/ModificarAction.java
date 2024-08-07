package servlets;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.CursosService;

@WebServlet("/ModificarAction")
public class ModificarAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CursosService service=new CursosService();
		if(!service.modificarDuracion(request.getParameter("nombre"), Integer.parseInt(request.getParameter("nuevaDuracion")))) {
			request.setAttribute("mensaje", "Ese curso no existe");
		}
		
	}

}
