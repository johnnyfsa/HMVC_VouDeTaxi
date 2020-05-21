package teste;



import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;


import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import control.Cliente_Controller;

import model.Pessoa_Fisica;

class Cliente_ControllerTest {

	@Before public void setUp() 
	{
	     
	 
	      
	   }
	
	@Test
   void testeAdicionar() 
	{
		
		Cliente_Controller cliente = new Cliente_Controller();
		
		cliente.jsonRead();
		
		cliente.adicionar("teste", "teste2", "testeB", "teste4");
		
		ArrayList<Pessoa_Fisica> TempList = cliente.getList();
		Pessoa_Fisica aux = TempList.get(0);
		assertEquals(aux.getNome(), "teste" );
		assertEquals(aux.getUsuario(), "teste2" );
		assertEquals(aux.getSenha(), "testeB");
		assertEquals(aux.getCpf(), "teste4");
	}


}