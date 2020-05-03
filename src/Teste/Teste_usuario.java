package Teste;

import static org.junit.Assert.assertTrue;

import model.Usuario;
import  org.junit.Test;

public class Teste_usuario {
	
	private boolean testando;
	@Test
	
	public void teste_nome()
	{
		Usuario usuario = new Usuario();
		
		testando = usuario.getNome().isEmpty();
		assertTrue(testando);
		
		
	}

}
