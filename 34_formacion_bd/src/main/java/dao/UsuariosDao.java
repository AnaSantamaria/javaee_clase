package dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import model.Usuario;

public class UsuariosDao {
	
	private static EntityManager eManager;// 
	static {																				
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("buscador");	
		eManager = factory.createEntityManager();											

	}
	
	public Usuario findByUsuarioAndPassword (String idusuario, String password){
		
		String jpql = "select u from Usuario u where u.idusuario=?1 and u.password=?2";
		TypedQuery<Usuario> query = eManager.createQuery(jpql, Usuario.class);
		query.setParameter(1, idusuario);
		query.setParameter(2, password);
		return query.getResultList().stream().findFirst().orElse(null);

		
		
		
	}

}
