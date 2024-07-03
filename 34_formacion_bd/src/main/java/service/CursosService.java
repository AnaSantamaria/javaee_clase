package service;

import java.util.List;

import dao.CursosDao;
import model.Curso;

public class CursosService {

	CursosDao dao = new CursosDao();

	public boolean guardarNuevoCurso(Curso curso) {
		if(dao.findBNombre(curso.getNombre())==null) {
		dao.save(curso);
		return true;
		}
			return false;
	}

	public List<Curso> buscarPorPrecio(int precioMax) {
		
		return dao.findByPrecioMax(precioMax);

	}

	public boolean eliminarPorNombre(String nombre) {
		if(dao.findBNombre(nombre)!=null) {
			dao.deleteByNombre(nombre);
			return true;
			
		}
		return false;

	}

	public boolean modificarDuracion(String nombre, int nuevaDuracion) {
		if(dao.findBNombre(nombre)!=null) {
			dao.updateDuracion(nombre, nuevaDuracion);
			return true;
		}
		
		return false;

	}

}