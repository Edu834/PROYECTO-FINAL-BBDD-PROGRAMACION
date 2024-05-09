package principales;


import modelo.dao.EmpleadoDao;
import modelo.dao.EmpleadosDaoImplMy8Jpa2;
import modelo.entidades.Empleado;



public class testEmpleado {
	private static EmpleadoDao edao;
	static {
		edao = new EmpleadosDaoImplMy8Jpa2();
	}
	
	public static void main(String[] args) {
		
		
		
		//System.out.println(edao.buscarTodos());
		System.out.println(edao.empleadoByDepartamento(10));
	}

}
