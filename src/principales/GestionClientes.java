package principales;

import java.math.BigDecimal;
import java.util.Scanner;

import modelo.dao.ClienteDao;
import modelo.dao.ClienteDaoImplMy8Jpa;
import modelo.entidades.Cliente;

public class GestionClientes {
	
private static ClienteDao cdao;
private static Scanner leer;
	
	static {
		leer =new Scanner(System.in);
		cdao= new ClienteDaoImplMy8Jpa();
	}
	
	public static void main(String[] args) {
		int opcion=0;
		Scanner leer=new Scanner(System.in);
		System.out.println(cdao.buscarTodos());
		System.out.println("Bienvenido al menú de gestión de clientes\n ");
		
		while(opcion!=5) {
			System.out.println("Escoja una de las siguientes opciones:\n\n");
			System.out.println
					("1. Alta del Cliente.\r\n"
					+ "2. Buscar un Cliente.\r\n"
					+ "3. Mostrar Todos.\r\n"
					+ "4. Eliminar un cliente.\r\n"
					+ "5. Salir.\r\n");
			
			opcion= leer.nextInt();
			
			switch (opcion) {
			case 1:
				System.out.println("\nAlta\n");
				altaCliente();
				break;
			case 2:
				System.out.println("\nBuscar uno\n");
				uno();
				break;
			case 3:
				System.out.println("\nBuscar todos\n");
				todos();
				break;
			case 4:
				System.out.println("\nBaja\n");
				bajaCliente();
				break;
			case 5:
				System.out.println("\nSaliendo del programa...\n");
				break;

			default:
				System.out.println("Valor no válido");
				break;
			}
			
		}
		leer.close();
		
			
	}
	
	public static void altaCliente() {
		Cliente cliente= new Cliente();
		System.out.println("CIF:\n");
		cliente.setCif(leer.next());
		System.out.println("Nombre:\n");
		cliente.setNombre(leer.next());
		System.out.println("Apellido:\n");
		cliente.setApellidos(leer.next());
		System.out.println("Domicilio:\n");
		cliente.setDomicilio(leer.next());
		System.out.println("Facturación anual:\n");
		cliente.setFacturacionAnual(leer.nextBigDecimal());
		System.out.println("Número de empleados:\n");
		cliente.setNumeroEmpleados(leer.nextInt());
		cdao.alta(cliente);
		System.out.println(cdao.alta(cliente));
		todos();
		
	}
	
	public static void bajaCliente() {
		String cliId= leer.next();
		cdao.elimina(cliId);
		todos();
		
	}
	
	public static void todos() {

		cdao.buscarTodos().forEach(System.out::println);
	}
	
	public static void uno() {

		String clave=leer.next();
		System.out.println(cdao.buscarUno(clave));
	}

}
