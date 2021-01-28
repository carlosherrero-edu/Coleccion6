package coleccion6;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LetrasNIFTest {
	
	//valores de prueba para el DNI
	int dniFranco=1;
	int dniEmerito=10;
	int dniNoNacido=99999998;
	int extranjero=9999999;

	@Test
	void testCalcularLetraNIF() {
		assertTrue(Utilidades.letraNIF(dniFranco)=='R');
		assertTrue(Utilidades.letraNIF(dniEmerito)=='X');
		assertTrue(Utilidades.letraNIF(dniNoNacido)=='T');
	}
	
	@Test
	void testCalcularLetraNIE() {
		assertEquals('J', Utilidades.letraNIE("X"+String.valueOf(extranjero)));
		assertEquals('G', Utilidades.letraNIE("Y"+String.valueOf(extranjero)));
		assertEquals('H', Utilidades.letraNIE("Z"+String.valueOf(extranjero)));
		assertEquals('D', Utilidades.letraNIE("A"+String.valueOf(extranjero)));
		assertEquals('\u0000', Utilidades.letraNIE("B"+String.valueOf(extranjero)));
		;
	}

}
