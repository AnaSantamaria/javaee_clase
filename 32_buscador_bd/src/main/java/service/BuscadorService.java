package service;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import model.Resultado;

public class BuscadorService {
	
	private EntityManager eManager;
	public BuscadorService() {
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("buscador");
		eManager=factory.createEntityManager();
		
	}
	
	
	//Metodos logica de negocio
	
	
  public void altaResultados(Resultado resultado) {
	  EntityTransaction tx=eManager.getTransaction();// es necesario iniciar y cerrar la transacci´n para validarla y que se realice
	  tx.begin();
	  try {
		eManager.persist(resultado);
		tx.commit();
	}catch(Exception ex) {
		tx.rollback();
	}
  }
  
  public Resultado buscarResultadoPorId (int idResultado) {
	return eManager.find(Resultado.class, idResultado);
	
	
}
  public void eliminarResultado(int idResultado) {
		Resultado resultado=buscarResultadoPorId(idResultado);
		if(resultado!=null) {
			  EntityTransaction tx=eManager.getTransaction();
			  tx.begin();
			eManager.remove(resultado);
			tx.commit();
		}
		
		
	}
  
  public List<Resultado>resultadosPorTematica(String Tematica){
	  String jpql="select r from Resultado r where r.tematica=?1";
			  
	  TypedQuery<Resultado> query = eManager.createQuery(jpql,Resultado.class);
	  query.setParameter(1, Tematica);
	  return query.getResultList();
	  
	 
		
  }
  
  public Resultado buscarPorUrl (String url) {
	  
	  String jpql="select r from Resultado r where r.url=?1";
	  TypedQuery<Resultado> query = eManager.createQuery(jpql,Resultado.class);
	  query.setParameter("url", url);
	  return query.getResultList().stream()
			  .findFirst().orElse(null);
	  
	  /*try {
		return query.getSingleResult();
	}
	catch(NoResultException ex) {
		return null;
	}
	catch(NonUniqueResultException ex) {
		return query.getResultList().get(0);
	}*/ 
	
	}
  public void eliminarResultadosPorTematica (String Tematica) {
	  String jpql="delete  from Resultado r where r.tematica=?1";
	  Query query=eManager.createQuery(jpql);
	  query.setParameter(1, Tematica);
	  EntityTransaction tx=eManager.getTransaction();
	  tx.begin();
	  query.executeUpdate();
	  tx.commit();
  }
}

