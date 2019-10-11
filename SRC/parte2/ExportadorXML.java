package parte2;

public class ExportadorXML extends Exportador 
{
	private String tipo;
	
	public ExportadorXML(String filename)
	{
		tipo = filename;
		this.filename=filename+".xml";
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
			seenFirst = true;
			openTag(tipo,sb);
			sb.append(newLine());
		}
	}
	
	private void openTag(String dato, StringBuffer sb)
	{
		sb.append("<" + dato + ">");
	}
	
	private void closeTag(String dato, StringBuffer sb)
	{
		sb.append("</" + dato + ">");
	}
	
	private void imprimirValores (Atributos attrs, StringBuffer sb)
	{
		sb.append('\t');
		for (String k : attrs.keySet()) 
		{
			openTag(k,sb);
			sb.append(attrs.get(k));
			closeTag(k,sb);
		}
		sb.append(newLine());
	}
	
	private void closeXML()
	{
		StringBuffer sb = new StringBuffer();
		closeTag(tipo,sb);
		this.save(sb);
	}
	
	@Override
	public void close()
	{
		closeXML();
		super.close();
	}

}
