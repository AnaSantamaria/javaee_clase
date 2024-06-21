package servlets;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
	String user=request.getParameter("username");//para recoger el nombre del usuario
	String pwd=request.getParameter("password"); // para recoger la password
	RequestDispatcher dispatcher;// objeto para usar la interfaz RequestDispatcher y redirigir a bienvenida o a error
	if(user.equals("admin")&&pwd.equals("pass")) {
		dispatcher=request.getRequestDispatcher("bienvenida.jsp");// redirige a bienvenida
	}else {
		dispatcher=request.getRequestDispatcher("error.jsp");// redirige a error
	}
	dispatcher.forward(request, response); // mantiene el control el programa sin mas interacción ni actuaciones del usuario
}

}