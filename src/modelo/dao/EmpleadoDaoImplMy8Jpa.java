package modelo.dao;

import java.util.ArrayList;
import java.util.List;

import modelo.entidades.Cliente;
import modelo.entidades.Empleado;

public class EmpleadoDaoImplMy8Jpa extends AbstractDaoImplMy8Jpa implements EmpleadoDao {

	public EmpleadoDaoImplMy8Jpa() {
		super();
	}

	@Override
	public boolean alta(Empleado object) {
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
			Empleado empleado = buscarUno(clave);
			if (empleado != null) {
				tx.begin();
				em.remove(empleado);
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
	public boolean modificar(Empleado object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Empleado buscarUno(Integer clave) {
		return em.find(Empleado.class, clave);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Empleado> buscarTodos() {
		jpql = "select e from Empleado e";
		query= em.createQuery(jpql);
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Empleado> empleadosByDepartamento(int idDepar) {
		jpql = "select e from Empleado e where e.departamento.idDepar = ?1";
		query= em.createQuery(jpql);
		query.setParameter(1, idDepar);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Empleado> empleadosBySexo(String sexo) {
		jpql = "select e from Empleado e where e.genero like ?1";
		query= em.createQuery(jpql);
		query.setParameter(1, sexo);
		return query.getResultList();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Empleado> empleadosByApellido(String subcadena) {
		jpql = "select e from Empleado e where e.apellidos like ?1";
		query= em.createQuery(jpql);
		query.setParameter(1, subcadena.strip());
		return query.getResultList();
	}

	@Override
	public double salarioTotal() {
		List<Empleado> todos =new ArrayList();
		Double salarTotal= 0.0;
		todos= buscarTodos();
		for (Empleado empleado : todos) {
			salarTotal=salarTotal + empleado.salarioBruto();
			}
		return salarTotal;
	}

	@Override
	public double salarioTotal(int idDepar) {
		List<Empleado> todos =new ArrayList();
		Double salarTotal= 0.0;
		todos= empleadosByDepartamento(idDepar);
		for (Empleado empleado : todos) {
			salarTotal += empleado.salarioBruto();
			}
		return salarTotal;
	}
}
