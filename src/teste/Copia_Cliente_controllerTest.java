package teste;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import control.Copia_Cliente_controller;
import model.Pessoa_Fisica;
import model.Usuario_Model;

class Copia_Cliente_controllerTest {

	
	void testeRemover() 
	{
		Copia_Cliente_controller cliente = new Copia_Cliente_controller();
		
		
		cliente.jsonRead();
	
		cliente.remover("testanto1", "", "");
		ArrayList<Pessoa_Fisica> aux = cliente.getList();
		System.out.println(aux.size());
		
		assertEquals(aux.size(), 1);
		
	}
		
	void testeBusca()
	{
		Copia_Cliente_controller cliente = new Copia_Cliente_controller();
		ArrayList<Pessoa_Fisica> aux;
		cliente.jsonRead();
		aux = cliente.busca("testanto1", "", "");
		
		assertEquals(aux.size(), 2);
		
		assertEquals(aux.get(0).getNome(), "testanto1");
		assertEquals(aux.get(1).getNome(), "testanto1");
		
//		System.out.println(aux.getNome());
//		System.out.println(aux.getCpf());
		
//		assertEquals(aux.getNome(), "testanto1");
//		assertEquals(aux.getCpf(), "testando4");
//		assertEquals(aux.getSenha(), "testandoB");
//		assertEquals(aux.getUsuario(), "testando2");
	}
	@Test
	void testeAdicionar() 
	{
			
		Copia_Cliente_controller cliente = new Copia_Cliente_controller();
		cliente.jsonRead();
		cliente.adicionar("testanto1", "testando2", "testandoB", "testando4");
			
		ArrayList<Pessoa_Fisica> TempList = cliente.getList();
			
		System.out.println(TempList.size());
			
			
			
//			Pessoa_Fisica aux = TempList.get(0);
//			assertEquals(aux.getNome(), "entrada1" );
//			assertEquals(aux.getUsuario(), "entrada2" );
//			assertEquals(aux.getSenha(), "entradaB");
//			assertEquals(aux.getCpf(), "entrada4");
	}

}
