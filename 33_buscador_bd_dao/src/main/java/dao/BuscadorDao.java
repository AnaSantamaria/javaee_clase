package dao;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import model.Resultado;

public class BuscadorDao {

	private EntityManager eManager;

	public BuscadorDao() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("buscador");
		eManager = factory.createEntityManager();

	}

	public void save(Resultado resultado) {
		EntityTransaction tx = eManager.getTransaction();// es necesario iniciar y cerrar la transacci´n para validarla
															// y que se realice
		tx.begin();
		try {
			eManager.persist(resultado);
			tx.commit();
		} catch (Exception ex) {
			tx.rollback();
		}

	}

	public Resultado findByUrl(String url) {
		String jpql = "select r from Resultado r where r.url=?1";
		TypedQuery<Resultado> query = eManager.createQuery(jpql, Resultado.class);
		query.setParameter("url", url);
		return query.getResultList().stream().findFirst().orElse(null);

	}

	public Resultado findById(int idResultado) {
		return eManager.find(Resultado.class, idResultado);

	}

	public void deleteById(int idResultado) {

		eManager.remove(findById(idResultado));
	}

	public List<Resultado> findByTematica(String tematica) {
		String jpql = "select r from Resultado r where r.tematica=?1";
		TypedQuery<Resultado> query = eManager.createQuery(jpql, Resultado.class);
		query.setParameter(1, tematica);
		return query.getResultList();

	}
}
