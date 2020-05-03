package Teste;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Usuario;

class UsuarioTest {

	private boolean testando;
	@Test
	
	void test() {
Usuario usuario = new Usuario();
		
		testando = usuario.getNome().isEmpty();
		assertTrue(testando);
		fail("Not yet implemented");
	}

}
