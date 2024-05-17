package modelo.dao;

import java.util.List;

import modelo.entidades.Proyecto;
import modelo.entidades.ProyectoConEmpleado;

public class ProyectoConEmpleadoDaoImplMy8Jpa extends AbstractDaoImplMy8Jpa implements ProyectoConEmpleadoDao {
	private static ProyectoDao pdao;
	static {
		pdao = new ProyectoDaoImplMy8Jpa();
	}
	@Override
	public boolean alta(ProyectoConEmpleado obj) {
		try {
			tx.begin();
			em.persist(obj);
			tx.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean eliminar(Integer clave) {
		try {
			ProyectoConEmpleado proy = buscarUno(clave);
			if(proy != null) {
				tx.begin();
					em.remove(proy);
				tx.commit();
				return true;
			}else
				return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
			
		}
		
		
	}

	@Override
	public boolean modificar(ProyectoConEmpleado obj) {
		try {
			if(buscarUno(obj.getNumeroOrden()) != null) {
				tx.begin();
					em.merge(obj);
				tx.commit();
				return true;
			}else
				return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
			
		}
		
	}

	@Override
	public ProyectoConEmpleado buscarUno(Integer clave) {
		return em.find(ProyectoConEmpleado.class, clave);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProyectoConEmpleado> buscarTodos() {
		jpql = "SELECT p FROM ProyectoConEmpleado p";
		return em.createQuery(jpql).getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProyectoConEmpleado> empleadosByProyecto(String codigoProyecto) {
		jpql = "SELECT p.empleado FROM ProyectoConEmpleado p WHERE p.proyecto.idProyecto = ?1";
		query= em.createQuery(jpql);
		query.setParameter(1, codigoProyecto);
		return query.getResultList();
	}

	@Override
	public int asignarEmpleadosAProyecto(List<ProyectoConEmpleado> empleados) {
		try {
		int contadorAsignados=0;
		tx.begin();
		for (ProyectoConEmpleado proyectoConEmpleado : empleados) {
			
			em.persist(proyectoConEmpleado);
			contadorAsignados+=1;
		}
		tx.commit();
		return contadorAsignados;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}	
		
	}

	@Override
	public int horasAsignadasAproyecto(String codigoProyecto) {
		
		jpql = "SELECT sum(p.horasAsignadas) FROM ProyectoConEmpleado p WHERE p.proyecto.idProyecto = ?1";
		query= em.createQuery(jpql);
		query.setParameter(1, codigoProyecto);
		return (int)(long)query.getSingleResult();
		
	}

	@Override
	public double costeActualDeProyecto(String codigoProyecto) {
		double sumatorio = 0.0;
		for (ProyectoConEmpleado pce : buscarTodos()) {
			if(pce.getProyecto().getIdProyecto().equals(codigoProyecto))
				sumatorio += pce.costeHorasAsignadas();
		}
		return sumatorio;
	}

	@Override
	public double margenActualProyecto(String codigoProyecto) {
		double costeActual = costeActualDeProyecto(codigoProyecto);
		
		double venta = pdao.buscarUno(codigoProyecto).getVentaPrevisto().doubleValue();
		
		return venta - costeActual;
	}

}
