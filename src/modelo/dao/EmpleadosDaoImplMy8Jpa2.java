package modelo.dao;

import java.util.ArrayList;
import java.util.List;


import modelo.entidades.Empleado;



public class EmpleadosDaoImplMy8Jpa2 extends AbstractDaoImplMy8Jpa implements EmpleadoDao{

	@Override
	public boolean alta(Empleado obj) {
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
			Empleado emp = buscarUno(clave);
			if(emp != null) {
				tx.begin();
					em.remove(emp);
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
	public boolean modificar(Empleado obj) {
		try {
			if(buscarUno(obj.getIdEmpl()) != null) {
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
	public Empleado buscarUno(Integer clave) {
		return em.find(Empleado.class, clave);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Empleado> buscarTodos() {
		jpql = "SELECT e FROM Empleado e";
		return em.createQuery(jpql).getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Empleado> empleadoByDepartamento(int idDepar) {
		jpql = "SELECT e FROM Empleado e WHERE id_empl like ?1";
		query.setParameter(1, idDepar);
		return em.createQuery(jpql).getResultList();
	}

	@Override
	public List<Empleado> empleadoBySexo(char sexo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Empleado> empleadoByApellido(String subcadena) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double salarioTotal() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public double salarioTotal(int idDepar) {
		// TODO Auto-generated method stub
		return 0;
	}

	

	

	

	
	
}
