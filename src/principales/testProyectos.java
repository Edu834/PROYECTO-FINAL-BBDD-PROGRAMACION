package principales;

import java.util.Scanner;

import modelo.dao.ProyectoDao;
import modelo.dao.ProyectoDaoImplMy8Jpa;

public class testProyectos {

	private static ProyectoDao pdao;
	private static Scanner leer;
	static {
		pdao = new ProyectoDaoImplMy8Jpa();
		leer = new Scanner(System.in);
	}
	public static void main(String[] args) {
		
		System.out.println(pdao.buscarUno("FOR2020001"));

	}

}
