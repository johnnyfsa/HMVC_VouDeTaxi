package teste;

import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Test;

import model.Usuario;

class UsuarioTest {

	private boolean testando;
	@Test
	
	void test() {
Usuario usuario = new Usuario();
		
		testando = usuario.getNome().isEmpty();
		assertTrue(testando);
	}

}
