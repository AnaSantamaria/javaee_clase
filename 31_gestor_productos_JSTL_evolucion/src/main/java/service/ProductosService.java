package service;

import java.util.ArrayList;
import java.util.List;

import model.Producto;

public class ProductosService {
	
	private static List<Producto> productos = new ArrayList<>();   /// la lista es Static para que no se pierdan los datos
	
	public void guardar(Producto producto) {
		productos.add(producto);
	}
	
	public List<Producto> buscarPorCategoria (String categoria){
		
		return productos.stream()
				.filter(p->p.getCategoeria().equals(categoria))
				.toList();
		
	}
	
	public void eliminar (String nombre) {
		productos.removeIf(p->p.getNombre().equals(nombre));
		
		
	}
	
	
}
