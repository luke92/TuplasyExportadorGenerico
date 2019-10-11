package parte2;

/**
 * Clase que hereda la clase Exportador que guarda los datos en un archivo JSON.
 * @author LVARGAS1
 *
 */

public class ExportadorJSON extends Exportador 
{
	private String tipo;
	
	public ExportadorJSON(String filename) 
	{
		tipo = filename;
		this.filename=filename+".json";
		this.open();
	}
	
	@Override
	public void guardarCampos(Atributos attrs) 
	{
		StringBuffer sb = new StringBuffer();
			
		imprimirCabecera(attrs, sb);
		imprimirValores(attrs, sb);
		
		this.save(sb);
			
	}
	
	private void imprimirCabecera(Atributos attrs, StringBuffer sb)
	{
		if (!cabeceraImpresa()) 
		{
			// Hay que escribir la apertura del arreglo.
			seenFirst = true;
			sb.append("{" + '"' + tipo + '"' + ":");
			sb.append("[ ");
		}
		else 
		{
		// Si no, la coma de separación.
			sb.append(", ");
		}
	}
	
	private void imprimirValores (Atributos attrs, StringBuffer sb)
	{
		sb.append("{");
		
		for (String k : attrs.keySet()) {
			sb.append(" \"" + k + "\": \"" + attrs.get(k) + "\",");
		}
		this.removeComa(sb);
		sb.append("}");
		sb.append(newLine());
	}
	
	private void cerrarJson()
	{
		StringBuffer sb = new StringBuffer("]}");
		this.save(sb);
	}
	
	public void close()
	{
		cerrarJson();
		super.close();
	}
}
	
