package parte2;

import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

/**
 * Clase padre abstracta que hace de interfaz también para los tipos de exportadores
 * 
 * @author LVARGAS1
 *
 */

public abstract class Exportador implements Closeable 
//La intefaz Closeable hace que la clase llame a close automaticamente luego de finalizar el try
{
	protected boolean seenFirst = false;
	protected String filename;
	protected BufferedWriter writer = null;
	public abstract void guardarCampos(Atributos attrs);
	
	protected boolean cabeceraImpresa()
	{
		return this.seenFirst;
	}
	
	public void export(Iterable<? extends Exportable> objetos)
	{
		for (Exportable e : objetos) 
		{
			Atributos attrs = e.extraerAttributos();
			this.guardarCampos(attrs);
		}
	}
	
	public void save(StringBuffer sb)
	{
		try {
			writer.append(sb);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void open()
	{
		try {
			writer = new BufferedWriter(new OutputStreamWriter(
			        new FileOutputStream(filename), "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void close()
	{
		try {
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected String newLine()
	{
		return System.getProperty("line.separator");
	}
	
	protected void removeComa(StringBuffer sb)
	{
		sb.replace(sb.length()-1, sb.length(), "");
	}
	
}
