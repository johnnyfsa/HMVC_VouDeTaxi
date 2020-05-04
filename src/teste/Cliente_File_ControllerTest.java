package teste;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import control.Cliente_File_Controller;
import model.Usuario;

class Cliente_File_ControllerTest {

	@Test
	void testJsonRead() {
		Cliente_File_Controller cfc = new Cliente_File_Controller();
		cfc.jsonRead();
		ArrayList<Usuario> TempList = cfc.getList();
		assertFalse(TempList.isEmpty());
		Usuario joao = TempList.get(0);
		assertEquals(joao.getNome(), "Joao" );
	}

	@Test
	void testJsonWrite() {
		fail("Not yet implemented");
	}

}
