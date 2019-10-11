package parte2;

/**
 * Otra clase de ejemplo con varios atributos.
 */
public class Empleado extends Persona
{
	private String cuil;
	private int salario;

	public Empleado(String nombre, String cuil, int salario) {
		super(nombre);
		this.cuil = cuil;
		this.salario = salario;
	}

	private String getCuil() {
		return cuil;
	}

	private int getSalario() {
		return salario;
	}

	@Override
	public String toString() {
		return super.toString() + " " + getCuil() + " " + getSalario();
	}

	@Override
	public int hashCode() {
		final int prime = 3;
		int result = super.hashCode();
		result = prime * result + ((cuil == null) ? 0 : cuil.hashCode());
		result = prime * result + salario;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empleado other = (Empleado) obj;
		if (cuil == null) {
			if (other.cuil != null)
				return false;
		} else if (!cuil.equals(other.cuil))
			return false;
		if (salario != other.salario)
			return false;
		return true;
	}

	@Override
	public Atributos extraerAttributos() {
		Atributos atributos = new Atributos();
		atributos.put("nombre", this.getNombre());
		atributos.put("cuil", getCuil());
		atributos.put("salario", String.valueOf(getSalario()));
		return atributos;
	}	
	
}
