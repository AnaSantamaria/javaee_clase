package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.google.gson.Gson;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Curso;
import service.CursosService;

@WebServlet("/FindAction")
public class FindAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CursosService service=new CursosService();
		List<Curso> cursos=service.buscarPorPrecio(Double.parseDouble(request.getParameter("precio")));
		
		Gson gson=new Gson();
		PrintWriter out=response.getWriter();
		response.setContentType("application/json");
		out.println(gson.toJson(cursos));
	
		
		
	}

}
