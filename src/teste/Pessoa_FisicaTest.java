package teste;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Pessoa_Fisica;

class Pessoa_FisicaTest {

	@Test
	void testGetCpf() {
		Pessoa_Fisica ClientTest = new Pessoa_Fisica();
		assertTrue(ClientTest.getCpf().isEmpty());
	}

	@Test
	void testSetCpf() {
		Pessoa_Fisica ClientTest = new Pessoa_Fisica();
		ClientTest.setCpf("teste");
		assertEquals(ClientTest.getCpf(), "teste");
	}

}
