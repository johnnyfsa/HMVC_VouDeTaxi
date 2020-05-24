package Randomico;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import control.Cliente_Controller;
import model.Pessoa_Fisica;

class CriaClienteAleatorioTest {

	@Test
	void testGetCobaia() {
		Cliente_Controller.jsonRead();
		CriaClienteAleatorio cca = new CriaClienteAleatorio();
		assertTrue(cca.getCobaia() instanceof Pessoa_Fisica);
	}

	@Test
	void testGetRandomIndex() {
		fail("Not yet implemented");
	}
	
}
