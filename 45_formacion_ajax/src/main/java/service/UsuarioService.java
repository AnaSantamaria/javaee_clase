package service;

import dao.UsuariosDao;
import model.Usuario;

public class UsuarioService {

	UsuariosDao dao = new UsuariosDao();

	public boolean validarUsuario (String idusuario ,String password) {
		return dao.findByUsuarioAndPassword(idusuario, password)!=null;
		
	}	
		
}	 
		 
		
	
		

