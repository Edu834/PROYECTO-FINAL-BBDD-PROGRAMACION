package modelo.dao;

import java.util.List;

import modelo.entidades.Departamento;

public class DepartamentoDaoImplMy8Jpa extends AbstractDaoImplMy8Jpa implements DepartamentoDao {

	public DepartamentoDaoImplMy8Jpa() {
		super();
	}

	@Override
	public boolean alta(Departamento object) {
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
			Departamento depar = buscarUno(clave);
			if (depar != null) {
				tx.begin();
				em.remove(depar);
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
	public boolean modificar(Departamento object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Departamento buscarUno(Integer clave) {
		return em.find(Departamento.class, clave);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Departamento> buscarTodos() {
		jpql = "select d from Departamento d";
		query= em.createQuery(jpql);
		return query.getResultList();
	}
	
}
