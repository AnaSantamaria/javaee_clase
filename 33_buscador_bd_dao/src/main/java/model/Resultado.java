package model;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity// hay que hacer un para cada tabla con la que se trabaje
@Table(name="resultados")
public class Resultado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int idResultado;
	@Column(name="url")/// anotacion que se usa para indicar el nombre de columna en la base de datos en el caso de que no coincida con el nobre de atributo que se le ha designado
	private String url;
	private String tematica;
	//@Transient-----> se usa encima de cualquier artributo que NO esté asociado a ninguna columna de la table en la base de datos
	private String descripcion;
	
	
	public Resultado() {
		super();
	}
	public Resultado(int idResultado, String url, String tematica, String descripcion) {
		super();
		this.idResultado = idResultado;
		this.url = url;
		this.tematica = tematica;
		this.descripcion = descripcion;
	}
	public int getIdResultado() {
		return idResultado;
	}
	public void setIdResultado(int idResultado) {
		this.idResultado = idResultado;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getTematica() {
		return tematica;
	}
	public void setTematica(String tematica) {
		this.tematica = tematica;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
	
	

}
