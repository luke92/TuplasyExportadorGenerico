package parte1;

/**
 * Tupla inmutable de dos elementos, para uso con DiccConjunto.
 *
 * equals() y compareTo() solo se fijan en el primer elemento.
 */



public class TuplaDic<T1 extends Comparable<T1>, T2> implements Comparable<TuplaDic<T1, T2>>
{
	private final T1 e1;
	private final T2 e2;

	TuplaDic(T1 a, T2 b) {
		e1 = a;
		e2 = b;
	}

	public T1 getE1() {
		return e1;
	}

	public T2 getE2() {
		return e2;
	}

//################# IMPLEMENTACION ###########################################

	@Override
	public String toString() {
		String s = "clave: " + e1.toString() + " significado: " +  e2.toString();
		return s;
	}


	
	/**	equals contempla los siguientes casos:
		Si resulta que el objeto es igual al this, devuelve true.
		Si el objeto recibido es null, devuelve false.
		Si el objeto no es una tupla, devuelve false.
		Si es una tupla:
			Si el e1 del this y el de la tupla son null, devuelve true.
			Si alguno de los 2 e1 es null, devuelve false.
			Si no, llama a compararse ambos objetos. Es decir this.e1.equals(tupla.e1);, 
				y el metodo equals de la clase del objeto se encargara de resolverlo.
	 */
	
	@Override
	public boolean equals(Object obj) {
		boolean ret = true;
		
		if(obj == this){
			return true;
		}
		
		if (obj == null){
			return false;
		}
		
		if (!(obj instanceof TuplaDic))	{
			return false;
		}
		
		else {
			TuplaDic<T1, T2> aux = (TuplaDic) obj; //casteo el objeto ingresado a tupla
			
			if(e1 == null && aux.getE1() == null){  
				return true;
			}
			
			if(e1 != null && aux.getE1() == null || e1 == null && aux.getE1() != null ){
				return false;
			}
		
			else {
				return e1.equals(aux.getE1()); 
			}
		}
		
		
	}


	/**	compareTo(tupla), compara la tupla del this con la recibida como parametro y devuelve -1,1,0 o excepcion,
	 *  dependiendo del caso. En la comparacion utiliza los atributos e1 de ambas tuplas. 
	 *  Para esto hay ciertos casos posibles. Primero que la tupla recibida sea null, 
	 *  cuyo caso se devuelve excepcion. Segundo que ambos, e1 del this y de la tupla recibida como parametro,
	 *  sean null.. a lo que se devuelve 0. Ya que null es igual a null. Como 3er caso, 
	 *  si ocurre que e1 del this sea distinto de null y el e1 de la tupla recibida como parametro sea null, se devuelve 0.
	 *  Como cuarto caso, si sucede lo contrar, es decir que e1 del this sea null y el e1 de la tupla recibida sea distinto de null... 
	 *  se devuelve -1. Y por ultimo caso, si resultan ser ambos objetos (comparables como se espera)
	 *  se llama al metodo compareTo del objeto e1. Es decir e1.compareTo(tupla.e1);,
	 *  què compara y còmo lo hace, es asunto de la clase del objeto.
	 */
	
	
	@Override
	public int compareTo(TuplaDic<T1, T2> tupla) {	
		if(tupla == null){ 
			throw new NullPointerException("NullPointerException");
		}
		
		if(e1 == null && tupla.getE1() == null){ 
		return 0;
		}
 
		if(e1 != null && tupla.getE1() == null){  
			return 1;
		}	
		
		if(e1 == null && tupla.getE1() != null){ 
			return -1;
		}
 
		else{
			return e1.compareTo(tupla.getE1());
		}
	}

	
	
	
	//################################################################
}
