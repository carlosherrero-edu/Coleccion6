package coleccion6;

public class probarDevolverCambio {
	
	static final int[] MONEDAS_EURO= {200, 100, 50, 20, 10, 5, 2, 1};
	
	public static void main(String[] args) {
		
		double cantidad= 5.78;
		int[] monedas = Utilidades.devolverCambio (cantidad, MONEDAS_EURO);
		
		for (int i=0; i< MONEDAS_EURO.length; i++) {
			
			if (monedas[i]>0) {
				System.out.format( "\n Monedas de  % d céntimos : %d",MONEDAS_EURO[i], monedas[i] );
			}
			
			
		}
		
	}

}
