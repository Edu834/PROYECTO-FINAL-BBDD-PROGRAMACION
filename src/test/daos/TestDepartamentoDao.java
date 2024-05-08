package test.daos;

import java.math.BigDecimal;

import modelo.dao.DepartamentoDao;
import modelo.dao.DepartamentoDaoImplMy8Jpa;
import modelo.dao.PerfilDao;
import modelo.dao.PerfilDaoImplMy8Jpa;
import modelo.entidades.Departamento;

public class TestDepartamentoDao {
	private static DepartamentoDao ddao;
	
	static {
		
		ddao= new DepartamentoDaoImplMy8Jpa();
	}
	public static void main(String[] args) {
		Departamento depar= new Departamento(50, "aaaa","eee");
		
		
		System.out.println(ddao.buscarTodos()+"\n");
		ddao.alta(depar);
		System.out.println(ddao.alta(depar));
		System.out.println(ddao.buscarUno(1));
		System.out.println(ddao.buscarTodos()+"\n\n");
		/*pdao.elimina(4);
		System.out.println(pdao.buscarTodos());*/
	}

}
