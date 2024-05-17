package test.entities;


import modelo.dao.DepartamentoDao;
import modelo.dao.DepartementoDaoImplMy8Jpa;




public class testDepartamento {
	private static DepartamentoDao ddao;
	static {
		ddao = new DepartementoDaoImplMy8Jpa();
	}
	
	public static void main(String[] args) {
		System.out.println(ddao.buscarTodos());
	}

}
