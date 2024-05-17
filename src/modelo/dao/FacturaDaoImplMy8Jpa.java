package modelo.dao;

import java.util.List;

import modelo.entidades.Factura;
import modelo.entidades.Proyecto;

public class FacturaDaoImplMy8Jpa extends AbstractDaoImplMy8Jpa implements FacturaDao {

	@Override
	public boolean alta(Factura obj) {
		try {
			tx.begin();
			em.persist(obj);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}

	@Override
	public boolean eliminar(String clave) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modificar(Factura obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Factura buscarUno(String clave) {
		return em.find(Factura.class, clave);
	}

	@Override
	public List<Factura> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

}
