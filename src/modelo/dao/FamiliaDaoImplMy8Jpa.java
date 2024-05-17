package modelo.dao;

import java.util.List;

import modelo.entidades.Familia;
import modelo.entidades.Producto;

public class FamiliaDaoImplMy8Jpa extends AbstractDaoImplMy8Jpa implements FamiliaDao{

	public FamiliaDaoImplMy8Jpa() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean alta(Familia object) {
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
			Familia familia = buscarUno(clave);
			if (familia != null) {
				tx.begin();
				em.remove(familia);
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
	public boolean modificar(Familia object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Familia buscarUno(Integer clave) {
		return em.find(Familia.class, clave);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Familia> buscarTodos() {
		jpql = "select f from Familia f";
		query= em.createQuery(jpql);
		return query.getResultList();
	}
	
}
