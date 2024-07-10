package controller;

import java.io.IOException;
import java.io.PrintWriter;

import dtos.LibroDto;
import dtos.TemaDto;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.LibrosService;

@WebServlet("/AltaLibroController")
public class AltaLibroController extends HttpServlet {
	@Inject
	LibrosService service;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int isbn=Integer.parseInt(request.getParameter("isbn"));
		String titulo=request.getParameter("titulo");
		String autor= request.getParameter("autor");
		double precio= Double.parseDouble(request.getParameter("precio"));
		int paginas=Integer.parseInt(request.getParameter("paginas"));
		int idTema=	Integer.parseInt(request.getParameter("idTema"));
		
		LibroDto libro= new LibroDto(isbn,titulo,autor,precio,paginas,new TemaDto(idTema,null));
		//enviamos como respuesta a la petición AJAX un texto con el resultado
				//del alta. Serán las cadenas "true" o "false"
		PrintWriter out =response.getWriter();
		response.setContentType("text/plain");
		out.print(service.guardarLibro(libro));
		
}
}