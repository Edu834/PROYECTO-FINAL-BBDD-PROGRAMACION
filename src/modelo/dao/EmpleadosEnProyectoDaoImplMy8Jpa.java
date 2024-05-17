package modelo.dao;

import java.util.List;

import modelo.entidades.Empleado;
import modelo.entidades.ProyectoConEmpleado;

public class EmpleadosEnProyectoDaoImplMy8Jpa extends AbstractDaoImplMy8Jpa implements EmpleadosEnProyectoDao {
	private ProyectoDao ddao= new ProyectoDaoImplMy8Jpa();
	public EmpleadosEnProyectoDaoImplMy8Jpa() {
		super();
	}

	@Override
	public boolean alta(ProyectoConEmpleado object) {
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
			ProyectoConEmpleado empleado = buscarUno(clave);
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
	public boolean modificar(ProyectoConEmpleado object) {
		
		return false;
	}

	@Override
	public ProyectoConEmpleado buscarUno(Integer clave) {
		return em.find(ProyectoConEmpleado.class, clave);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProyectoConEmpleado> buscarTodos() {
		jpql = "select pe from ProyectoConEmpleado pe";
		query= em.createQuery(jpql);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProyectoConEmpleado> empleadosByProyecto(String codigoProyecto) {
		jpql = "select pe from ProyectoConEmpleado pe where proyecto.idProyecto = ?1";
		query= em.createQuery(jpql);
		query.setParameter(1, codigoProyecto);
		return query.getResultList();
	}

	@Override
	public int asignarEmpleadosAProyecto(List<ProyectoConEmpleado> empleados) {
		tx.begin();
		
		int cont= 0;
		for (ProyectoConEmpleado proyectoConEmpleado : empleados) {
			try {
				em.persist(proyectoConEmpleado);
			}catch (Exception e) {
				e.printStackTrace();
			}
			cont ++;
		}
		tx.commit();
		return cont;
	}

	@Override
	public int horasAsignadasAProyecto(String codigoProyecto) {
//		int horasAsignadas = 0;
//		for (ProyectoConEmpleado proyectoConEmpleado : empleadosByProyecto(codigoProyecto)) {
//			horasAsignadas += proyectoConEmpleado.getHorasAsignadas();
//		}
		
		return empleadosByProyecto(codigoProyecto)
				.stream()
				.mapToInt(p -> p.getHorasAsignadas())
				.sum();
	//	return horasAsignadas;
	}

	@Override
	public double costeActualDeProyecto(String codigoProyecto) {
		int costeActual = 0;
		for (ProyectoConEmpleado proyectoConEmpleado : empleadosByProyecto(codigoProyecto)) {
			costeActual += proyectoConEmpleado.costeHorasAsignadas();
		}
		return costeActual;
	}

	@Override
	public double margenActualProyecto(String codigoProyecto) {
		return ddao.buscarUno(codigoProyecto).getVentaPrevisto().doubleValue() - costeActualDeProyecto(codigoProyecto);
	}
	
}
