package coleccion6;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ConversoresGradosTest {
	final double ERROR=1e-5;  //error admisible en las comparaciones
	int [] angulo1= {10,59,59};
	
	int [] angulo2= {10,1,1};
	
	
	int [] angulo4= {30,0,0};
	
	int [] angulo5= {45,0,0};
	
	int [] angulo6= {60,0,0};
	
	

	@Test
	void testDeGradosARadianes() {
		assertEquals(Math.PI/6, Utilidades.deGradosARadianes(30, 0, 0), ERROR);
		assertEquals(Math.PI/4, Utilidades.deGradosARadianes(45, 0, 0), ERROR);
		assertEquals(Math.PI/3, Utilidades.deGradosARadianes(60, 0, 0), ERROR);
	}

	@Test
	void testDeRadianesAGrados() {
		Assertions.assertArrayEquals(angulo4, Utilidades.deRadianesAGrados(Math.PI/6));
		Assertions.assertArrayEquals(angulo5, Utilidades.deRadianesAGrados(Math.PI/4));
		double radianes1= Utilidades.deGradosARadianes(angulo1[0], angulo1[1], angulo1[2]);
		double radianes2= Utilidades.deGradosARadianes(angulo2[0], angulo2[1], angulo2[2]);
		Assertions.assertArrayEquals(angulo1, Utilidades.deRadianesAGrados(radianes1));
		Assertions.assertArrayEquals(angulo2, Utilidades.deRadianesAGrados(radianes2));
	}

}
