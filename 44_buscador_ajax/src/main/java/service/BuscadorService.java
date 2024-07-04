package service;

import java.util.List;
import java.util.Optional;

import dao.BuscadorDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import model.Resultado;

public class BuscadorService {
	
	BuscadorDao dao=new BuscadorDao();
	
	//Metodos logica de negocio
	
	
  public boolean altaResultados(Resultado resultado) {
	  if(dao.findByUrl(resultado.getUrl())==null) {
		  dao.save(resultado);
		  return true;
		  
	  }
	  return false;
  }
  
  public Optional <Resultado> buscarResultadoPorId (int idResultado) {
	Resultado resultado = dao.findById(idResultado);
	return resultado!=null?Optional.of(resultado):Optional.empty();
	
	
}
  public Optional <Resultado> eliminarResultado(int idResultado) {
	  Resultado resultado = dao.findById(idResultado);
		if(resultado!=null) {
			
			dao.deleteById(idResultado);
		}
		return resultado!=null?Optional.of(resultado):Optional.empty();
	}
  
  public List<Resultado>resultadosPorTematica(String tematica){
	  return dao.findByTematica(tematica);
		
  }
  
  
}

