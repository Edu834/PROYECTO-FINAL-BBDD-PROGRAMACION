package test.daos;


import java.util.Scanner;

import modelo.dao.DepartamentoDao;
import modelo.dao.DepartementoDaoImplMy8Jpa;
import modelo.dao.EmpleadoDao;
import modelo.dao.EmpleadosDaoImplMy8Jpa2;
import modelo.dao.PerfilesDao;
import modelo.dao.PerfilesDaoImplMy8Jpa;
import modelo.entidades.Empleado;





public class testEmpleadoDao {
	private static EmpleadoDao edao;
	private static PerfilesDao pdao;
	private static DepartamentoDao ddao;
	private static Scanner leer;
	static {
		edao = new EmpleadosDaoImplMy8Jpa2();
		pdao = new PerfilesDaoImplMy8Jpa();
		ddao = new DepartementoDaoImplMy8Jpa();
		leer = new Scanner(System.in);
	}
	
	public static void main(String[] args) {
		
		int opcion = pintarMenu();
		
		do {
			if (opcion == 10) 
				break;
			switch (opcion) {
			case 1: 
				procAltaEmpleado();
				break;
			case 2: 
				leerEmpleado();
				break;
			case 3: 
				eliminarEmpleado();
				break;
			case 4: 
				procLeerTodos();
				break;
			case 5: 
				procEmpleadoDepartamento();
				break;
			case 6: 
				procEmpleadoGenero();
				break;
			case 7: 
				procEmpleadoApellido();
				break;
			case 8: 
				procSalarioPlantilla();
				break;
			case 9: 
				procSalarioDepartamento();
				break;
			
			}
			System.out.print("-> ");
			opcion = leer.nextInt();
			
		} while (opcion >= 1 && opcion <= 10);
		
			System.out.println("Fin del programa");

}

	

	private static int pintarMenu() {
		System.out.println("¿Que quieres hacer?");
		System.out.println("------------------------");
		System.out.println("1. - Alta cliente");
		System.out.println("2. - Buscar un empleado");
		System.out.println("3. - Eliminar un empleado");
		System.out.println("4. - Mostrar todos");
		System.out.println("5. - Empleado por departamento");
		System.out.println("6. - Empleado por genero");
		System.out.println("7. - Empleados por apellido");
		System.out.println("8. - Salario de toda la plantilla");
		System.out.println("9. - Salario total de un departamento");
		System.out.println("10. - Salir");
		System.out.println("------------------------");
		System.out.print("-> ");
		int opcion = leer.nextInt();
		
		while (opcion < 1 || opcion > 10) {
			System.out.println("solo del 1 al 10");
			System.out.print("-> ");
			opcion= leer.nextInt();
		}
		return opcion;
	}
	
	public static void procLeerTodos() {
		System.out.println("Leyendo autores...");
		for (Empleado empleado : edao.buscarTodos()) {
			System.out.println(empleado);
		}
	}
	private static void procAltaEmpleado() {
		Empleado empleado = new Empleado();
		System.out.println("Nombre");
		System.out.print("- ");
		empleado.setNombre(leer.next());
		System.out.println("Apellidos");
		System.out.print("- ");
		empleado.setApellidos(leer.next());
		System.out.println("Genero (H o M)");
		System.out.print("- ");
		empleado.setGenero(leer.next());
		System.out.println("Email");
		System.out.print("- ");
		empleado.setEmail(leer.next());
		System.out.println("Contraseña");
		System.out.print("- ");
		empleado.setPassword(leer.next());
		System.out.println("Salario");
		System.out.print("- ");
		empleado.setSalario(leer.nextBigDecimal());
		System.out.println("Fecha de ingreso");
		System.out.print("- ");
		empleado.setSalario(leer.nextBigDecimal());
		System.out.println("Fecha nacimiento");
		System.out.print("- ");
		empleado.setSalario(leer.nextBigDecimal());
		System.out.println("Id del perfil");
		System.out.print("- ");
		empleado.setPerfil(pdao.buscarUno(leer.nextInt()));
		System.out.println("Id del departamento");
		System.out.print("- ");
		empleado.setDepartamento(ddao.buscarUno(leer.nextInt()));
		
		if (edao.alta(empleado) == true)
			System.out.println("Alta realizada satisfactoriamente");
		
	}
	private static void leerEmpleado() {
		System.out.println("Escriba el ID del empleado");
		System.out.print("- ");
		int id = leer.nextInt();
		Empleado empleado = edao.buscarUno(id);
		if(empleado != null) 
			System.out.println(empleado);
		else 
			System.out.println("Empleado no encontrado");
		
	}
	private static void eliminarEmpleado() {
		System.out.println("Escriba el ID del empleado");
		System.out.print("- ");
		int id = leer.nextInt();
		edao.eliminar(id);
		procLeerTodos();
		
		if(edao.eliminar(id) != false) {
			
			System.out.println("Empleado no encontrado");
		}
		else { 
			
			System.out.println("Empleado eliminado correctamente");
		}
		
	}
	private static void procSalarioDepartamento() {
		System.out.println("Escriba el ID del departamento");
		System.out.print("- ");
		int id = leer.nextInt();
		System.out.println(edao.salarioTotal(id));
		
	}

	private static void procSalarioPlantilla() {
		System.out.println(edao.salarioTotal());
		
	}

	private static void procEmpleadoApellido() {
		System.out.println("Escriba el Apellido del empleado");
		System.out.print("- ");
		String apellido = leer.next();
		System.out.println(edao.empleadoByApellido(apellido));
		
	}

	private static void procEmpleadoGenero() {
		System.out.println("Escriba H o M");
		System.out.print("- ");
		String genero = leer.next();
		if(!genero.equals("H") && !genero.equals("M")) {
			System.out.println("Error");
		}else {
			System.out.println(edao.empleadoBySexo(genero));
		}
		
		
	}

	private static void procEmpleadoDepartamento() {
		System.out.println("Escriba el id del Departamento");
		System.out.print("- ");
		int depar = leer.nextInt();
		System.out.println(edao.empleadoByDepartamento(depar));
		
	}
		
		
		//System.out.println(edao.buscarUno(100));
		//System.out.println(edao.eliminar(100));
		//System.out.println(edao.buscarTodos());
		//System.out.println(edao.empleadoByDepartamento(10));
		//edao.empleadoByDepartamento(40).forEach(System.out::println);
		//edao.empleadoBySexo("M").forEach(System.out::println);
		//edao.empleadoByApellido("Baida").forEach(System.out::println);
		//System.out.println(edao.salarioTotal());
		//System.out.println(edao.salarioTotal(10));
	}


