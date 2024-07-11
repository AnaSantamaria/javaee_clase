package servlets;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Ficha;
import service.AutenticacionService;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
	AutenticacionService service=new AutenticacionService();
	RequestDispatcher dispatcher;
	
	
	if(service.autenticar(request.getParameter("usuario"),request.getParameter("password"))) {
		Ficha ficha = service.fichausuario(request.getParameter("usuario"));// creo el objeto
		request.setAttribute("ficha", ficha);//lo guardo
		
		//La cookie solo la creamos si queremos recordar al usuario
		if(request.getParameter("remember")!=null) {
			crearCookie(response,request.getParameter("usuario"));
			
		dispatcher=request.getRequestDispatcher("bienvenida.jsp");//envio la peticion
	}else {
		dispatcher=request.getRequestDispatcher("error.jsp");
	}
	dispatcher.forward(request, response);
}

}
	
	private void crearCookie(HttpServletResponse response,String usuario) {
		Cookie cookie=new Cookie("usuario",usuario );
		cookie.setMaxAge(10_000_000);
		response.addCookie(cookie);
		
	}
}