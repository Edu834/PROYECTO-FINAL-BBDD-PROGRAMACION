package test.entidades;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import modelo.dao.ClienteDao;
import modelo.dao.ClienteDaoImplMy8Jpa;
import modelo.dao.EmpleadoDao;
import modelo.dao.EmpleadoDaoImplMy8Jpa;
import modelo.entidades.Proyecto;

public class TestProyecto {

	private static ClienteDao cdao;
	private static EmpleadoDao edao;
	
	static {
		edao= new EmpleadoDaoImplMy8Jpa();
		cdao= new ClienteDaoImplMy8Jpa();
	}
	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Proyecto proyecto = new Proyecto("AAAAAA", new BigDecimal(12000), new BigDecimal(10000), "Hola MUndo", "Terminado", null ,null, null,new BigDecimal(20000),  cdao.buscarUno("A22222222"), edao.buscarUno(100));
		
		Date fechaFinPrevisto = new Date();
		String fechaString = "2020-07-31";
		fechaFinPrevisto = sdf.parse(fechaString);
		proyecto.setFechaFinPrevisto(fechaFinPrevisto);
		
		Date fechaFinReal = new Date();
		fechaString = "2020-07-30";
		fechaFinReal = sdf.parse(fechaString);
		proyecto.setFechaFinReal(fechaFinReal);
		
		System.out.println(proyecto.diferenciaGastos());
		System.out.println(proyecto.margenPrevisto());
		System.out.println(proyecto.margenReal());
		System.out.println(proyecto.diferenciaFinPrevistoReal());
		
	}

}
