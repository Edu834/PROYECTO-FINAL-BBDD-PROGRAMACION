package test.daos;

import java.math.BigDecimal;
import java.util.Scanner;

import modelo.dao.PerfilDao;
import modelo.dao.PerfilDaoImplMy8Jpa;
import modelo.entidades.Perfil;

public class TestPerfilDao {
	private static PerfilDao pdao;
	
	static {
		
		pdao= new PerfilDaoImplMy8Jpa();
	}
	public static void main(String[] args) {
		Perfil perfil= new Perfil();
		Scanner leer = new Scanner(System.in);
		perfil.setIdPerfil(0);
		perfil.setNombre("ooooo");
		perfil.setTasaStandard(leer.nextBigDecimal());
		
	//	System.out.println(pdao.buscarTodos()+"\n");
		//System.out.println(pdao.alta(perfil));
		//System.out.println(pdao.alta(perfil));
		System.out.println(pdao.buscarUno(1));
		System.out.println(pdao.buscarTodos()+"\n\n");
		pdao.elimina(7);
		System.out.println(pdao.buscarTodos());
	}

}
