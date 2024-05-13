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
		jpql = "SELECT e FROM Empleado e WHERE e.departamento.idDepar like ?1";
		query= em.createQuery(jpql);
		query.setParameter(1, idDepar);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Empleado> empleadoBySexo(String sexo) {
		jpql = "SELECT e FROM Empleado e WHERE e.genero like ?1";
		query= em.createQuery(jpql);
		query.setParameter(1, sexo);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Empleado> empleadoByApellido(String subcadena) {
		jpql = "SELECT e FROM Empleado e WHERE e.apellidos like ?1";
		query= em.createQuery(jpql);
		query.setParameter(1, subcadena);
		return query.getResultList();
	}

	@Override
	public double salarioTotal() {
		
		double salarioTotal = 0.0;
		
		for (Empleado empleado : buscarTodos()) {
			
			salarioTotal += empleado.salarioBruto();
			
		}
		return salarioTotal;
	}


	@Override
	public double salarioTotal(int idDepar) {
		
		double salarioTotal = 0.0;
		
		for (Empleado empleado : empleadoByDepartamento(idDepar)) {
			
			salarioTotal += empleado.salarioBruto();
			
		}
		return salarioTotal;
	}

	

	

	

	
	
}
