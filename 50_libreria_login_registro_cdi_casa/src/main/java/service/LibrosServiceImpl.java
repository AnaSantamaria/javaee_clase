package service;

import java.util.List;

import dao.LibrosDao;
import dao.LibrosDaoImpl;
import dao.TemasDao;
import dao.TemasDaoImpl;
import dtos.LibroDto;
import dtos.TemaDto;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import mappers.Mapeador;
@Named


public class LibrosServiceImpl implements LibrosService {
	@Inject
	LibrosDao librosDao;
	@Inject
	TemasDao temasDao;
	@Inject
	Mapeador mapeador;
	@Override
	public List<TemaDto> getTemas(){
		return temasDao.findAll().stream()
				.map(t->Mapeador.temaEntityToDto(t))//Stream<TemaDto>
				.toList();
	}
	
	@Override
	public List<LibroDto> librosTema(int idTema){
		
		if(idTema!=0) {
			return librosDao.findByIdTema(idTema).stream()
					.map(l->Mapeador.libroEntityToDto(l))
					.toList();
		}else{
			return librosDao.findAll().stream()
					.map(l->Mapeador.libroEntityToDto(l))
					.toList();
		}
			
	}
	@Override
	public LibroDto getLibro(int isbn) {
		return Mapeador.libroEntityToDto(librosDao.findByIsbn(isbn));
	}
	
	@Override
	public TemaDto getTema(int idTema) {
		return Mapeador.temaEntityToDto(temasDao.findById(idTema));
	}
	
	@Override
	public boolean guardarLibro(LibroDto libro) {
		if(librosDao.findByIsbn(libro.getIsbn())!=null) {
			return false;
		}
		librosDao.save(Mapeador.libroDtoToEntity(libro));
		return true;
	}
}
