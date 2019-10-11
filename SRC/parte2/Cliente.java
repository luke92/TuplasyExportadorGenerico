package parte2;

/**
 * Una clase de ejemplo con varios atributos.
 */
public class Cliente extends Persona
{
	public enum Categoria {
		NORMAL,
		VIP,
	}

	private String cuit;
	private Categoria categoria;

	public Cliente(String nombre, String cuit, Categoria categoria) {
		super(nombre);
		this.cuit = cuit;
		this.categoria = categoria;
	}


	private String getCuit() {
		return cuit;
	}

	private Categoria getCategoria() {
		return categoria;
	}


	@Override
	public String toString() {
		return super.toString() + " " + getCuit() + " " + getCategoria();
	}


	@Override
	public int hashCode() {
		final int prime = 5;
		int result = super.hashCode();
		result = prime * result
				+ ((categoria == null) ? 0 : categoria.hashCode());
		result = prime * result + ((cuit == null) ? 0 : cuit.hashCode());
		return result;
	}

	@Override
	public Atributos extraerAttributos() {
		Atributos atributos = new Atributos();
		atributos.put("nombre", this.getNombre());
		atributos.put("cuit", getCuit());
		atributos.put("categoria", getCategoria().toString());
		return atributos;
		
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (categoria != other.categoria)
			return false;
		if (cuit == null) {
			if (other.cuit != null)
				return false;
		} else if (!cuit.equals(other.cuit))
			return false;
		return true;
	}
	
	//Class clase = Class.forName(Main.class.getName()); 
	//Field m[] = clase.getFields(); 
	
}
