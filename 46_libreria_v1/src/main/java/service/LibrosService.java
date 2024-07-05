package service;

import java.util.List;

import dao.LibrosDao;
import dao.TemasDao;
import model.Libro;
import model.Tema;

public class LibrosService {
	
	LibrosDao libroDao=new LibrosDao();
	TemasDao temaDao= new TemasDao();
	
	public List<Tema> getTema(){
		
		return temaDao.findAll();
		
		
		
	}
	 
	public List<Libro> LibrosTema (int idTema){
		
		if(idTema!=0) {
			
			return libroDao.findByidTema(idTema);
		}else {
			
			return libroDao.findAll();
		}
	}

}
