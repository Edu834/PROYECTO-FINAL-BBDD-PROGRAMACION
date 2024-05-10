package modelo.dao;

import java.util.List;

import modelo.entidades.Empleado;

public interface EmpleadoDao extends IntGenericoCrud<Integer, Empleado> {
	List<Empleado> empleadoByDepartamento (int idDepar);
	List<Empleado> empleadoBySexo (String sexo);
	List<Empleado> empleadoByApellido (String subcadena);
	double salarioTotal();
	double salarioTotal(int idDepar);
}
