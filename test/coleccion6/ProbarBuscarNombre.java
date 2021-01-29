package coleccion6;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ProbarBuscarNombre {
	
	String[] nombres= {" Raúl", " Cristina   ", "Juan", " Alberto", "Sebastián  ", "Alicia  ", "Rebeca", "Carmen  ", "Celia  ", "Javier"};
	String[] nombresOrd= {" Alberto", "Alicia  ", "Carmen  ", "Celia  "," Cristina   ", "Javier", "Juan", " Raúl",  "Rebeca", "Sebastián  ",};

	

	@Test
	void buscarEnListaOrdenada() {
		assertEquals(4,Utilidades.buscarNombre(nombresOrd, "Cristina", true));
		assertEquals(0,Utilidades.buscarNombre(nombresOrd, "   Alberto   ", true));
		assertEquals(9,Utilidades.buscarNombre(nombresOrd, "Sebastián    ", true));
		assertTrue(Utilidades.buscarNombre(nombresOrd, "Cristinita", true) <0 );
		
	}
	
	@Test
	void buscarEnListaDesrdenada() {
		assertEquals(0,Utilidades.buscarNombre(nombres, "Raúl", false));
		assertEquals(9,Utilidades.buscarNombre(nombres, "   Javier   ", false));
		assertEquals(4,Utilidades.buscarNombre(nombres, "Sebastián    ", false));
		assertTrue(Utilidades.buscarNombre(nombres, "Cristinita", false) <0 );
		
	}

}
