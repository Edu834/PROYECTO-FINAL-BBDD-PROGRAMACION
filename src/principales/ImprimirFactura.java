package principales;

import java.util.Scanner;

import modelo.dao.FacturaDao;
import modelo.dao.FacturaDaoImplMy8Jpa;

public class ImprimirFactura {
	private static FacturaDao fdao;
	private static Scanner leer;
	static {
		fdao = new FacturaDaoImplMy8Jpa();
		leer = new Scanner(System.in);
		}
	public static void main(String[] args) {
		
		int opcion = pintarMenu();
		
		do {
			if (opcion == 3) 
				break;
			switch (opcion) {
			case 1: 
				procCrearFactura();
				break;
			case 2: 
				buscarFactura();
				break;
			
			}
			System.out.print("-> ");
			opcion = leer.nextInt();
			
		} while (opcion >= 1 && opcion <= 2);
		
			System.out.println("Fin del programa");

	}
	private static void procCrearFactura() {
		
		System.out.println(fdao.buscarUno(null));
	}
	private static void buscarFactura() {
		// TODO Auto-generated method stub
		
	}
	
	public static int pintarMenu() {
		System.out.println("¿Que quieres hacer?");
		System.out.println("------------------------");
		System.out.println("1. - Crear factura nueva");
		System.out.println("2. - Imprimir datos de la factura");
		System.out.println("3. - Salir");
		System.out.println("------------------------");
		System.out.print("-> ");
		int opcion = leer.nextInt();
		
		while (opcion < 1 || opcion > 3) {
			System.out.println("solo del 1 al 3");
			System.out.print("-> ");
			opcion= leer.nextInt();
		}
		return opcion;
	}
	
	
}
