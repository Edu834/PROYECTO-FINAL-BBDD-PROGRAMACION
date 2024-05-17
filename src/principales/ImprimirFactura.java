package principales;

import modelo.dao.ClienteDao;
import modelo.dao.ClienteDaoImplMy8Jpa;
import modelo.dao.EmpleadoDao;
import modelo.dao.EmpleadoDaoImplMy8Jpa;
import modelo.dao.EmpleadosEnProyectoDao;
import modelo.dao.EmpleadosEnProyectoDaoImplMy8Jpa;
import modelo.dao.FacturaDao;
import modelo.dao.FacturaDaoImplMy8Jpa;
import modelo.dao.FamiliaDao;
import modelo.dao.FamiliaDaoImplMy8Jpa;
import modelo.dao.ProductoDao;
import modelo.dao.ProductoDaoImplMy8Jpa;
import modelo.dao.ProductosEnProyectoDao;
import modelo.dao.ProductosEnProyectoDaoImplMy8Jpa;
import modelo.dao.ProyectoDao;
import modelo.dao.ProyectoDaoImplMy8Jpa;
import modelo.entidades.Empleado;
import modelo.entidades.Factura;
import modelo.entidades.ProyectoConEmpleado;
import modelo.entidades.ProyectoConProducto;

public class ImprimirFactura {
	private static double precioTotal;
	private static double totalProductos;
	private static EmpleadosEnProyectoDao pedao;
	private static ProductosEnProyectoDao ppdao;
	private static ProyectoDao pdao;
	private static EmpleadoDao edao;
	private static ClienteDao cdao;
	private static FacturaDao fdao;
	private static ProductoDao prdao;
	private static FamiliaDao fmdao;
		
		static {
			pedao= new EmpleadosEnProyectoDaoImplMy8Jpa();
			ppdao= new ProductosEnProyectoDaoImplMy8Jpa();
			pdao= new ProyectoDaoImplMy8Jpa();
			edao= new EmpleadoDaoImplMy8Jpa();
			cdao= new ClienteDaoImplMy8Jpa();
			fdao= new FacturaDaoImplMy8Jpa();
			prdao = new ProductoDaoImplMy8Jpa();
			fmdao= new FamiliaDaoImplMy8Jpa();
		}
		
	public static void main(String[] args) {
		Factura factura = new Factura("20240001", "Formación a cliente", null, pdao.buscarUno("FOR2020001"));
		//alta(factura);
		imprimirFactura(factura);
		
	}
	
	public static void alta(Factura factura){
		fdao.alta(factura);
		if (fdao.alta(factura)) {
			System.out.println("Factura creada");
		}else {
			System.out.println("No se pudo crear la factura");
		}
	}
	
	public static void imprimirFactura(Factura factura) {
		System.out.println("\nDATOS DE LA FACTURA\n");
		System.out.println("Código factura: " + factura.getIdFactura() +
				" Descripción: " + factura.getDescripcion() + " Fecha Factura: " + factura.getFechaFactura());
		impCliente(factura);
		impProyecto(factura);
		impEmpleado(factura);
		impProducto(factura);
		impImporte(factura);
	}
	
	public static void impCliente(Factura factura) {
		System.out.println("\nDatos del CLIENTE:\n");
		System.out.println("Nombre: " + factura.getProyecto().getCliente().getNombre() +
				" Dirección: " + factura.getProyecto().getCliente().getDomicilio());
	}
	
	public static void impProyecto(Factura factura) {
		System.out.println("\nDatos del PROYECTO:\n");
		System.out.println("Código proyecto: " + factura.getProyecto().getIdProyecto() + "\n" +
				"Descripción de proyecto: " + factura.getProyecto().getDescripcion() + "\n" +
				"Fecha Inicio: " + factura.getProyecto().getFechaInicio() + " Fecha Fin Real: " + factura.getProyecto().getFechaFinReal());
	}
	
	public static void impEmpleado(Factura factura) {
		int cont = 0;
		long horasTotales = 0;
		precioTotal = 0;
		System.out.println("\nDETALLE DE RECURSOS EMPLEADOS\n");
		System.out.println("LISTA EMPLEADOS \n");
		for (ProyectoConEmpleado empleadoProy : pedao.empleadosByProyecto(factura.getProyecto().getIdProyecto())) {
			System.out.println("Nombre completo: " + empleadoProy.getEmpleado().nombreCompleto() + 
					" Horas totales: " + empleadoProy.getHorasAsignadas() +
					" Importe repercutido: " + empleadoProy.costeHorasAsignadas());
			horasTotales += empleadoProy.getHorasAsignadas();
			precioTotal += empleadoProy.costeHorasAsignadas(); 
			cont++;
		}
		System.out.println("\nTotal horas: " + horasTotales + " Total precio: " + precioTotal);
		
	}
	public static void impProducto(Factura factura) {
		totalProductos=0;
		System.out.println("\nLISTA PRODUCTOS \n");
		for (ProyectoConProducto productoProy : ppdao.productosByProyecto(factura.getProyecto().getIdProyecto())) {
			System.out.println("Descripción: " + productoProy.getProducto().getDescripcion() +
					" Cantidad: " + productoProy.getCantidad() +
					" Precio unitario: " + productoProy.getProducto().getPrecio() + "Total: " + productoProy.precioTotalProducto());
			totalProductos += productoProy.precioTotalProducto();
		}
		System.out.println("\nTotal productos: " + totalProductos);
	}
	public static void impImporte(Factura factura) {
		System.out.println("\nDETALLE DEL IMPORTE\n");
		System.out.println("Importe venta: " + factura.getProyecto().getVentaPrevisto() +
				"\nTotal gastos: " + (factura.getProyecto().getCosteReal().doubleValue() + totalProductos + precioTotal));
	}
	
	
	

}
