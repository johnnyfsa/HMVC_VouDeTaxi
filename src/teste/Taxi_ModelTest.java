package teste;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import model.Corrida_Model;
import model.Taxi_Model;

class Taxi_ModelTest {

	@Test
	void testGetModeloCarro() {
		Taxi_Model TaxiTest = new Taxi_Model();
		assertTrue(TaxiTest.getModeloCarro().isEmpty());
	}

	@Test
	void testSetModeloCarro() {
		Taxi_Model TaxiTest = new Taxi_Model();
		TaxiTest.setModeloCarro("mazda");
		assertEquals(TaxiTest.getModeloCarro(), "mazda");
	}

	@Test
	void testGetCorCarro() {
		Taxi_Model TaxiTest = new Taxi_Model();
		assertTrue(TaxiTest.getCorCarro().isEmpty());
	}

	@Test
	void testSetCorCarro() {
		Taxi_Model TaxiTest = new Taxi_Model();
		TaxiTest.setCorCarro("branco");
		assertEquals(TaxiTest.getCorCarro(), "branco");
	}

	@Test
	void testGetPlaca() {
		Taxi_Model TaxiTest = new Taxi_Model();
		assertTrue(TaxiTest.getPlaca().isEmpty());
	}

	@Test
	void testSetPlaca() {
		Taxi_Model TaxiTest = new Taxi_Model();
		String placa = "GHJ1245";
		TaxiTest.setPlaca(placa);
		assertEquals(TaxiTest.getPlaca(), placa);
	}

	@Test
	void testGetCorridas() {
		Taxi_Model TaxiTest = new Taxi_Model();
		assertTrue(TaxiTest.getCorridas().isEmpty());
	}

	@Test
	void testSetCorridas() {
		Taxi_Model TaxiTest = new Taxi_Model();
		ArrayList<Corrida_Model> corridas= new ArrayList<Corrida_Model>();
		corridas.add(new Corrida_Model());
		TaxiTest.setCorridas(corridas);
		assertFalse(TaxiTest.getCorridas().isEmpty());
	}

	@Test
	void testGetPontuacao() {
		Taxi_Model TaxiTest = new Taxi_Model();
		assertEquals(TaxiTest.getPontuacao(),0);
	}

	@Test
	void testSetPontuacao() {
		Taxi_Model TaxiTest = new Taxi_Model();
		TaxiTest.setPontuacao(10);
		assertEquals(TaxiTest.getPontuacao(),10);
	}

	@Test
	void testGetLocalizacao() {
		Taxi_Model TaxiTest = new Taxi_Model();
		assertEquals(TaxiTest.getLocalizacao()[0],0);
		assertEquals(TaxiTest.getLocalizacao()[1],0);
	}

	@Test
	void testSetLocalizacao() {
		Taxi_Model TaxiTest = new Taxi_Model();
		int latitude = (int) (Math.random()*100);
		int longetude =(int) (Math.random()*100);
		int[] coordenadas = {latitude, longetude};
		TaxiTest.setLocalizacao(coordenadas);
		assertEquals(TaxiTest.getLocalizacao()[0],latitude);
		assertEquals(TaxiTest.getLocalizacao()[1],longetude);
	}

	@Test
	void testIsVisible() {
		Taxi_Model TaxiTest = new Taxi_Model();
		assertTrue(TaxiTest.isVisible());
	}

	@Test
	void testSetVisible() {
		Taxi_Model TaxiTest = new Taxi_Model();
		TaxiTest.setVisible(false);
		assertFalse(TaxiTest.isVisible());
	}

}
