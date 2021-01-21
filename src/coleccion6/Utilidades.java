package coleccion6;

import java.security.SecureRandom;

public class Utilidades {

	/**
	 * @param N
	 * @return 
	 * Corresponde al ejercicio 1 de la Colección 6
	 */
	public static long[] serieFibonacci(int N) {
		
		//términos de la sucesión que guardaremos en un array de enteros largos
		long[] sucesion = new long [N];
		//inicializamos los 2 primeros términos
		sucesion[0]=1L;
		sucesion[1]=1L;
		
		//vamos obteniendo los demás
		for (int i=2; i<N; i++) {
			sucesion[i] = sucesion[i-1]+sucesion[i-2];
			
		}
		//devolvemos la lista 
		
		return sucesion;
	}

	/**
	 * @param cantidad
	 * @param monedas
	 * @return 
	 * Corresponde al ejercicio 2 de la Colección 6
	 */
	public static int[] devolverCambio(double cantidad, int[] monedas) {
		
		int tipos_moneda= monedas.length;
		int cantidad_monedas[] =new int[tipos_moneda]; 
		
		int centimos= (int)Math.round(cantidad*100);
		
		for (int i=0 ;i<tipos_moneda; i++) {
			cantidad_monedas[i] =(int) centimos/monedas[i]; //forzamos división entera
			centimos = centimos%monedas[i]; //guardamos el resto para continuar		
		}

		return cantidad_monedas;
	}

	/**
	 * @param cadena
	 * @return 
	 * Corresponde al ejercicio 3 de la Colección 6
	 */
	public static int[] contarCaracteres(String cadena) {

		int[] resultado={0,0,0}; 
		/* el primer elemento del array cuenta las letras
		 * el segundo los dígitos
		 *y el tercero los espacios el blanco
		 */
	char tecla;
	
	for (int i=0; i< cadena.length(); i++){
		 tecla= cadena.charAt(i);
		 if (Character.isLetter(tecla))
			 resultado[0]++;
		 else if (Character.isDigit(tecla))
			 resultado[1]++;
		 else if (Character.isWhitespace(tecla))
			 resultado[2]++;
	} //fin del bucle for
	
	return resultado;
	}

	/**
	 * @param lista
	 * @return 
	 * Corresponde al ejercicio 4 de la Colección 6
	 */
	public static double sumaArray(double[] lista) {

		double total=0;
		  
		  for (double sumando: lista)
			  		total += sumando;
		  return total;
	}

	/**
	 * @param lista
	 * @param factor
	 * @return 
	 * Corresponde al ejercicio 5 de la Colección 6
	 */
	public static double[] arrayMultiplicado(double[] lista, double factor) {
		
		double nuevoArray[]= new double[lista.length];

		for (int i=0; i< lista.length; i++) {
			nuevoArray[i] = lista[i] *factor;
		}
		return nuevoArray;
	}

	/**
	 * @param lista
	 * @return Corresponde al ejercicio 6 de la Colección 6
	 */
	public static double promedioArray(double[] lista) {
		
		if (lista.length ==0) {
			return Double.NaN;
		} else {
			return sumaArray(lista)/ lista.length;
		}
		}

		

	/**
	 * @param lista
	 * @param separador
	 * @return 
	 * Corresponde al ejercicio 7 de la Colección 6
	 */
	public static String concatenarCadenas(String[] lista, char separador) {

		 String cadenaFinal="";
		 //hay que agregar el separador para todos los elementos de la lista, salvo el último
		 for (int i=0; i< lista.length-1; i++) {
			 	cadenaFinal= cadenaFinal +lista[i]+ Character.toString(separador);
		 }
		 //para el último elemento de la lista, no hay que agragar separador
		 cadenaFinal= cadenaFinal +lista[lista.length-1];
		 
		return cadenaFinal;
	}

	/**
	 * @param lista
	 * @return 
	 * Corresponde al ejercicio 8 de la Colección 6
	 */
	public static int cadenaMayor(String[] lista) {

		//comenzamos por suponer que la cadena más larga tiene longitud 0
				int masLarga=0;
				 for (String s: lista){
					 	if (s.length() > masLarga)
					 		masLarga= s.length();
				 }
				 
				return masLarga;
	}

