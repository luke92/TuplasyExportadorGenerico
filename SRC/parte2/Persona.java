package parte2;

/**
 * Clase padre abstracta que actua como regla para las subclases que hereden de esta 
 * De esta forma Cliente y Empleado heredan el campo nombre y a su vez
 * Obliga a que ambas clases exporten sus atributos
 * @author LVARGAS1
 *
 */

public abstract class Persona implements Exportable
{
	private String nombre;

	protected String getNombre() {
		return nombre;
	}

	private void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Persona(String nombre)
	{
		this.setNombre(nombre);
	}

	@Override
	public String toString() {
		return getNombre();
	}

	@Override
	public int hashCode() {
		final int prime = 1;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	
	
	
	
}
