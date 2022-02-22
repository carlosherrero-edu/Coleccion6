package coleccion6;


import java.security.SecureRandom;
import java.util.Arrays;

public class Ejercicio16 {
	
	/**
	 * Función para desordenar aleatoriamente los elementos de un array 
	 * @param tabla array de 1 dimensión cuyos elementos queremos desordenar o barajar aleatoriamente
	 * No retorna valor , pues modifica el propio array devuelto
	 */
	public static void desordenar(int[] tabla) {

		int tamanio = tabla.length;

		SecureRandom dado = new SecureRandom();

		int[] tablaIndices = new int[tamanio];
		int[] tablaDesordenada = new int[tamanio];
		int indiceAzar;
		boolean repetido;

		/*
		 * la tabla de índices la iniciamos con valores negativos ES necesario pues si
		 * no se inicia a ceros, y 0 es un índice permitido
		 */
		Arrays.fill(tablaIndices, -100);

		/*
		 * ESte método de extracción al azar de índices no es muy eficiente lo hago para
		 * reutilizar el método estaEnLista codificado anteriormente
		 */
		for (int i = 0; i < tamanio; i++) {

			repetido = true;
			while (repetido) {
				// extraer indice al azar, entre 0 y tamanio-1
				indiceAzar = dado.nextInt(tamanio);
				// comprobamos si NO está en la lista
				if (!Utilidades.estaEnLista(tablaIndices, indiceAzar)) {
					// no está en la lista, por lo que lo insertamos
					tablaIndices[i] = indiceAzar;
					repetido = false; // para abandonar el bucle whie
				}
			} // fin del bucle while
		} // fin del bucle for

		/*
		 * tablaIndices consta ahora de los N índices del 0 a longitud-1, pero
		 * dispuestos al azar El siguiente bucle podríamos haberlo evitado, lo hago para
		 * mayor claridad
		 */
		for (int k = 0; k < tamanio; k++) {
			tablaDesordenada[k] = tabla[tablaIndices[k]];

		}

		// por último, hacemos una copia de tablaDesordenada sobre tabla
		System.arraycopy(tablaDesordenada, 0, tabla, 0, tamanio);
		// limpiamos referencias
		dado = null;
	} // fin del método

	public static void main(String[] args) {
		//array de prueba
		int [] tabla= new int[20];
		for (int i=0; i<tabla.length; i++) {
			tabla[i]=i+1;
		}
		
		System.out.println("\n*** Tabla original: ");
		System.out.println(Arrays.toString(tabla));
		
		System.out.println("\n*** Tabla desordenada: ");
		desordenar(tabla);
		System.out.println(Arrays.toString(tabla));
		
		System.out.println("\n*** Tabla vuelta a desordenar: ");
		desordenar(tabla);
		System.out.println(Arrays.toString(tabla));
		
		System.out.println("\n*** Tabla aún más desordenada: ");
		desordenar(tabla);
		System.out.println(Arrays.toString(tabla));
		
		
		
		

	}

}
