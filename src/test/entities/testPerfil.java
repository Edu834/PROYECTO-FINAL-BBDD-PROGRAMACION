package test.entities;



import modelo.dao.PerfilesDao;
import modelo.dao.PerfilesDaoImplMy8Jpa;




public class testPerfil {
	private static PerfilesDao pdao;
	static {
		pdao = new PerfilesDaoImplMy8Jpa();
	}
	
	public static void main(String[] args) {
		System.out.println(pdao.buscarTodos());
	}

}
