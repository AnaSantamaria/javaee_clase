package dao;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import model.Curso;

public class CursosDao {
	private static EntityManager eManager;

	static {																				
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("formacion");	
		eManager = factory.createEntityManager();										

	
	public void save (Curso curso) {
		
		EntityTransaction tx = eManager.getTransaction();
		tx.begin();
		try {
			eManager.persist(curso);
			tx.commit();
		} catch (Exception ex) {
			tx.rollback();
		}
		
	
		
		
	}
	
  public List<Curso> findByPrice( int precioMax){
	  
	  
  }
  
  public void deleteByName( String nombre) {
	  
  }
	  
	  
	}
  
  

