package test.daos;

import modelo.dao.EmpleadoDao;
import modelo.dao.EmpleadoDaoImplMy8Jpa;

public class TestEmpleadoDao {
	
	private static EmpleadoDao edao;
	
	static {
		
		edao= new EmpleadoDaoImplMy8Jpa();
	}
	
	public static void main(String[] args) {
		
		System.out.println(edao.salarioTotal());
		System.out.println("--------------------------------------------------------");
		edao.empleadosByDepartamento(10).forEach(System.out::println);
		System.out.println("--------------------------------------------------------");
		System.out.println(edao.salarioTotal(20));
		System.out.println("--------------------------------------------------------");
		edao.empleadosBySexo("M").forEach(System.out::println);
		System.out.println("--------------------------------------------------------");
		edao.empleadosByApellido("Oliva").forEach(System.out::println);
		System.out.println("--------------------------------------------------------");

	}

}
