package teste;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.jupiter.api.Test;

import control.ADM_File_Controller;
import control.Taxi_File_Controller;
import model.Taxi_Model;
import model.Usuario_Model;

class ADM_File_ControllerTest {

	@Test
	void testJsonRead() 
	{
		ADM_File_Controller cfc = new ADM_File_Controller();
		cfc.jsonRead();
		ArrayList<Usuario_Model> TempList = cfc.getList();
		assertFalse(TempList.isEmpty());
		Usuario_Model joao = TempList.get(0);  
		assertEquals(joao.getNome(), "ADM" );   
		assertEquals(joao.getUsuario(), "ADM" );
		assertEquals(joao.getSenha(), "user");
		
	}
	
	@Test
	void testJsonWrite() 
	{
		ADM_File_Controller cfc = new ADM_File_Controller();
		Usuario_Model teste = new Usuario_Model();
		teste.setCpf("12345");
		teste.setNome("José");
		teste.setSenha("bolo123");
		teste.setUsuario("bolo");
		//cfc.getList().add(teste); //Usuario model não tem get list
		cfc.jsonWrite();// erro que dá aqui é por conta do writer não especificar campos, pois achei melhor fazê-lo de forma genérica
		cfc.jsonRead();
	}
	
	

}
