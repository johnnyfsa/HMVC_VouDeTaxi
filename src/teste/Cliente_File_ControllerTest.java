package teste;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import control.Cliente_File_Controller;
import model.Cliente_Model;
import model.Usuario_Model;

class Cliente_File_ControllerTest {

	@Test
	void testJsonRead() {
		Cliente_File_Controller cfc = new Cliente_File_Controller();
		cfc.jsonRead();
		ArrayList<Cliente_Model> TempList = cfc.getList();
		assertFalse(TempList.isEmpty());
		Cliente_Model joao = TempList.get(0);
		assertEquals(joao.getNome(), "Joao" );
		assertEquals(joao.getUsuario(), "biscoito" );
		assertEquals(joao.getSenha(), "biscoito123");
		assertEquals(joao.getCpf(), "teste1");
	}

	@Test
	void testJsonWrite() {
		Cliente_File_Controller cfc = new Cliente_File_Controller();
		Cliente_Model teste = new Cliente_Model();
		teste.setCpf("teste3");
		teste.setNome("José");
		teste.setSenha("bolo123");
		teste.setUsuario("bolo");
		cfc.getList().add(teste);
		cfc.jsonWrite();
		cfc.jsonRead();
		ArrayList<Cliente_Model> TempList = cfc.getList();
		assertFalse(TempList.isEmpty());
		Cliente_Model aux = TempList.get(0);
		assertEquals(aux.getNome(), "José" );
		assertEquals(aux.getUsuario(), "bolo" );
		assertEquals(aux.getSenha(), "bolo123");
		assertEquals(aux.getCpf(), "teste3");
	}

}
