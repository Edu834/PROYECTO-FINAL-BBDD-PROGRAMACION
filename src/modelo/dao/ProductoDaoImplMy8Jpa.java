package modelo.dao;

import java.util.List;

import modelo.entidades.Producto;

public class ProductoDaoImplMy8Jpa extends AbstractDaoImplMy8Jpa implements ProductoDao{

	public ProductoDaoImplMy8Jpa() {
		super();
	}

	@Override
	public boolean alta(Producto object) {
		try {
			tx.begin();
			em.persist(object);
			tx.commit();
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean elimina(Integer clave) {
		try {
			Producto producto = buscarUno(clave);
			if (producto != null) {
				tx.begin();
				em.remove(producto);
				tx.commit();
				return true;
			}
			else
				return false;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean modificar(Producto object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Producto buscarUno(Integer clave) {
		return em.find(Producto.class, clave);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Producto> buscarTodos() {
		jpql = "select p from Producto p";
		query= em.createQuery(jpql);
		return query.getResultList();
	}
	
}
