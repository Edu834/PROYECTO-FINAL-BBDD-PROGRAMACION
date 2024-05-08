package modelo.dao;

import java.util.List;

import modelo.entidades.Perfil;

public class PerfilDaoImplMy8Jpa extends AbstractDaoImplMy8Jpa implements PerfilDao {

	public PerfilDaoImplMy8Jpa() {
		super();
	}

	@Override
	public boolean alta(Perfil object) {
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
			Perfil perfil = buscarUno(clave);
			if (perfil != null) {
				tx.begin();
				em.remove(perfil);
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
	public boolean modificar(Perfil object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Perfil buscarUno(Integer clave) {
		return em.find(Perfil.class, clave);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Perfil> buscarTodos() {
		jpql = "select p from Perfil p";
		query= em.createQuery(jpql);
		return query.getResultList();
	}
	
}
