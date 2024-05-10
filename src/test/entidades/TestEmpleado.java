package test.entidades;

import java.math.BigDecimal;

import modelo.dao.DepartamentoDao;
import modelo.dao.DepartamentoDaoImplMy8Jpa;
import modelo.dao.PerfilDao;
import modelo.dao.PerfilDaoImplMy8Jpa;
import modelo.entidades.Empleado;

public class TestEmpleado {
	
	private static PerfilDao pdao;
	private static DepartamentoDao ddao;
	
	static {
		pdao= new PerfilDaoImplMy8Jpa();
		ddao= new DepartamentoDaoImplMy8Jpa();
	}
	public static void main(String[] args) {
		Empleado empleado= 
		new Empleado(120, "Oliva", "roliva@tt.com", null, null, "M", "Raquel" , "raquel", BigDecimal.valueOf(38000.00), ddao.buscarUno(10), pdao.buscarUno(3), null);

		System.out.println(empleado.salarioBruto());
		System.out.println(empleado.salarioMensual(14));
		System.out.println(empleado.literalSexo());
		System.out.println(empleado.obtenerEmail());
		System.out.println(empleado.nombreCompleto());
	}

}
