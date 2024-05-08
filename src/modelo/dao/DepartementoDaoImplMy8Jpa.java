package modelo.dao;

import java.util.List;

import modelo.entidades.Departamento;


public class DepartementoDaoImplMy8Jpa extends AbstractDaoImplMy8Jpa implements DepartamentoDao {

	@Override
	public boolean alta(Departamento obj) {
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
			Departamento dep = buscarUno(clave);
			if(dep != null) {
				tx.begin();
					em.remove(dep);
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
	public boolean modificar(Departamento obj) {
		try {
			if(buscarUno(obj.getIdDepar()) != null) {
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
	public Departamento buscarUno(Integer clave) {
		return em.find(Departamento.class, clave);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Departamento> buscarTodos() {
		jpql = "SELECT d FROM Departamento d";
		return em.createQuery(jpql).getResultList();
	}

}
