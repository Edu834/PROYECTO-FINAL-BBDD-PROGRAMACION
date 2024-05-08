package modelo.dao;

import java.util.List;

import modelo.entidades.Perfil;

public class PerfilesDaoImplMy8Jpa extends AbstractDaoImplMy8Jpa implements PerfilesDao {

	@Override
	public boolean alta(Perfil obj) {
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
	public boolean eliminar(Integer clave) {
		try {
			Perfil per = buscarUno(clave);
			if(per != null) {
				tx.begin();
					em.remove(per);
				tx.commit();
			}else
				return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
			
		}
		
		return false;
	}

	@Override
	public boolean modificar(Perfil obj) {
		try {
			if(buscarUno(obj.getIdPerfil()) != null) {
				tx.begin();
					em.merge(obj);
				tx.commit();
			}else
				return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
			
		}
		return false;
	}

	@Override
	public Perfil buscarUno(Integer clave) {
		return em.find(Perfil.class, clave);
	}

	@Override
	public List<Perfil> buscarTodos() {
		jpql = "SELECT p FROM Perfil p";
		return em.createQuery(jpql).getResultList();
	}

}
