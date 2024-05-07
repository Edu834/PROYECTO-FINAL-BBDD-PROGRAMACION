package modelo.dao;

import java.util.List;

import modelo.entidades.Cliente;


public class ClienteDaoImplMy8Jpa extends AbstractDaoImplMy8Jpa implements ClienteDao {

	@Override
	public boolean alta(Cliente obj) {
		try {
			tx.begin();
				em.persist(obj);
			tx.commit();
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean eliminar(String clave) {
		try {
			Cliente cliente = buscarUno(clave);
			if(cliente != null) {
				tx.begin();
					em.remove(cliente);
				tx.commit();
				return true;
			}
			else{
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean modificar(Cliente obj) {
		try {
			if(buscarUno(obj.getCif()) != null) {
				tx.begin();
					em.merge(obj);
				tx.commit();
				return true;
			}else{
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public Cliente buscarUno(String clave) {
		return em.find(Cliente.class, clave);
		
	}

	/*@Override
	public List<Cliente> buscarTodos() {
		jpql = "select c from Cliente c";
		query = em.createQuery(jpql);
		
		return query.getResultList();
	
	}
*/
	
	/*
	 *	@Override
	public boolean alta(Country object) {
		try {
			em.persist(object);
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean elimina(String clave) {
		try {
			Country country = buscarUno(clave);
			if (country != null) {
				tx.begin();
				em.remove(country);
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
	public boolean modificar(Country object) {
		try {
			if (buscarUno(object.getCountryId()) != null) {
				tx.begin();
				em.merge(object);
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
	public Country buscarUno(String clave) {
		// TODO Auto-generated method stub
		return em.find(Country.class, clave);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Country> buscarTodos() {
		jpql = "select c from Country c";
		query= em.createQuery(jpql);
		return query.getResultList();
	} 
	 * */
}
