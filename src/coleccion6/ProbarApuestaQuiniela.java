package coleccion6;

public class ProbarApuestaQuiniela {

	static void imprimirApuesta (char[] apuesta) {
		String cadenaApuesta= "";
		String separador="-";
		if (apuesta !=null) {
			for (char item : apuesta) {
				cadenaApuesta= cadenaApuesta+item+ separador;
			}
			//la imprimimos savo el último caracter
			System.out.println(cadenaApuesta.substring(0, cadenaApuesta.length() -1));	
		} else {
			System.out.println("Apuesta no válida");
		}
		
	}
	
	public static void main(String[] args) {
		char[] apuesta1= Utilidades.apuestaQuiniela (0,0,0);
		imprimirApuesta(apuesta1);   //debe dar vació
		
		char[] apuesta2= Utilidades.apuestaQuiniela (5,5,5);
		imprimirApuesta(apuesta2);   //debe dar vació
		
		char[] apuesta3= Utilidades.apuestaQuiniela (7,8,-1);
		imprimirApuesta(apuesta3);   //debe dar vació
		
		char[] apuesta4= Utilidades.apuestaQuiniela (14,0,0);
		imprimirApuesta(apuesta4);   
		
		char[] apuesta5= Utilidades.apuestaQuiniela (8,6,0);
		imprimirApuesta(apuesta5);   
		
		char[] apuesta6= Utilidades.apuestaQuiniela (4,5,5);
		imprimirApuesta(apuesta6);   

	}

}
