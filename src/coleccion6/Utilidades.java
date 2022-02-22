package coleccion6;

import java.security.SecureRandom;
import java.util.Arrays;

/**
 * Funciones para la resoluci�n de los ejercicios de la Colecci�n 6 de Programaci�n
 * @author Carlos Herrero
 * @version 2.0 -enero 2021
 *
 */
public class Utilidades {

	/**
	 * Funci�n que obtiene y devuelve en un array los N primeros t�rminos de la serie de Fibonacci
	 * @param N n�mero de t�rminos que queremos obtener de la serie, debe ser N>=2 
	 * @return array de enteros largos con los primeros N elementos de la serie
	 * Corresponde al ejercicio 1 de la Colecci�n 6
	 */
	public static long[] serieFibonacci(int N) {
		
		//t�rminos de la sucesi�n que guardaremos en un array de enteros largos
		long[] sucesion = new long [N];
		//inicializamos los 2 primeros t�rminos
		sucesion[0]=1L;
		sucesion[1]=1L;
		
		//vamos obteniendo los dem�s
		for (int i=2; i<N; i++) {
			sucesion[i] = sucesion[i-1]+sucesion[i-2];
			
		}
		//devolvemos la lista 
		
		return sucesion;
	}

	/**
	 * Funci�n que calcula el cambio a entregar en monedas de una cantidad en Euros, entregando el menor n�mero posible de monedas
	 * @param cantidad  cantidad de la que debemos entregar el cambio, que se supone inferior a 10 euros
	 * @param monedas array de enteros con los valores en c�ntimos de las monedas de euro, ordenado decrecientemente
	 * @return  array de enteros con la cantidad de monedas de cada valor que debe entregarse
	 * Corresponde al ejercicio 2 de la Colecci�n 6
	 */
	public static int[] devolverCambio(double cantidad, int[] monedas) {
		
		int tipos_moneda= monedas.length;
		int cantidad_monedas[] =new int[tipos_moneda]; 
		
		int centimos= (int)Math.round(cantidad*100);
		
		for (int i=0 ;i<tipos_moneda; i++) {
			cantidad_monedas[i] =(int) centimos/monedas[i]; //forzamos divisi�n entera
			centimos = centimos%monedas[i]; //guardamos el resto para continuar		
		}

		return cantidad_monedas;
	}
	
	/**
	 * Funci�n que calcula el cambio a entregar en monedas de una cantidad en Euros, entregando el menor n�mero posible de monedas
	 * ES una versi�n sobrecargada en la que se establece como constante los tipos de monedas existentes
	 * @param cantidad  cantidad de la que debemos entregar el cambio, que se supone inferior a 10 euros
	 * @return  array de enteros con la cantidad de monedas de cada valor que debe entregarse
	 * Corresponde al ejercicio 2 de la Colecci�n 6
	 */
	public static int[] devolverCambio(double cantidad) {
		
		final int[] TIPOS_MONEDA= {200,100,50,20,10,5,2,1};
		return devolverCambio( cantidad, TIPOS_MONEDA);
		
	}

