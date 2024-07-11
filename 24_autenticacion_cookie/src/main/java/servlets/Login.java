package servlets;

import java.io.IOException;

import org.apache.tomcat.util.http.parser.Cookie;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Ficha;
import service.AutenticacionService;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
	String user=request.getParameter("username");
	String pwd=request.getParameter("password");
	RequestDispatcher dispatcher;
	//instancio la clase service
	var service = new AutenticacionService();
	
	if(service.autenticar(user, pwd)) {
	//creamos la ficha 	del usuario y la guardamos en un atributo
	Ficha ficha = service.fichausuario(user);// creoi el objeto
	request.setAttribute("ficha", ficha);//lo guardo
		dispatcher=request.getRequestDispatcher("bienvenida.jsp");//envio la peticion
	}else {
		dispatcher=request.getRequestDispatcher("error.jsp");
	}
	dispatcher.forward(request, response);
}
	private void crearCookie(HttpServletResponse response,String usuario) {
		Cookie cookie=new Cookie("usuario",usuario );
		cookie.setMaxAge(10_000_000);
		response.addCookie(cookie);
		
	}		

}