package teste;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import control.Cliente_File_Controller;
import control.Taxi_File_Controller;
import model.Cliente_Model;
import model.Taxi_Model;
import model.Usuario_Model;

class Taxi_File_ControllerTest {

	@Test
	void testJsonRead() 
	{
		Taxi_File_Controller cfc = new Taxi_File_Controller();
		cfc.jsonRead();
		ArrayList<Taxi_Model> TempList = cfc.getList();
		assertFalse(TempList.isEmpty());
		Taxi_Model joao = TempList.get(0);
		assertEquals(joao.getNome(), "Momo" );
		assertEquals(joao.getUsuario(), "biscoito" );
		assertEquals(joao.getSenha(), "biscoito123");
		assertEquals(joao.getCpf(), "12345");
	}
	
	@Test
	void testJsonWrite() 
	{
		Taxi_File_Controller cfc = new Taxi_File_Controller();
		Taxi_Model teste = new Taxi_Model();
		teste.setCpf("12345");
		teste.setNome("José");
		teste.setSenha("bolo123");
		teste.setUsuario("bolo");
		cfc.getList().add(teste);
		cfc.jsonWrite();// erro que dá aqui é por conta do writer não especificar campos, pois achei melhor fazê-lo de forma genérica
		cfc.jsonRead();
		ArrayList<Taxi_Model> TempList = cfc.getList();
		assertFalse(TempList.isEmpty());
		Taxi_Model aux = TempList.get(0);
		assertEquals(aux.getNome(), "Momo" );
		assertEquals(aux.getUsuario(), "bolo" );
		assertEquals(aux.getSenha(), "bolo123");
		assertEquals(aux.getCpf(), "12345");
		
	}

}
