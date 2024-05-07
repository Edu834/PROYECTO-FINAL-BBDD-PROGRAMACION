package modelo.dao;

import java.util.List;

import modelo.entidades.Cliente;

public class ClienteDaoImplMy8Jpa extends AbstractDaoImplMy8Jpa implements ClienteDao {

	public ClienteDaoImplMy8Jpa() {
		super();
	}

	@Override
	public boolean alta(Cliente object) {
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
			Cliente cliente = buscarUno(clave);
			if (cliente != null) {
				tx.begin();
				em.remove(cliente);
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
	public boolean modificar(Cliente object) {
		// TODO Auto-generated method stub
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
		query= em.createQuery(jpql);
		return query.getResultList();
	}
}
