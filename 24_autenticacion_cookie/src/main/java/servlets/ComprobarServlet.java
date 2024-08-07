package servlets;

import java.io.IOException;
import java.util.Arrays;

import org.apache.tomcat.util.http.parser.Cookie;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.AutenticacionService;

@WebServlet ("/ComprobarServlet")
public class ComprobarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	
		
		protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// Comprobar si llega la cookie "user"
			/*String usuario=null;
			Cookie[] cookies=request.getCookies();
			if(cookies!=null) {
				for(Cookie ck:cookies) {
					if(ck.getName().equals("usuario")) {
						usuario=ck.getValue();
						break;
					}
				}
			}*/
			String usuario=Arrays.stream(request.getCookies()!=null?request.getCookies():new Cookie[0])
						.filter(c->c.getName.equals("usuario"))
						.findFirst()
						.orElse(new Cookie("usuario",null))
						.getValue();
			
			if(usuario==null) {
				request.getRequestDispatcher("login.html").forward(request, response);
			}else {
				//recoge la ficha del usuario antes de pasar el control a bienvenida.jsp
				AutenticacionService service=new AutenticacionService();
				request.setAttribute("ficha", service.fichausuario(usuario));
				request.getRequestDispatcher("bienvenida.jsp").forward(request, response);
			}
		}

	
		
		
	}


