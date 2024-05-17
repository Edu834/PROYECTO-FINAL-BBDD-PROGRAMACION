package test.daos;

import java.math.BigDecimal;

import modelo.dao.ClienteDao;
import modelo.dao.ClienteDaoImplMy8Jpa;
import modelo.dao.EmpleadoDao;
import modelo.dao.EmpleadoDaoImplMy8Jpa;
import modelo.dao.ProyectoDao;
import modelo.dao.ProyectoDaoImplMy8Jpa;
import modelo.entidades.Proyecto;

public class TestProyectoDao {
	
	private static ProyectoDao pdao;
	private static ClienteDao cdao;
	private static EmpleadoDao edao;
		
		static {
			pdao= new ProyectoDaoImplMy8Jpa();
			cdao= new ClienteDaoImplMy8Jpa();
			edao= new EmpleadoDaoImplMy8Jpa();
		}
	public static void main(String[] args) {
		Proyecto proyecto= new Proyecto("FOR2024001", null, new BigDecimal(20000), "aaaa", "Activo", null, null, null, new BigDecimal(50000), cdao.buscarUno("A22222222"), edao.buscarUno(114));
		//pdao.alta(proyecto);
		//System.out.println(pdao.alta(proyecto));
		//pdao.elimina("FOR2024001");
		//System.out.println(pdao.buscarTodos());
		System.out.println(pdao.buscarUno("FOR2024001"));
		pdao.buscarTodos().forEach(System.out::println);
		System.out.println(pdao.diasATerminoProyectoActivo("FOR2021001"));
		pdao.proyectosByCliente("A22222222").forEach(System.out::println);
		System.out.println(pdao.margenBrutoProyectosTerminados());
		System.out.println(pdao.importesVentaProyectosTerminados());
		System.out.println(pdao.proyectosByJefeProyectoAndByEstado(114, "Activo"));
		System.out.println(pdao.proyectosByEstado("Activo"));
	

	}

}
