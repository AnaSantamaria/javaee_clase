package service;

import java.util.ArrayList;
import java.util.List;

import model.Ficha;
import model.Usuario;

public class AutenticacionService {
	
	
	List<Usuario> usuarios = new ArrayList<>(List.of(
			new Usuario("user1","pwd1"),
			new Usuario("user2","pwd2"),
			new Usuario("user3","pwd3"),
			new Usuario("user4","pwd4")
			));
	
	List<Ficha> fichas= List.of(new Ficha("ar", 19,"aa@gmail.com"),
			new Ficha("Admin", 24,"admoin@gmail.com"),
			new Ficha("jose", 49,"jos@gmail.com"),
			new Ficha("hup", 35,"ddd@gmail.com")
			);
			
	public boolean autenticar(String usuario, String password) {
		for(Usuario u:usuarios) {
		if(u.getUsuario().equals(usuario)&&u.getPassword().equals(password)) {
			
			return true;
		}
			
		}
		return false;
		
	}
	
    public Ficha fichausuario(String usario) {
    	return fichas.stream()
    			.filter(f->f.getUsuario().equals(usario))
    			.findFirst()
    			.orElse(new Ficha());
	
}
	
}
