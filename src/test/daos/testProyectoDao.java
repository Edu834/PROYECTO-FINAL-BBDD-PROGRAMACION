package test.daos;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Scanner;

import modelo.dao.ClientesDao;
import modelo.dao.ClientesDaoImplMy8Jpa;
import modelo.dao.EmpleadoDao;
import modelo.dao.EmpleadosDaoImplMy8Jpa2;
import modelo.dao.ProyectoDao;
import modelo.dao.ProyectoDaoImplMy8Jpa;
import modelo.entidades.Proyecto;

public class testProyectoDao {
	private static ProyectoDao pdao;
	private static ClientesDao cdao;
	private static EmpleadoDao edao;
	private static Scanner leer;
	static {
		pdao = new ProyectoDaoImplMy8Jpa();
		cdao = new ClientesDaoImplMy8Jpa();
		edao = new EmpleadosDaoImplMy8Jpa2();
		leer = new Scanner(System.in);
	}
	public static void main(String[] args) {
		
		//alta();
		//eliminar();
		//buscarUno();
		//buscarTodos();
		//proyectosPorEstado();
		//proyectosPorClientes();
		//proyectosPorJefeProyectoYEstado();
		//importesVentasProyectosTerminados();
		//margenBrutoProyectosTerminados();
		diasTerminoProyectoActivo();
		
		//System.out.println(pdao.diasATerminoProyectoActivo("FOR2022003"));
		//System.out.println(pdao.proyectosByJefeProyectoAndByEstado(114, "ACTIVO"));
		//System.out.println(pdao.buscarTodos());
		
	}
	
	
	
	
	private static void proyectosPorEstado() {
		for (Proyecto proyecto : pdao.proyectosByEstado("ACTIVO")) {
			System.out.println(proyecto);
		}
		
	}
	private static void proyectosPorClientes() {
		for (Proyecto proyecto : pdao.proyectosByCliente("A22222222")) {
			System.out.println(proyecto);
		}
	}
	private static void proyectosPorJefeProyectoYEstado() {
		for (Proyecto proyecto : pdao.proyectosByJefeProyectoAndByEstado(120, "TERMINADO")) {
			System.out.println(proyecto);
		}
		
	}
	private static void importesVentasProyectosTerminados() {
			System.out.println(pdao.importesVentasProyectosTerminados());
		
	}
	
	private static void margenBrutoProyectosTerminados() {
			System.out.println(pdao.margenBrutoProyectosTerminados());
		
	}
	private static void diasTerminoProyectoActivo() {
		
		System.out.println(pdao.diasATerminoProyectoActivo("FOR2022002"));
		
	}
	
	private static void alta() {
		
		Proyecto proy1 = new Proyecto("FOR2020002", null, new BigDecimal(900000.00), "Autentificación mediante FaceID", "ACTIVO", null, null, null, new BigDecimal(1500000.00) ,cdao.buscarUno("C44444444"), edao.buscarUno(120));
		System.out.println(pdao.alta(proy1));
	}
	private static void eliminar() {
		pdao.eliminar("FOR2022002");
		
	}
	private static void buscarUno() {
		System.out.println(pdao.buscarUno("FOR2020001"));
		
	}
	private static void buscarTodos() {
		for (Proyecto proyecto : pdao.buscarTodos()) {
			System.out.println(proyecto);
		}
		
		
		
		
	}
	
	
	

}
