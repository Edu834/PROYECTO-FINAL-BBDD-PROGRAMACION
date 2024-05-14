package modelo.dao;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import modelo.entidades.Perfil;
import modelo.entidades.Proyecto;

public class ProyectoDaoImplMy8Jpa extends AbstractDaoImplMy8Jpa implements ProyectoDao {

	@Override
	public boolean alta(Proyecto obj) {
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
			Proyecto proy = buscarUno(clave);
			if(proy != null) {
				tx.begin();
					em.remove(proy);
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
	public boolean modificar(Proyecto obj) {
		try {
			if(buscarUno(obj.getIdProyecto()) != null) {
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
	public Proyecto buscarUno(String clave) {
		return em.find(Proyecto.class, clave);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Proyecto> buscarTodos() {
		jpql = "SELECT p FROM Proyecto p";
		return em.createQuery(jpql).getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Proyecto> proyectosByEstado(String estado) {
		jpql = "SELECT p FROM Proyecto p WHERE p.estado like ?1";
		query = em.createQuery(jpql);
		query.setParameter(1, estado);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Proyecto> proyectosByCliente(String cif) {
		jpql = "SELECT p FROM Proyecto p WHERE p.cif like ?1";
		query = em.createQuery(jpql);
		query.setParameter(1, cif);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Proyecto> proyectosByJefeProyectoAndByEstado(int jefeProyecto, String estado) {
		jpql = "SELECT p FROM Proyecto p WHERE p.jefe_proyecto like ?1 and p.estado like ?2";
		query = em.createQuery(jpql);
		query.setParameter(1, jefeProyecto);
		query.setParameter(2, estado);
		return query.getResultList();
	}

	@Override
	public double importesVentasProyectosTerminados() {
		double importesProyectos = 0.0;
		for(Proyecto proyecto : buscarTodos()) {
			if(proyecto.getEstado().equals("TERMINADO"))
				importesProyectos += proyecto.getVentaPrevisto().doubleValue();	
		}
		return importesProyectos;
	}

	@Override
	public double margenBrutoProyectosTerminados() {
		double importesProyectos = 0.0;
		for (Proyecto proyecto : buscarTodos()) {
			if(proyecto.getEstado().equals("TERMINADO"))
				importesProyectos += proyecto.margenReal();	
		}
		return importesProyectos;
	}

	@Override
	public int diasATerminoProyectoActivo(String codigoProyecto) {
		int diasRestantes = 0;
		Date diasFin = buscarUno(codigoProyecto).getFechaFinPrevisto();
		Date hoy = new Date();
		if(buscarUno(codigoProyecto).getEstado().equals("ACTIVO")) {
			
			
			
			diasRestantes = (int)diasFin.getTime()/(1000*60*60*24) - (int)hoy.getTime()/(1000*60*60*24);
		}
		return diasRestantes;
	}

}