	/**
	 * Funci�n que cuenta el n�mero de letras, d�gitos y separadores que existen en una cadena de texto
	 * @param cadena cadena de texto a procesar
	 * @return array entero con la cantidad de letras, d�gitos y separadores detectados, en ese orden
	 * Corresponde al ejercicio 3 de la Colecci�n 6
	 */
	public static int[] contarCaracteres(String cadena) {

		int[] resultado={0,0,0}; 
		/* el primer elemento del array cuenta las letras
		 * el segundo los d�gitos
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
	 * Funci�n que calcula la suma de una lista de n�meros
	 * @param lista lista de n�meros decimales
	 * @return valor de su suma
	 * Corresponde al ejercicio 4 de la Colecci�n 6
	 */
	public static double sumaArray(double[] lista) {

		double total=0;
		  
		  for (double sumando: lista)
			  		total += sumando;
		  return total;
	}

	/**
	 * Funci�n que multiplica una lista de n�meros por un factor
	 * @param lista lista de n�meros decimales
	 * @param factor factor por el que se van a multiplizar
	 * @return  lista obtenida al multiplicar cada n�mero de la lista de entrada por el factor indicado
	 * Corresponde al ejercicio 5 de la Colecci�n 6
	 * 
	 */
	public static double[] arrayMultiplicado(double[] lista, double factor) {
		
		double nuevoArray[]= new double[lista.length];

		for (int i=0; i< lista.length; i++) {
			nuevoArray[i] = lista[i] *factor;
		}
		return nuevoArray;
	}

	/**
	 * Funci�n que calcula la media aritm�tica de una lista de n�meros decimales
	 * @param lista lista de n�meros de entrada
	 * @return media aritm�tica, o el valor Double.NaN si la lista est� vac�a
	 * Corresponde al ejercicio 6 de la Colecci�n 6
	 * @see sumaArray
	 */
	public static double promedioArray(double[] lista) {
		
		if (lista.length ==0) {
			return Double.NaN;
		} else {
			return sumaArray(lista)/ lista.length;
		}
	}

		

	/**
	 * Funci�n que concatena una lista de cadenas usando un car�cter separador
	 * @param lista lista de cadenas que se quieren concatenar
	 * @param separador car�cter que se usar� como separador entre cadena y cadena.
	 * @return cadena resultante de la concatenaci�n. Si la lista est� vac�a, se devuelve ""
	 * Corresponde al ejercicio 7 de la Colecci�n 6
	 */
	public static String concatenarCadenas(String[] lista, char separador) {

		 String cadenaFinal="";
		 //hay que agregar el separador para todos los elementos de la lista, salvo el �ltimo
		 if (lista!=null) {
			 for (int i=0; i< lista.length-1; i++) {
				 	cadenaFinal= cadenaFinal +lista[i]+ Character.toString(separador);
			 }
			 //para el �ltimo elemento de la lista, no hay que agragar separador
			 cadenaFinal= cadenaFinal +lista[lista.length-1];
		 }
		 
		return cadenaFinal;
	}

	/**
	 * Funci�n que devuelve la longitud de la cadena m�s larga de una lista de cadenas
	 * @param lista lista de cadenas de entrada
	 * @return longitud de la cadena m�s larga(con mayor n�mero de caracteres), o 0 si no se pasan cadenas
	 * Corresponde al ejercicio 8 de la Colecci�n 6
	 */
	public static int cadenaMayor(String[] lista) {

		//comenzamos por suponer que la cadena m�s larga tiene longitud 0
		int masLarga=0;
		if (lista != null) {
				
				 for (String s: lista){
					 	if (s.length() > masLarga)
					 		masLarga= s.length();
				 }
		}
				 
		return masLarga;
	}

	/**
	 * Funci�n para obtener una apuesta aleatoria a la Loter�a Primitiva

	 * @return array de 7 enteros aleatorios, los 6 primeros entre 1 y 49, y el �ltimo entre 0 y 10
	 * Corresponde al ejercicio 9 de la Colecci�n 6
	 * @see estaEnLista
	 */
	public static int[] apuestaPrimitiva() {
		 //array donde guardaremos la apuesta
		int[] numeros = new int[7];
		 int apuesta;
		 boolean repetido;
		 //objeto para generar n�meros aleatorios 
		 SecureRandom aleatorio= new SecureRandom();
		 
		 //calculamos primero las apuestas de 1-49
		 for (int i=0; i<6; i++){
			 //para cada posici�n, buscamos un nuevo n�mero aleatorio que no est� ya en la lista
			 do{
				//extraemos un n�mero aleatorio entre 1 y 49
				 apuesta= aleatorio.nextInt(49)+1 ; 
				 //comprobamos que no se repite en los t�rminos anteriores, llamando al m�todo estaEnLista
				 repetido= estaEnLista(numeros, apuesta);
				 
			} while (repetido);
			 /*cuando abandonemos el bucle do-while, significa que el n�mero tomado aleatoriamente
			  * es diferente de todos los que hemos extra�do antes, por lo que lo guardamos
			  */
			 numeros[i] = apuesta;
			 
		 } //fin del bucle for
		 
		 //el s�ptimo t�rmino es aleatorio entre 0 y 9
		 numeros[6]= aleatorio.nextInt(10);
		 
		 return numeros;
	}
	
	/**
	 * M�todo auxiliar para saber si un n�mero est� ya presente en una lista
	 * @param lista
	 * @param buscado
	 * @return true si el n�mero est� ya en la lista, false en caso contrario
	 */
	static boolean estaEnLista (int[] lista, int buscado) {
		
		boolean encontrado= false;
		
		int posicion=0;
		while (!encontrado && posicion < lista.length) {
			if (lista[posicion]==buscado) {
				encontrado=true;
			}
			posicion++;
		}
		
		return encontrado;
	}

	/**
	 * Funci�n para obtener una apuesta aleatoria a la quiniela, pero controlando cu�ntos resultados de cada tipo queremos obtener
	 * @param unos cantidad de resultados uno, entre 0 y 14
	 * @param equis cantidad de resultados equs, entre 0 y 14
	 * @param doses cantidad de resultados dos, entre 0 y 14
	 * @return  un array de caracteres con los resultados generados aleatoriamente, o null
	 * devuelve null si los argumentos no cumplen la condici�n, o bien no suman 14
	 * Corresponde al ejercicio 10 de la Colecci�n 6
	 */
	public static char[] apuestaQuiniela(int unos, int equis, int doses) {
		//llamamos al m�todo de validaci�n de la apuesta
		if (validarApuestaQuiniela (unos, equis, doses)) {
		
			char [] apuesta= new char[14];
			
			//contadadores con la cantidad de resultados de cada tipo que llevamos extra�dos
			int num_1=0, num_x=0, num_2=0;
			int numero; //n�mero aleatorio que iremos extrayendo
			boolean repetir;
		
			
			SecureRandom azar= new SecureRandom ();
			
			for (int i=0; i<14; i++){
				
				do {
					repetir = false;
					numero = azar.nextInt(3);  //n�mero aleatorio entre 0 y 2
					
					//seg�n cual sea el resultado, comprobamos si hemos sobrepasado la cantidad m�xima pedida
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
				//guardamos el car�cter correspondiente a la apuesta
				apuesta[i] = numero==0 ? 'X': (numero==1 ? '1' : '2');
			
			} //fin del for
			return apuesta;
		}  else {
			//la apuesta no es v�lida
			return null;
		}

	
	}
	
	/**
	 * M�todo para validar si una apuesta a la quiniela cumple las condiciones pedidas
	 * @param unos cantidad de resultados uno, entre 0 y 14
	 * @param equis cantidad de resultados equs, entre 0 y 14
	 * @param doses cantidad de resultados dos, entre 0 y 14
	 * @return true si los valores de entrada cumplen la condici�n pedida y suman 14, false en otro caso
	 * @see apuestaQuiniela
	 * Corresponde al ejercicio 10 de la Colecci�n 6
	 */
	public static boolean validarApuestaQuiniela(int unos, int equis, int doses) {
		
		boolean apuestaOK =false;
		if( unos >=0 && equis >=0 && doses>=0) {
			if( unos<=14 && equis<=14 && doses<=14) {         //esta validaci�n no es estrictamente necesaria
				if (unos+equis+doses ==14) {
					apuestaOK= true;
				}
			}
		}
		
		return apuestaOK;
	}
	
	/**
	 * Funci�n para calcular la letra de verificaci�n correspondiente a un DNI espa�ol
	 * @param dni entero con el valor del DNI, que suponemos comprendido entre 0 y 99999999
	 * @return car�cter con la letra de verificaci�n que corresponde al resultado del resto entre 23
	 * Corresponde al ejercicio 11 de la Colecci�n 6
	 */
	public static char letraNIF (int dni) {
		
		//aunque se puede plantear con un array de caracteres, es m�s sencillo tomar la posici�n de un String
		
		final String LETRAS="TRWAGMYFPDXBNJZSQVHCKE";  //letras que corresponden a cada valor del resto
		
		return LETRAS.charAt(dni%23);
	}
	
	/**
	 *  Funci�n para calcular la letra de verificaci�n correspondiente a un NIE de residente extranjero
	 * @param nie cadena con el valor del NIE, que suponemos sigue el patr�n A9999999 (1 letra + 7 d�gitos)
	 * @return car�cter con la letra de verificaci�n del NIE, o el car�cter '\u0000' si es un NIE no v�lido
	 * Corresponde al ejercicio 12 de la Colecci�n 6
	 * @see letraNIF
	 */
	public static char letraNIE (String nie) {
		
		
		int dni;
		
		// convertimos la letra inicial del NIE en el d�gito establecido por la autoridad que dise�� el sistema
		switch (nie.charAt(0)){
			case 'X' -> {
				dni= Integer.parseInt("0"+ nie.substring(1));
				}
			case 'Y' -> {
				dni= Integer.parseInt("1"+ nie.substring(1));
			}
			case 'Z' -> {
				dni= Integer.parseInt("2"+ nie.substring(1));
			}case 'A' -> {
				dni= Integer.parseInt("3"+ nie.substring(1));
			}
			default ->{
				//si no es un valor v�lido, devolvemos el car�cter unicode "nulo"
				return '\u0000';
			}
			
		}
		
		return letraNIF(dni);
		
	}
	
	/**
	 * M�todo que genera unas medidas estad�sticas b�sicas a partir de una lista de valores
	 * @param lista lista de n�meros (enteros o decimales) como entrada de datos
	 * @return lista de 6 n�meros decimales que contienen, en este orden:
	 * 			- el n�mero de elementos pasados
	 * 			- el menor n�mero de la lista
	 * 			- el mayor n�mero de la lista
	 * 			- la moda, o el valor que m�s se repite en la lista (si hay m�s de un valor con ese n�mero de repeticiiones, el valor m�s peque�o)
	 * 			- la media aritm�tica
	 * 			- la varianza
	 * @see calcularModa
	 * @see promedioArray
	 * @see calcularVarianza
	 */
	public static double[] estadisticaLista (double[] lista) {
		
		double [] resultado = new double[6];
		
		if (lista!= null) {
			
			//ordenamos la lista de menor a mayor, con los métodos de la clase Arrays
			Arrays.sort(lista);
			
			resultado[0]= lista.length;
			resultado[1] = lista[0];  //el menor es el primer elemento de la lista ordenada
			resultado[2] = lista[ lista.length-1];  //el mayor es el �ltimo elemento de la lista ordenada
			resultado[3] = calcularModa(lista);
			resultado[4] = promedioArray(lista);
			resultado[5] = calcularVarianza(lista);
		}
				
		return resultado;		
	
	}
	
	/**
	 * M�todo para calcular la moda, o valor que m�s se repite en una lista
	 * @param lista lista de n�meros (enteros o decimales) como entrada de datos
	 * @return moda, o el valor que m�s se repite en la lista 
	 * (si hay m�s de un valor con ese n�mero de repeticiiones, el valor m�s peque�o)
	 * @see cuentaRepeticiones
	 */
	 static double calcularModa (double[] lista) {
		
		double moda=lista[0];
		int frecuencia_max=0;  //valores iniciales
		
		int frecuencia;
		// en un futuro, cuando conozcamos las colecciones y los Set, podremos resolverlo de forma m�s eficiente
		for (int i=0; i<lista.length; i++) {
			frecuencia= cuentaRepeticiones(lista, lista[i]);
			if (frecuencia> frecuencia_max && lista[i] <= moda){
				moda = lista[i];
				frecuencia_max=frecuencia;
				
			}
			
		} //fin del bucle for
		return moda;
	}
	
	/**
	 * Metodo para contar cu�ntas veces se repite un elemento en una lista
	 * @param lista lista de n�meros (enteros o decimales) como entrada de datos
	 * @param elemento valor del que contaremos el n�mero de repeticiones
	 * @return n�mero de repeticiones del elemento en la lista
	 */
	static int cuentaRepeticiones( double[] lista, double elemento) {
		
		int contador=0;
		for (double valor: lista) {
			if ( valor==elemento) {
				contador++;
			}
		}
		return contador;
	}
	
	 /**
	  * M�todo para calcular la varianza de una lista num�rica
	 * @param lista lista lista de n�meros (enteros o decimales) como entrada de datos
	 * @return valor de la varianza, o diferencia entre la media de los cuadrados y el cuadrado de la media
	 * @see promedioArray
	 */
	static double calcularVarianza (double[] lista) {
		 
		 double varianza;
		 //generamos un array con los cuadrados de cada elemento de la lista
		 double[] listaCuadrados= new double [lista.length];
		 
		 for (int i=0; i<lista.length; i++) {
			 listaCuadrados[i]= Math.pow(lista[i], 2);
			 
		}
		 /*aplicamos la f�rmula de c�lculo de la varianza: 
		  * El promedio de los cuadrados menos el cuadrado del promedio de la lista
		  */
		varianza= promedioArray(listaCuadrados) - Math.pow( promedioArray(lista),2);
		
		return varianza;
	}
	 
	 /**
	  * Funci�n para convertir de grados a radianes
	 * @param grados grados de circunferencia
	 * @param minutos minutos de circunferencia, entre 0 y 59
	 * @param segundos  segundos de circunferencia, entre 0 y 59
	 * @return valor equivalente del �ngulo en radianes
	 */
	public static double deGradosARadianes (int grados, int minutos, int segundos) {
		 final double CONVERSION=60.0;
		 double angulo= grados+ minutos/CONVERSION + segundos/Math.pow(CONVERSION, 2);
		 return (angulo*2*Math.PI / 360.0);
	 }
	 
	 
	 /**
	  * Funci�n para convertir  de radianes a grados de circunferencia
	 * @param radianes valor del �ngulo en radianes
	 * @return array con 3 enteros indicando los grados, minutos y segundos del �ngulo equivalente
	 */
	public static int[] deRadianesAGrados (double radianes) {
		 final int CONVERSION=60;
		int angulo;
		int[] resultado=new int[3];
		//pasamos los radianes a segundos de arco, para poder empezar a calcular 
		angulo= (int)(360*CONVERSION*CONVERSION*radianes/(2*Math.PI));
		//obtenemos los segundos
		resultado[2] = angulo%CONVERSION; //segundos de arco
		angulo = angulo / CONVERSION;
		//obtenemos los minutos
		resultado[1] = angulo%CONVERSION; //minutos
		//lo que queda son los grados
		resultado[0]= angulo /CONVERSION;
	
		 return resultado;
	 }
	
	
	/**
	 * Funci�n para buscar la posici�n en que se encuentra un nombre en una lista de nombres
	 * Si la lista est� ordenada, utilizamso el algoritmo de b�squeda binaria
	 * Si no est� ordenada, usamos b�squeda secuencial en la lista
	 * @param nombres  array con la lista de nombres en los que vamos a buscar
	 * @param buscado  cadena/nombre que buscamos en la lista
	 * @param ordenada true si la lista est� ordenada, false en otro caso
	 * @return primera posici�n donde se encuentra el nombre buscado, o <0 si no se encuentra
	 */
	public static int buscarNombre (String[] nombres, String buscado, boolean ordenada) {
		int posicion;
		//cadena buscada en may�scula y sin espacios
		String buscadoM = buscado.toUpperCase().trim();
		if (ordenada) {
			//realizamos la b�squeda binaria que ya viene integrada en Arrays
			//generamos un array nombresM con todos los nombres en may�scula y sin espacios finales
			String[] nombresM= new String[nombres.length];
			for (int i=0; i<nombres.length; i++) {
				nombresM[i] = nombres[i].toUpperCase().trim();
			}
			//ahora llamamos al m�todo de la clase Arrays
			posicion= Arrays.binarySearch(nombresM, buscadoM);
			
		} else {
			//hacemos b�squeda secuencial hasta que lo encontremos o acabemos la lista
			boolean encontrado=false;
			int contador=0;
			while (!encontrado && contador<nombres.length) {
				if (nombres[contador].trim().equalsIgnoreCase(buscadoM)) {
					encontrado=true;
				} else {
					contador++;
				}
			} //fin del while
			if (encontrado) {
				posicion= contador;
			} else {
				posicion=-1;
			}
		} //fin de la b�squeda no ordenada
		return posicion;
	}
	
	

}
