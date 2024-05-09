package modelo.dao;

import java.util.List;

public interface IntGenericoCrud<K,T> {
	boolean alta(T obj);
	boolean eliminar(K clave);
	boolean modificar(T obj);
	T buscarUno(K clave);
	List<T> buscarTodos();
	
}
