package test.daos;

import java.math.BigDecimal;
import java.util.Scanner;

import modelo.dao.ClienteDao;
import modelo.dao.ClienteDaoImplMy8Jpa;
import modelo.dao.EmpleadoDao;
import modelo.dao.EmpleadoDaoImplMy8Jpa;
import modelo.dao.EmpleadosEnProyectoDao;
import modelo.dao.EmpleadosEnProyectoDaoImplMy8Jpa;
import modelo.dao.ProyectoDao;
import modelo.dao.ProyectoDaoImplMy8Jpa;
import modelo.entidades.Cliente;
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
		
		pedao.alta(ProEmpl);
		System.out.println(pedao.alta(ProEmpl));
		System.out.println(pedao.buscarTodos());
		System.out.println(pedao.buscarUno(4));
		pedao.elimina(5);
		ProEmpl.costeHorasAsignadas();
		pedao.asignarEmpleadosAProyecto(null);
		pedao.horasAsignadasAProyecto(null);
		pedao.margenActualProyecto(null);
		pedao.costeActualDeProyecto(null);
		pedao.empleadosByProyecto(null);
	

	}

}
