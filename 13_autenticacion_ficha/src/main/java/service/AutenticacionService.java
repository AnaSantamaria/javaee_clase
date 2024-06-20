package service;

import java.util.List;

import model.Ficha;

public class AutenticacionService {
	private final String USER="Admin";
	private final String PASSWORD="curso";
	List<Ficha> fichas= List.of(new Ficha("ar", 19,"aa@gmail.com"),
			new Ficha("admin", 24,"admoin@gmail.com"),
			new Ficha("jose", 49,"jos@gmail.com"),
			new Ficha("hup", 35,"ddd@gmail.com")
			);
			
	public boolean autenticar(String usuario, String password) {
		return usuario.equals(USER)& password.equals(PASSWORD);
		
		
	}
	
    public Ficha fichausuario(String usario) {
    	return fichas.stream()
    			.filter(f->f.getUsuario().equals(usario))
    			.findFirst()
    			.orElse(new Ficha());
	
}
	
}