	/**
	 * Método para obtener una apuesta aleatoria a la Lotería Primitiva

	 * @return array de 7 enteros aleatorios, los 6 primeros entre 1 y 49, y el último entre 0 y 10
	 * Corresponde al ejercicio 9 de la Colección 6
	 */
	public static int[] apuestaPrimitiva() {
		 //array donde guardaremos la apuesta
		int[] numeros = new int[7];
		 int apuesta;
		 boolean repetido;
		 //objeto para generar números aleatorios 
		 SecureRandom aleatorio= new SecureRandom();
		 
		 //calculamos primero las apuestas de 1-49
		 for (int i=0; i<6; i++){
			 //para cada posición, buscamos un nuevo número aleatorio que no esté ya en la lista
			 do{
				 repetido=false;
				//extraemos un número aleatorio entre 1 y 49
				 apuesta= aleatorio.nextInt(49)+1 ; 
				 //comprobamos que no se repite en los términos anteriores
				 for (int j=0; j<i; j++) {
					 if (numeros[j]== apuesta) {
						  repetido = true;
					 }
				 }
				 
			} while (repetido);
			 /*cuando abandonemos el bucle do-while, significa que el número tomado aleatoriamente
			  * es diferente de todos los que hemos extraído antes, por lo que lo guardamos
			  */
			 numeros[i] = apuesta;
			 
		 } //fin del bucle for
		 
		 //el séptimo término es aleatorio entre 0 y 9
		 numeros[6]= aleatorio.nextInt(10);
		 
		 return numeros;
	}

	/**
	 * Método para obtener una apuesta aleatoria a la quiniela, pero controlando cuántos resultados de cada tipo queremos obtener
	 * @param unos cantidad de resultados uno, entre 0 y 14
	 * @param equis cantidad de resultados equs, entre 0 y 14
	 * @param doses cantidad de resultados dos, entre 0 y 14
	 * @return  un array de caracteres con los resultados generados aleatoriamente, o null
	 * devuelve null si los argumentos no cumplen la condición, o bien no suman 14
	 * Corresponde al ejercicio 10 de la Colección 6
	 */
	public static char[] apuestaQuiniela(int unos, int equis, int doses) {
		//llamamos al método de validación de la apuesta
		if (validarApuestaQuiniela (unos, equis, doses)) {
		
			char [] apuesta= new char[14];
			
			//contadadores con la cantidad de resultados de cada tipo que llevamos extraídos
			int num_1=0, num_x=0, num_2=0;
			int numero; //número aleatorio que iremos extrayendo
			boolean repetir;
		
			
			SecureRandom azar= new SecureRandom ();
			
			for (int i=0; i<14; i++){
				
				do {
					repetir = false;
					numero = azar.nextInt(3);  //número aleatorio entre 0 y 2
					
					//según cual sea el resultado, comprobamos si hemos sobrepasado la cantidad máxima pedida
					switch (numero) {
						case 0 -> {
							if (num_x < equis) {
								num_x++;
							} else {
								repetir=true;
							}
						}
						case 1 -> {
								if (num_1 < unos) {
									num_1++;
								} else {
									repetir=true;
								}
							}
						case 2 -> {
							if (num_2 < doses) {
								num_2++;
							} else {
								repetir=true;
							}
						}
					
					} //fin del switch
					
			
					
				} while (repetir);
				//guardamos el carácter correspondiente a la apuesta
				apuesta[i] = numero==0 ? 'X': (numero==1 ? '1' : '2');
			
			} //fin del for
			return apuesta;
		}  else {
			//la apuesta no es válida
			return null;
		}

	
	}
	
	/**
	 * Mëtodo para validar si una apuesta a la quiniela cumple las condiciones pedidas
	 * @param unos cantidad de resultados uno, entre 0 y 14
	 * @param equis cantidad de resultados equs, entre 0 y 14
	 * @param doses cantidad de resultados dos, entre 0 y 14
	 * @return true si los valores de entrada cumplen la condición pedida y suman 14, false en otro caso
	 * @see apuestaQuiniela
	 * Corresponde al ejercicio 10 de la Colección 6
	 */
	public static boolean validarApuestaQuiniela(int unos, int equis, int doses) {
		
		boolean apuestaOK =false;
		if( unos >=0 && equis >=0 && doses>=0) {
			if( unos<=14 && equis<=14 && doses<=14) {
				if (unos+equis+doses ==14) {
					apuestaOK= true;
				}
			}
		}
		
		return apuestaOK;
	}

}
