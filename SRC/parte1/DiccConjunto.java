package parte1;

public class DiccConjunto<K extends Comparable<K>, V> implements Diccionario<K, V>
{
	/**
	 * Conjunto privado que DiccConjunto usa para almacenar sus parejas
	 * (clave, significado).
	 */
	
	
	
	private Conjunto<TuplaDic<K, V>> elementos;
	private int tamaño; //Aumenta cada vez que ingresa un elemento o decrece cuando se quita

	public DiccConjunto() {
		elementos = new Conjunto<>();
	}

	
//################# IMPLEMENTACION ###########################################	

	/**
	 * Guardar(), se encarga de insertar la nueva tupla de elementos en el conjunto.
	 * Para esto debe verificar si el elemento ya pertenece o no dentro de la tupla.
	 * Esto lo corrobora llamando al metodo pertenece(Clave). 
	 * Una vez confirmada su no existencia dentro del conjunto,
	 * crea una nueva tupla con los dos parametros recibidos y la inserta.
	 * Por ultimo aumenta el tamaño. En caso de ya existir (pertenece es verdadero)
	 * suplanta la tupla ingresada por la nueva, es decir, estaria reemplazando el valor.
	 * La forma de hacer esto es eliminando la tupla que ya existe en el conjunto, 
	 * e insertando la nueva con valor diferente (aunque podria ser el mismo). 
	 * Aumentamos el tamaño tambien en este caso ya que el metodo eliminar(Clave), 
	 * lo disminuye.
	 */
	@Override
	public void guardar(K clave, V valor) {
			if (!pertenece(clave)) {
				TuplaDic tupla = new TuplaDic(clave, valor);
				elementos.agregar(tupla);
				tamaño++;
				System.out.println("Valores agregados");
			}
			else {
				eliminar(clave);
				TuplaDic tupla = new TuplaDic(clave, valor);
				elementos.agregar(tupla);
				System.out.println("Valores sobreescritos");
				tamaño++; 
			}
	}

	/**
	 * obtener(), recibe una clave como parametro y devuelve el valor que
	 * tiene asociado, dentro del conjunto. Esto lo hace siempre que dicha 
	 * clave pertenezca al conjunto, si pertenece = true entonces crea una 
	 * tupla de consulta para llamar al metodo recuperar, quien devuelve la tupla.
	 * Como nosotros queremos solo el valor, detallamos que solo nos devuelva el mismo.
	   En caso de no pertenecer, se devuelve null. 
	 */
	@Override
	public V obtener(K clave) {
		if (pertenece(clave)) {
			TuplaDic tuplaRequest = new TuplaDic(clave, null);
			return (V) elementos.recuperar(tuplaRequest).getE2();
		}
		System.out.println("La clave no pertenece");
		return null;

	}

	
	/**pertenece(clave), recibe una clave como parametro y devuelve true si dicha clave
	 * esta asociada a un valor, dentro del conjunto. Es decir, si existe una tupla 
	 * con dicha clave. Para esto se hace una tupla de consulta para preguntar con
	 * el metedo pertenece(tupla) propio de la clase Conjunto, si la clave de dicha tupla,
	 * ya existe dentor del conjunto.
	 * Tupla de consulta es una tupla que armo solamente para saber si la clave ya existe en el diccionario
	   por eso siempre el valor es null
	 */
	@Override
	public boolean pertenece(K clave) {		
			TuplaDic tuplaRequest = new TuplaDic(clave, null);
			return elementos.pertenece(tuplaRequest);
		
	}

	/**eliminar(clave), quita la tuplaDicc del conjunto, en caso de que exista
	 *  dentro del mismo. Esto lo hace llamando al metodo pertenece(clave).
	 *   De ser asi, lo quita llamando al metodo quitar(tupla) de la clase conjunto.
	 *    Paso siguiente disminuye el tamaño.
	*/
	@Override
	public void eliminar(K clave) {
		if (pertenece(clave)) { 
			TuplaDic tuplaRequest = new TuplaDic(clave, null);
			elementos.quitar(tuplaRequest);
			tamaño --;
		}
	}

	@Override
	public int tamaño() {//devuelve el tamaño actual del conjunto.
		return tamaño;
	}
	
	
//################################################################
	

}
