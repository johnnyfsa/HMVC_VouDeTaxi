package teste;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import model.Adm_Model;
import model.Taxi_Model;

class Adm_ModelTest {

	@Test
	void testGetRelatorio_Geral() {
		Adm_Model admTest = new Adm_Model();
		assertTrue(admTest.getRelatorio_Geral().isEmpty());
	}

	@Test
	void testSetRelatorio_Geral() {
		ArrayList<Taxi_Model> taxis = new ArrayList<Taxi_Model>();
		taxis.add(new Taxi_Model());
		Adm_Model admTest = new Adm_Model();
		admTest.setRelatorio_Geral(taxis);
		assertFalse(admTest.getRelatorio_Geral().isEmpty());
	}

}
