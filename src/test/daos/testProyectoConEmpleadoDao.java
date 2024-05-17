package test.daos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import modelo.dao.EmpleadoDao;
import modelo.dao.EmpleadosDaoImplMy8Jpa2;
import modelo.dao.ProyectoConEmpleadoDao;
import modelo.dao.ProyectoConEmpleadoDaoImplMy8Jpa;
import modelo.dao.ProyectoDao;
import modelo.dao.ProyectoDaoImplMy8Jpa;
import modelo.entidades.Empleado;
import modelo.entidades.Proyecto;
import modelo.entidades.ProyectoConEmpleado;

public class testProyectoConEmpleadoDao {

	private static ProyectoConEmpleadoDao pedao;
	private static ProyectoDao pdao;
	private static EmpleadoDao edao;
	
	private static Scanner leer;
	
	static {
		pedao = new ProyectoConEmpleadoDaoImplMy8Jpa();
		pdao = new ProyectoDaoImplMy8Jpa();
		edao = new EmpleadosDaoImplMy8Jpa2();
		leer = new Scanner(System.in);
	}
	public static void main(String[] args) {
	
		//alta();
		//eliminar();
		//buscarUno();
		//buscarTodos();
		//empleadosPorProyecto();
		//asignarEmpleadosAProyecto();
		//horasAsignadasAProyecto();
		//costeActualProyecto();
		margenActualProyecto();
		
	}
	private static void empleadosPorProyecto() {
		System.out.println(pedao.empleadosByProyecto("FOR2020001"));
		
	}
	private static void asignarEmpleadosAProyecto() {
		List<ProyectoConEmpleado> listaEmpleados = new ArrayList<>();
		
		ProyectoConEmpleado pce0 = new ProyectoConEmpleado(0, new Date(), 12, edao.buscarUno(101), pdao.buscarUno("FOR2022002"));
		ProyectoConEmpleado pce1 = new ProyectoConEmpleado(0, new Date(), 23, edao.buscarUno(117), pdao.buscarUno("FOR2022002"));
		ProyectoConEmpleado pce2 = new ProyectoConEmpleado(0, new Date(), 56, edao.buscarUno(116), pdao.buscarUno("FOR2021003"));
		
		listaEmpleados.add(pce0);
		listaEmpleados.add(pce1);
		listaEmpleados.add(pce2);
		
		System.out.println(pedao.asignarEmpleadosAProyecto(listaEmpleados));
		
	
	}
	private static void horasAsignadasAProyecto() {
		System.out.println(pedao.horasAsignadasAproyecto("FOR2022002"));
		
	}
	private static void costeActualProyecto() {
		System.out.println(pedao.costeActualDeProyecto("FOR2022002"));
		
	}
	private static void margenActualProyecto() {
		System.out.println(pedao.margenActualProyecto("FOR2022002"));
		
	}
	
	private static void alta() {
		ProyectoConEmpleado pce = new ProyectoConEmpleado(0, new Date(), 43, edao.buscarUno(120), pdao.buscarUno("FOR2021001"));
		System.out.println(pedao.alta(pce));
	}
	private static void eliminar() {
		pedao.eliminar(5);
		
	}
	private static void buscarUno() {
		System.out.println(pedao.buscarUno(2));
		
		
	}
	private static void buscarTodos() {
		for (ProyectoConEmpleado pce : pedao.buscarTodos()) {
			System.out.println(pce);
		}
		
	}
	
	
}
