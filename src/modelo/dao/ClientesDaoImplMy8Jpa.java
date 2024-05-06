package modelo.dao;

import java.util.List;

import modelo.entidades.Cliente;



public class ClientesDaoImplMy8Jpa extends AbstractDaoImplMy8Jpa implements ClientesDao{

	@Override
	public boolean alta(Cliente obj) {
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
		try {
			Cliente cliente = buscarUno(clave);
			if(cliente != null) {
				tx.begin();
					em.remove(clave);
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
	public boolean modificar(Cliente obj) {
		try {
			if(buscarUno(obj.getCif()) != null) {
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
	public Cliente buscarUno(String clave) {
		return em.find(Cliente.class, clave);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cliente> buscarTodos() {
		jpql = "select c from Cliente c";
		return em.createQuery(jpql).getResultList();
	}
	
}
