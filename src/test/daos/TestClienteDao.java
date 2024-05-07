package test.daos;

import java.math.BigDecimal;
import java.util.Scanner;

import modelo.dao.ClienteDao;
import modelo.dao.ClienteDaoImplMy8Jpa;
import modelo.entidades.Cliente;

public class TestClienteDao {
	
	private static ClienteDao cdao;
	private static Scanner leer;
		
		static {
			leer =new Scanner(System.in);
			cdao= new ClienteDaoImplMy8Jpa();
		}
	public static void main(String[] args) {
		Cliente cliente= new Cliente("222", "a", "a",BigDecimal.valueOf(10000),"b", 7);
		
		cdao.alta(cliente);
		System.out.println(cdao.alta(cliente));
		System.out.println(cdao.buscarTodos());
		System.out.println(cdao.buscarUno("A22222222"));
		cdao.elimina("A22222222");
		System.out.println(cdao.buscarTodos());
	

	}

}
