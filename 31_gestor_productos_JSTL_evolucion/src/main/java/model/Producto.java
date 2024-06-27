package model;

public class Producto {
	String nombre;
	double precio;
	String categoeria;
	public Producto(String nombre, double precio, String categoeria) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.categoeria = categoeria;
	}
	public Producto() {
		super();
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public String getCategoeria() {
		return categoeria;
	}
	public void setCategoeria(String categoeria) {
		this.categoeria = categoeria;
	}

}
