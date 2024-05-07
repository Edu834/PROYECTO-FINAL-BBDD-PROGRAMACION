package principales;

import java.util.Scanner;

import modelo.dao.ClientesDaoImplMy8Jpa;
import modelo.entidades.Cliente;



public class GestionesClientes {
	private static ClientesDaoImplMy8Jpa cdao;
	private static Scanner leer;
	static {
		cdao = new ClientesDaoImplMy8Jpa();
		leer = new Scanner(System.in);
		}
	

	public static void main(String[] args) {
		
	int opcion = pintarMenu();
			
			do {
				if (opcion == 5) 
					break;
				switch (opcion) {
				case 1: 
					procAltaCliente();
					break;
				case 2: 
					leerCliente();
					break;
				case 3: 
					procLeerTodos();
					break;
				case 4: 
					eliminarCliente();
					break;
				}
				System.out.print("-> ");
				opcion = leer.nextInt();
				
			} while (opcion >= 1 && opcion <= 4);
			
				System.out.println("Fin del programa");

	}
	
	public static int pintarMenu() {
		System.out.println("¿Que quieres hacer?");
		System.out.println("------------------------");
		System.out.println("1. - Alta cliente");
		System.out.println("2. - Buscar un cliente");
		System.out.println("3. - Mostrar todos");
		System.out.println("4. - Eliminar un cliente");
		System.out.println("5. - Salir");
		System.out.println("------------------------");
		System.out.print("-> ");
		int opcion = leer.nextInt();
		
		while (opcion < 1 || opcion > 5) {
			System.out.println("solo del 1 al 5");
			System.out.print("-> ");
			opcion= leer.nextInt();
		}
		return opcion;
	}
	public static void leerCliente() {
		System.out.println("Escriba el CIF del cliente");
		System.out.print("- ");
		String cif = leer.next();
		Cliente cliente = cdao.buscarUno(cif);
		if(cliente != null) 
			System.out.println(cliente);
		else 
			System.out.println("Cliente no encontrado");
		
		
		
		
		}
	public static void procAltaCliente() {
		Cliente cliente = new Cliente();
		System.out.println("CIF del cliente");
		System.out.print("- ");
		cliente.setCif(leer.next());
		System.out.println("Nombre");
		System.out.print("- ");
		cliente.setNombre(leer.next());
		System.out.println("Apellidos");
		System.out.print("- ");
		cliente.setApellidos(leer.next());
		System.out.println("Domicilio");
		System.out.print("- ");
		cliente.setDomicilio(leer.next());
		System.out.println("Facturación anual");
		System.out.print("- ");
		cliente.setFacturacionAnual(leer.nextBigDecimal());
		System.out.println("Número de empleados");
		System.out.print("- ");
		cliente.setNumeroEmpleados(leer.nextInt());
		
		if (cdao.alta(cliente) == true)
			System.out.println("Alta realizada satisfactoriamente");
		
		}
	public static void procLeerTodos() {
		System.out.println("Leyendo autores...");
		for (Cliente cliente : cdao.buscarTodos()) {
			System.out.println(cliente);
		}
		
	
	}
	public static void eliminarCliente() {
		System.out.println("Escriba el CIF del cliente");
		System.out.print("- ");
		String cif = leer.next();
		cdao.eliminar(cif);
		
		if(cdao.eliminar(cif) != false) {
			
			System.out.println("Cliente no encontrado");
		}
		else { 
			
			System.out.println("Cliente " + cdao.buscarUno(cif).getNombre() + " eliminado");
		}
		
		
	}
}
