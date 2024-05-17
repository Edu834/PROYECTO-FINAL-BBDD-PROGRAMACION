package modelo.dao;

import java.util.List;

import modelo.entidades.ProyectoConProducto;

public class ProductosEnProyectoDaoImplMy8Jpa extends AbstractDaoImplMy8Jpa implements ProductosEnProyectoDao {
	public ProductosEnProyectoDaoImplMy8Jpa() {
		super();
	}

	@Override
	public boolean alta(ProyectoConProducto object) {
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
			ProyectoConProducto producto = buscarUno(clave);
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
	public boolean modificar(ProyectoConProducto object) {
		
		return false;
	}

	@Override
	public ProyectoConProducto buscarUno(Integer clave) {
		return em.find(ProyectoConProducto.class, clave);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProyectoConProducto> buscarTodos() {
		jpql = "select pp from ProyectoConProducto pp";
		query= em.createQuery(jpql);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProyectoConProducto> productosByProyecto(String codigoProyecto) {
		jpql = "select pp from ProyectoConProducto pp where proyecto.idProyecto = ?1";
		query= em.createQuery(jpql);
		query.setParameter(1, codigoProyecto);
		return query.getResultList();
	}
	
	@Override
	public int asignarProductosAProyecto(List<ProyectoConProducto> productos) {
		tx.begin();
		
		int cont= 0;
		for (ProyectoConProducto proyectoConProducto : productos) {
			try {
				em.persist(proyectoConProducto);
			}catch (Exception e) {
				e.printStackTrace();
			}
			cont ++;
		}
		tx.commit();
		return cont;
	}
	
}
