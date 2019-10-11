package parte2;

import java.util.Arrays;
import java.util.List;

import parte2.Cliente.Categoria;

public class Main
{
	/**
	 * Ejemplo de uso de BDExport.export().
	 *
	 * Crea unos cuantos clientes y empleados, y le pide a la case
	 * BDExport que los exporte.
	 */
	public static void main(String[] args) {
		try (
				Exportador json = new ExportadorJSON("empleados");
				Exportador csv = new ExportadorCSV("clientes");
				Exportador xml = new ExportadorXML("productos")
			) 
				//Cada exportador llama al  metodo close automaticamente
		{
			
			json.export(listaEmpleados());
			System.out.println("Se realizo la copia de seguridad de empleados");
			csv.export(listaClientes());
			System.out.println("Se realizo la copia de seguridad de clientes");
			xml.export(listaProductos());
			System.out.println("Se realizo la copia de seguridad de productos");
		} 
		catch (Exception e) {
			System.err.println("No se pudo realizar la copia de seguridad");
		}
	}

	/*
	 * Métodos auxiliares para tener algo que guardar.
	 */
	private static List<Cliente> listaClientes() {
		return Arrays.asList(new Cliente("C1", "T1", Categoria.VIP),
		                     new Cliente("C2", "T2", Categoria.NORMAL));
	}

	private static List<Empleado> listaEmpleados() {
		return Arrays.asList(new Empleado("E1", "L1", 100),
		                     new Empleado("E2", "L2", 200));
	}
	
	private static List<Producto> listaProductos()
	{
		return Arrays.asList(
				new Producto(1, "Procesador"),
				new Producto(2, "Mother"));
	}
}
