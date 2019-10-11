package parte2;

public class Producto extends Persona 
{
	private Integer id;
	public Producto(Integer id, String nombre) {
		super(nombre);
		this.id = id;
	}
	
	@Override
	public Atributos extraerAttributos() {
		Atributos atributos = new Atributos();
		atributos.put("nombre", this.getNombre());
		atributos.put("id", String.valueOf(id));
		return atributos;
	}
	
	

}
