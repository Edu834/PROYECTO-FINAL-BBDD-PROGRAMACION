package modelo.dao;

import java.util.List;

import modelo.entidades.ProyectoConProducto;

public interface ProductosEnProyectoDao extends IntGenericoCrud<Integer, ProyectoConProducto> {
	
	List<ProyectoConProducto> productosByProyecto(String codigoProyecto);
	int asignarProductosAProyecto(List<ProyectoConProducto> productos); 
	
	
}
