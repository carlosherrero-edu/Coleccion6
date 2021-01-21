package coleccion6;
import java.util.Scanner;


public class ProbarContarCaracteres {

	public static void main(String[] args) {
		Scanner teclado= new Scanner (System.in);
		System.out.println("Introduce una cadena de caracteres");
		String s= teclado.nextLine();
		
		int []conteos= Utilidades.contarCaracteres(s);
		
		System.out.format( "La cadena introducida tiene %d letras, %d dígitos y %d espacios.",
							conteos[0], conteos[1], conteos[2]);
		
		teclado.close();
	
	}

}
