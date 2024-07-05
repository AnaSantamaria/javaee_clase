package dao;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import model.Curso;

public class CursosDao {
	private static EntityManager eManager;

	static {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("formacion");
		eManager = factory.createEntityManager();

	}

	public void save(Curso curso) {

		EntityTransaction tx = eManager.getTransaction();
		tx.begin();
		eManager.persist(curso);
		tx.commit();

	}

	public Curso findBNombre (String nombre) {
	String jpql = "select c from Curso c where c.nombre=?1";
	
	TypedQuery<Curso> query = eManager.createQuery(jpql, Curso.class);
	query.setParameter(1, nombre);
	try {
	return  query.getSingleResult();

	}catch(NoResultException ex){
		return null;
	}
	
	
	  
  }

	public void deleteByNombre(String nombre) {
		String jpql = "delete c from Curso c where c.nombre=?1";
		Query query = eManager.createQuery(jpql);
		query.setParameter(1, nombre);
		EntityTransaction tx = eManager.getTransaction();
		tx.begin();
		query.executeUpdate();
		tx.commit();

	}

	public void updateDuracion(String nombre, int nuevaDuracion) {

		String jpql = "update Curso c set c.duracion=?1 where c.nombre =?2";
		Query query = eManager.createQuery(jpql);
		query.setParameter(1, nuevaDuracion);
		query.setParameter(2, nombre);
		EntityTransaction tx = eManager.getTransaction();
		tx.begin();
		query.executeUpdate();
		tx.commit();
	}

	public List<Curso> findByPrecioMax(double precioMax) {
		String jpql="select c from Curso c where c.precio<=?1";
		TypedQuery<Curso> query=eManager.createQuery(jpql,Curso.class);
		query.setParameter(1, precioMax);
		return query.getResultList();
		
	}

}
