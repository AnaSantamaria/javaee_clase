package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.UsuarioService;

import java.io.IOException;

@WebServlet("/UsuarioAction")
public class UsuarioAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UsuarioService service = new UsuarioService();
		service.validarUsuario(Usuario, LEGACY_DO_HEAD)
	}

}
