package modelo.dao;

import java.util.List;

import modelo.entidades.Factura;
import modelo.entidades.Producto;

public class FacturaDaoImplMy8Jpa extends AbstractDaoImplMy8Jpa implements FacturaDao{
	
	
	public FacturaDaoImplMy8Jpa() {
		super();
	}

	@Override
	public boolean alta(Factura object) {
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
	public boolean elimina(String clave) {
		try {
			Factura factura = buscarUno(clave);
			if (factura != null) {
				tx.begin();
				em.remove(factura);
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
	public boolean modificar(Factura object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Factura buscarUno(String clave) {
		return em.find(Factura.class, clave);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Factura> buscarTodos() {
		jpql = "select f from Factura f";
		query= em.createQuery(jpql);
		return query.getResultList();
	}

}
