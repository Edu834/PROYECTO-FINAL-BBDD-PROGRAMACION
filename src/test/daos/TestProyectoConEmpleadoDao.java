package test.daos;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import modelo.dao.ClienteDao;
import modelo.dao.ClienteDaoImplMy8Jpa;
import modelo.dao.EmpleadoDao;
import modelo.dao.EmpleadoDaoImplMy8Jpa;
import modelo.dao.EmpleadosEnProyectoDao;
import modelo.dao.EmpleadosEnProyectoDaoImplMy8Jpa;
import modelo.dao.ProyectoDao;
import modelo.dao.ProyectoDaoImplMy8Jpa;
import modelo.entidades.ProyectoConEmpleado;

public class TestProyectoConEmpleadoDao {
	
	private static EmpleadosEnProyectoDao pedao;
	private static ProyectoDao pdao;
	private static EmpleadoDao edao;
		
		static {
			pedao= new EmpleadosEnProyectoDaoImplMy8Jpa();
			pdao= new ProyectoDaoImplMy8Jpa();
			edao= new EmpleadoDaoImplMy8Jpa();
}
	public static void main(String[] args) {
		ProyectoConEmpleado ProEmpl= new ProyectoConEmpleado(0, null, 45, edao.buscarUno(118), pdao.buscarUno("FOR2021001"));
		ProyectoConEmpleado ProEmpl2= new ProyectoConEmpleado(0, null, 70, edao.buscarUno(118), pdao.buscarUno("FOR2024002"));
		ProyectoConEmpleado ProEmpl3= new ProyectoConEmpleado(0, null, 70, edao.buscarUno(118), pdao.buscarUno("FOR2024002"));
		List<ProyectoConEmpleado> listaProEmpl = new ArrayList<>();
		listaProEmpl.add(ProEmpl);
		listaProEmpl.add(ProEmpl2);
		listaProEmpl.add(ProEmpl3);
		//pedao.alta(ProEmpl);
		System.out.println(pedao.alta(ProEmpl));
		System.out.println(pedao.buscarTodos());
		System.out.println(pedao.buscarUno(4));
		//pedao.elimina(5);
		System.out.println(ProEmpl.costeHorasAsignadas());
		//pedao.asignarEmpleadosAProyecto(listaProEmpl);
		//pedao.buscarTodos().forEach(System.out::println);
		System.out.println(pedao.horasAsignadasAProyecto("FOR2020001"));
		System.out.println(pedao.margenActualProyecto("FOR2020001"));
		System.out.println(pedao.costeActualDeProyecto("FOR2020001"));
		pedao.empleadosByProyecto("FOR2020001").forEach(System.out::println);
	

	}

}
