package parte1;

/**
 * Algunas pruebas para la parte 1 del TP.
 */
public class Main
{
	public static void main(String[] args) {
		probarTuplaEquals();
		probarTuplaCompareTo();
		probarDiccConjunto();
		probarTuplaCasosBorde();
		
	}
	
	private static void probarTuplaCasosBorde()
	{
	TuplaDic<String, Integer> a = new TuplaDic<>("a", 1);
	TuplaDic<String, Integer> n1 = new TuplaDic<>(null, 1);
	TuplaDic<String, Integer> n2 = new TuplaDic<>(null, 2);
	// ("a", 1) != (null, 1)
	resultado("Tupla equals otra.E1 == null", !a.equals(n1));
	resultado("Tupla equals this.E1 == null", !n1.equals(a));
	resultado("Tupla equals this.E1 == null && otra.E1 == null",
	n1.equals(n2));
	// ("a", 1) > (null, 1)
	resultado("Tupla compareTo otra.E1 == null", a.compareTo(n1) > 0);
	resultado("Tupla compareTo this.E1 == null", n1.compareTo(a) < 0);
	resultado("Tupla compareTo this.E1 == null && otra.E1 == null",
	n1.compareTo(n2) == 0);
	}


	private static void probarTuplaEquals() {
		TuplaDic<String, Integer> a1 = new TuplaDic<>("a", 1);
		TuplaDic<String, Integer> a2 = new TuplaDic<>("a", 1);
		TuplaDic<String, Integer> b1 = new TuplaDic<>("b", 1);
		TuplaDic<String, Integer> b2 = new TuplaDic<>("b", 2);
		resultado("Tuplas iguales", a1.equals(a2));
		resultado("Misma tupla", a1.equals(a1));
		resultado("Distinto E1", !a1.equals(b1));
		resultado("Distinto E2", b1.equals(b2));
		resultado("Comparar null", !a1.equals(null));
		resultado("Comparar no tupla", !a1.equals("a"));
	}

	private static void probarTuplaCompareTo() {
		TuplaDic<String, Integer> a1 = new TuplaDic<>("a", 1);
		TuplaDic<String, Integer> a2 = new TuplaDic<>("a", 1);
		TuplaDic<String, Integer> b1 = new TuplaDic<>("b", 1);
		TuplaDic<String, Integer> b2 = new TuplaDic<>("b", 2);
		resultado("Tuplas compare iguales", a1.compareTo(a2) == 0);
		resultado("Misma tupla compare", a1.compareTo(a1) == 0);
		resultado("Distinto E1 mayor", a1.compareTo(b1) < 0);
		resultado("Distinto E1 menor", b1.compareTo(a1) > 0);
		resultado("Distinto E2 compare", b1.compareTo(b2) == 0);
	}

	private static void probarDiccConjunto() {
		Diccionario<String, Integer> edades = new DiccConjunto<>();
		resultado("Dicc tamaño 0", edades.tamaño() == 0);
		resultado("Dicc pertenece vacio", !edades.pertenece("a"));
		resultado("Dicc ovtener vacio", edades.obtener("a") == null);

		edades.guardar("Ana", 27);
		resultado("Dicc tamaño 1", edades.tamaño() == 1);
		resultado("Dicc pertenece uno", edades.pertenece("Ana"));
		resultado("Dicc obtener uno", edades.obtener("Ana") == 27);

		edades.guardar("Ana", 28);
		resultado("Dicc reemplazo 1", edades.tamaño() == 1);
		resultado("Dicc obtener reemplazo", edades.obtener("Ana") == 28);

		edades.guardar("Carlos", 26);
		resultado("Dicc tamaño 2", edades.tamaño() == 2);

		edades.eliminar("Diana"); // No existe.
		resultado("Dicc tamaño eliminar no existente", edades.tamaño() == 2);

		edades.eliminar("Ana");
		resultado("Dicc tamaño eliminar 2->1", edades.tamaño() == 1);

		edades.eliminar("Carlos");
		resultado("Dicc tamaño eliminar 1->0", edades.tamaño() == 0);
	}

	private static void resultado(String msg, boolean r) {
		System.out.println(msg + ": " +
		                (r ? "OK" : ("ERROR (" + r + ")")));
	}

}
