package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/SaludosServlet")
public class SaludoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//lo primero es llamar al metodo setContentType
		
		response.setContentType("text/html");
		
		//se programa el printwriter con un try con recursos para que se cierre solo
		 try(PrintWriter out=response.getWriter()){
			 out.println("<<html><head></head><body><body><center> ");
			 for(int i=1;i<=6;i++) {
				 out.println("<h" +i+">Biienvenidos humanoides</h"+i+">");
				 
			 }
			 out.println("</center></body></html>");// intrucción de cerrar
		 }
		
	}

}
