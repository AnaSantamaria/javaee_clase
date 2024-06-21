package servlets;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Resultado;
import service.Service;

@WebServlet("/BuscadorServlet")
public class BuscadorServlets extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Service service = new Service ();
		List<Resultado> resultado= service.buscar(request.getParameter("tematica"));
		request.setAttribute("paginas", resultado);
		request.getRequestDispatcher("resultados.jsp")
		.forward(request, response);
	}

}
