package teste;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Cliente_Model;

class Cliente_ModelTest {

	@Test
	void testGetCpf() {
		Cliente_Model ClientTest = new Cliente_Model();
		assertTrue(ClientTest.getCpf().isEmpty());
	}

	@Test
	void testSetCpf() {
		Cliente_Model ClientTest = new Cliente_Model();
		ClientTest.setCpf("teste");
		assertEquals(ClientTest.getCpf(), "teste");
	}

}
