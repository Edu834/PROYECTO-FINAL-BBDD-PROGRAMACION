package principales;


import modelo.dao.EmpleadoDao;
import modelo.dao.EmpleadosDaoImplMy8Jpa2;




public class testEmpleado {
	private static EmpleadoDao edao;
	static {
		edao = new EmpleadosDaoImplMy8Jpa2();
	}
	
	public static void main(String[] args) {
		
		
		
		//System.out.println(edao.buscarTodos());
		//System.out.println(edao.empleadoByDepartamento(10));
		//edao.empleadoByDepartamento(40).forEach(System.out::println);
		//edao.empleadoBySexo("M").forEach(System.out::println);
		//edao.empleadoByApellido("Baida").forEach(System.out::println);
		System.out.println(edao.salarioTotal());
		System.out.println(edao.salarioTotal(10));
	}

}
