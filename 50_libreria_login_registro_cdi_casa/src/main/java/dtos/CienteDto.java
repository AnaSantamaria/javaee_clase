package dtos;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

public class CienteDto {

	private int idCliente;
	 private String usuario;
	 private String password;
	 private String email;
	 private int telefono;
	 
	 
	public CienteDto() {
		super();
	}


	public CienteDto(int idCliente, String usuario, String password, String email, int telefono) {
		super();
		this.idCliente = idCliente;
		this.usuario = usuario;
		this.password = password;
		this.email = email;
		this.telefono = telefono;
	}


	public int getIdCliente() {
		return idCliente;
	}


	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}


	public String getUsuario() {
		return usuario;
	}


	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public int getTelefono() {
		return telefono;
	}


	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	 
	 
	 
}
