package modelo.dao;

import java.util.Date;
import java.util.List;

import modelo.entidades.Proyecto;

public class ProyectoDaoImplMy8Jpa extends AbstractDaoImplMy8Jpa implements ProyectoDao {

	public ProyectoDaoImplMy8Jpa() {
		super();
	}

	@Override
	public boolean alta(Proyecto object) {
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
			Proyecto proyecto = buscarUno(clave);
			if (proyecto != null) {
				tx.begin();
				em.remove(proyecto);
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
	public boolean modificar(Proyecto object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Proyecto buscarUno(String clave) {
		return em.find(Proyecto.class, clave);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Proyecto> buscarTodos() {
		jpql = "select p from Proyecto p";
		query= em.createQuery(jpql);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Proyecto> proyectosByEstado(String estado) {
		jpql = "select p from Proyecto p where p.estado like ?1";
		query= em.createQuery(jpql);
		query.setParameter(1, estado);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Proyecto> proyectosByCliente(String cif) {
		jpql = "select p from Proyecto p where p.cliente.cif = ?1";
		query= em.createQuery(jpql);
		query.setParameter(1, cif);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Proyecto> proyectosByJefeProyectoAndByEstado(int jefeProyecto, String estado) {
		jpql = "select p from Proyecto p where p.estado like ?1 AND p.empleado.idEmpl = ?2";
		query= em.createQuery(jpql);
		query.setParameter(1, estado);
		query.setParameter(2, jefeProyecto);
		return query.getResultList();
	}

	@Override
	public double importesVentaProyectosTerminados() {
		double importeVenta = 0.0;
		
		for (Proyecto proyecto : proyectosByEstado("Terminado")) {
			importeVenta+=proyecto.getVentaPrevisto().doubleValue();
		}
		return importeVenta;
	}

	@Override
	public double margenBrutoProyectosTerminados() {
		double margenBruto = 0.0;
		
		for (Proyecto proyecto : proyectosByEstado("Terminado")) {
			margenBruto+=proyecto.margenReal();
		}
		return margenBruto;
	}

	@Override
	public int diasATerminoProyectoActivo(String codigoProyecto) {
		Date fechaHoy= new Date();
		return (int)((buscarUno(codigoProyecto).getFechaFinPrevisto().getTime()/(1000*60*60*24)) - (fechaHoy.getTime()/(1000*60*60*24)));
	}
}
