package modelo.dao;

import java.util.List;

public interface IntGenericoCrud<K,T> {
	boolean alta(T object);
	boolean elimina (K clave);
	boolean modificar (T object);
	T buscarUno(K clave);
	List<T> buscarTodos();
}
