package model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity// 
@Table(name="libros")
@NamedQuery(name="Libro.findAll",query="select l from Libro l")
@NamedQuery(name="Libro.findByIdTema",query="select l from Libro l where l.idTema=?1")

public class Libro {
	@Id
	
	private int isbn;
	private String titulo;
	private String autor;
	private double precio;
	private int paginas;
	private int idTema;
	
	
	public Libro() {
		super();
	}


	public Libro(int isbn, String titulo, String autor, double precio, int paginas, int idTemas) {
		super();
		this.isbn = isbn;
		this.titulo = titulo;
		this.autor = autor;
		this.precio = precio;
		this.paginas = paginas;
		this.idTema = idTemas;
	}


	public int getIsbn() {
		return isbn;
	}


	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public String getAutor() {
		return autor;
	}


	public void setAutor(String autor) {
		this.autor = autor;
	}


	public double getPrecio() {
		return precio;
	}


	public void setPrecio(double precio) {
		this.precio = precio;
	}


	public int getPaginas() {
		return paginas;
	}


	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}


	public int getIdTemas() {
		return idTema;
	}


	public void setIdTemas(int idTemas) {
		this.idTema = idTemas;
	}

}
