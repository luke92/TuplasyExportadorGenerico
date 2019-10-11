package parte2;

/**
 * Clase que hereda la clase Exportador que guarda los datos en un archivo CSV.
 * @author LVARGAS1
 *
 */

public class ExportadorCSV extends Exportador
{

	public ExportadorCSV(String filename) 
	{
		// TODO Auto-generated constructor stub
		this.filename=filename+".csv";
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
		if(cabeceraImpresa()) return;
		this.seenFirst = true;
		for (String columna : attrs.keySet()) 
		{
			sb.append(columna + ",");
		}
		this.removeComa(sb);
		sb.append(newLine());
	}
	
	private void imprimirValores(Atributos attrs, StringBuffer sb)
	{
		for (String val : attrs.values()) {
			sb.append(val + ",");
		}
		this.removeComa(sb);
		sb.append(newLine());
	}
	
}
