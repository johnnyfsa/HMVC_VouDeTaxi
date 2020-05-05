package teste;

import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Test;

import model.Usuario_Model;

class UsuarioTest {

	private boolean testando;
	@Test
	
	void test() {
Usuario_Model usuario = new Usuario_Model();
		
		testando = usuario.getNome().isEmpty();
		assertTrue(testando);
	}

}
