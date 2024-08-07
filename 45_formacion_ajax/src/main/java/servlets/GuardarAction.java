package servlets;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Curso;
import service.CursosService;

@WebServlet("/Guardaraction")
public class GuardarAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CursosService service=new CursosService();
		boolean res=service.guardarNuevoCurso(new Curso(0,request.getParameter("nombre"),
				request.getParameter("tematica"),
				Integer.parseInt(request.getParameter("duracion")),
				Double.parseDouble(request.getParameter("precio"))));
		if(!res) {
			request.setAttribute("mensaje", "Ya existe un curso con ese nombre!");
		}
		
		
	}

}
