package teste;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Corrida_Model;
import model.Taxi_Model;

class Taxi_ModelTest {

	@Test
	void testGetCpf() {
		Taxi_Model TaxiTest = new Taxi_Model();
		assertTrue(TaxiTest.getCpf().isEmpty());
	}

	@Test
	void testSetCpf() {
		Taxi_Model TaxiTest = new Taxi_Model();
		TaxiTest.setCpf("teste");
		assertEquals(TaxiTest.getCpf(), "teste");
	}

	@Test
	void testGetModeloCarro() {
		Taxi_Model TaxiTest = new Taxi_Model();
		assertTrue(TaxiTest.getModeloCarro().isEmpty());
	}

	@Test
	void testSetModeloCarro() {
		Taxi_Model TaxiTest = new Taxi_Model();
		TaxiTest.setModeloCarro("teste");
		assertEquals(TaxiTest.getModeloCarro(), "teste");
	}

	@Test
	void testGetCorCarro() {
		Taxi_Model TaxiTest = new Taxi_Model();
		assertTrue(TaxiTest.getCorCarro().isEmpty());
	}

	@Test
	void testSetCorCarro() {
		Taxi_Model TaxiTest = new Taxi_Model();
		TaxiTest.setCorCarro("teste");
		assertEquals(TaxiTest.getCorCarro(), "teste");
	}

	@Test
	void testGetPlaca() {
		Taxi_Model TaxiTest = new Taxi_Model();
		assertTrue(TaxiTest.getPlaca().isEmpty());
	}

	@Test
	void testSetPlaca() {
		Taxi_Model TaxiTest = new Taxi_Model();
		TaxiTest.setPlaca("teste");
		assertEquals(TaxiTest.getPlaca(), "teste");
	}

	@Test
	void testGetCorridas() {
		Taxi_Model TaxiTest = new Taxi_Model();
		assertTrue(TaxiTest.getCorridas().isEmpty());
	}

	@Test
	void testSetCorridas() {
		Corrida_Model CorridaTeste = new Corrida_Model();
		Taxi_Model TaxiTest = new Taxi_Model();
		TaxiTest.getCorridas().add(CorridaTeste);
		assertFalse(TaxiTest.getCorridas().isEmpty());
	}

}
