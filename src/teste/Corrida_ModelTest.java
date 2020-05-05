package teste;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.Test;

import model.Corrida_Model;

class Corrida_ModelTest {

	@Test
	void testCorrida_Model() {
		Corrida_Model CorridaTest = new Corrida_Model();
		assertTrue(CorridaTest!=null);
	}

	@Test
	void testGetPartida() {
		Corrida_Model CorridaTest = new Corrida_Model();
		int[] pTest = CorridaTest.getPartida();
		assertTrue(pTest.length>0);
	}

	@Test
	void testSetPartida() {
		int latitude = 10;
		int longitude = 11;
		int[] coordenadas = new int[2];
		coordenadas[0] = latitude;
		coordenadas[1] = longitude;
		Corrida_Model CorridaTest = new Corrida_Model();
		CorridaTest.setPartida(coordenadas);
		assertEquals(CorridaTest.getPartida()[0], 10);
		assertEquals(CorridaTest.getPartida()[1], 11);
	}

	@Test
	void testGetChegada() {
		Corrida_Model CorridaTest = new Corrida_Model();
		int[] pTest = CorridaTest.getChegada();
		assertTrue(pTest.length>0);
	}

	@Test
	void testSetChegada() {
		int latitude = 10;
		int longitude = 11;
		int[] coordenadas = new int[2];
		coordenadas[0] = latitude;
		coordenadas[1] = longitude;
		Corrida_Model CorridaTest = new Corrida_Model();
		CorridaTest.setChegada(coordenadas);
		assertEquals(CorridaTest.getChegada()[0], 10);
		assertEquals(CorridaTest.getChegada()[1], 11);
	}

	@Test
	void testGetDistancia() {
		Corrida_Model CorridaTest = new Corrida_Model();
		assertEquals(CorridaTest.getDistancia(), 0.0);
	}

	@Test
	void testSetDistancia() {
		Corrida_Model CorridaTest = new Corrida_Model();
		CorridaTest.setDistancia(12.78f);
		assertEquals(CorridaTest.getDistancia(), 12.78f);
	}

	@Test
	void testGetHorario() {
		Corrida_Model CorridaTest = new Corrida_Model();
		LocalDateTime now = LocalDateTime.now();
		//System.out.println(now);
		assertEquals(CorridaTest.getHorario(), now);
	}

	@Test
	void testSetHorario() {
		String str = "2016-03-04 11:30"; 
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		LocalDateTime dateTime = LocalDateTime.parse(str, formatter);
		Corrida_Model CorridaTest = new Corrida_Model();
		CorridaTest.setHorario(dateTime);
		assertEquals(CorridaTest.getHorario(), dateTime);

		
	}

	@Test
	void testGetCliente() {
		Corrida_Model CorridaTest = new Corrida_Model();
		assertTrue(CorridaTest.getCliente().isEmpty());
	}

	@Test
	void testSetCliente() {
		Corrida_Model CorridaTest = new Corrida_Model();
		CorridaTest.setCliente("Macaco");
		assertEquals(CorridaTest.getCliente(), "Macaco");
	}

	@Test
	void testGetTaxi() {
		Corrida_Model CorridaTest = new Corrida_Model();
		assertTrue(CorridaTest.getTaxi().isEmpty());
	}

	@Test
	void testSetTaxi() {
		Corrida_Model CorridaTest = new Corrida_Model();
		CorridaTest.setTaxi("Macaco");
		assertEquals(CorridaTest.getTaxi(), "Macaco");
	}

	@Test
	void testGetStatus() {
		Corrida_Model CorridaTest = new Corrida_Model();
		assertTrue(CorridaTest.getStatus());
	}

	@Test
	void testSetStatus() {
		Corrida_Model CorridaTest = new Corrida_Model();
		CorridaTest.setStatus(false);
		assertFalse(CorridaTest.getStatus());
	}

}
