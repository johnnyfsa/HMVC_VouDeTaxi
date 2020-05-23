package teste;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.Test;

import model.Corrida_Model;
import model.Pessoa_Fisica;
import model.Taxi_Model;

class Corrida_ModelTest {

	@Test
	void testGetPartida() {
		Corrida_Model raceTest = new Corrida_Model();
		assertEquals(raceTest.getPartida()[0],0);
		assertEquals(raceTest.getPartida()[1],0);
	}

	@Test
	void testSetPartida() {
		Corrida_Model raceTest = new Corrida_Model();
		int latitude = (int) (Math.random()*100);
		int longetude = (int) (Math.random()*100);
		double[] coordenadas = {latitude, longetude};
		raceTest.setPartida(coordenadas);
		assertEquals(raceTest.getPartida()[0], latitude);
		assertEquals(raceTest.getPartida()[1], longetude);
	}

	@Test
	void testGetChegada() {
		Corrida_Model raceTest = new Corrida_Model();
		assertEquals(raceTest.getChegada()[0],0);
		assertEquals(raceTest.getChegada()[1],0);
	}

	@Test
	void testSetChegada() {
		Corrida_Model raceTest = new Corrida_Model();
		int latitude = (int) (Math.random()*100);
		int longetude = (int) (Math.random()*100);
		double[] coordenadas = {latitude, longetude};
		raceTest.setChegada(coordenadas);
		assertEquals(raceTest.getChegada()[0], latitude);
		assertEquals(raceTest.getChegada()[1], longetude);
	}

	@Test
	void testGetDistancia() {
		Corrida_Model raceTest = new Corrida_Model();
		assertEquals(raceTest.getDistancia(), 0);
	}

	@Test
	void testSetDistancia() {
		Corrida_Model raceTest = new Corrida_Model();
		float distance = 10.00f;
		raceTest.setDistancia(distance);
		assertEquals(raceTest.getDistancia(), distance);
	}

	@Test
	void testGetHorario() {
		Corrida_Model raceTest = new Corrida_Model();
		LocalDateTime agora = LocalDateTime.now();
		assertEquals(raceTest.getHorario(), agora);
	}

	@Test
	void testSetHorario() {
		Corrida_Model raceTest = new Corrida_Model();
		String str = "2016-03-04 11:30"; 
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"); 
		LocalDateTime dateTime = LocalDateTime.parse(str, formatter);
		raceTest.setHorario(dateTime);
		assertEquals(dateTime, raceTest.getHorario());
	}

	@Test
	void testGetCliente() {
		Corrida_Model raceTest = new Corrida_Model();
		assertTrue(raceTest.getCliente() instanceof Pessoa_Fisica);
	}

	@Test
	void testSetCliente() {
		Pessoa_Fisica cliente = new Pessoa_Fisica("teste", "teste@teste.com", "teste123", "123.123.123-89");
		Corrida_Model raceTest = new Corrida_Model();
		raceTest.setCliente(cliente);
		assertEquals(raceTest.getCliente(), cliente);
	}

	@Test
	void testGetTaxi() {
		Corrida_Model raceTest = new Corrida_Model();
		assertTrue(raceTest.getTaxi() instanceof Taxi_Model);
	}

	@Test
	void testSetTaxi() {
		Taxi_Model tx = new Taxi_Model("teste", "teste@teste.com", "teste123");
		Corrida_Model raceTest = new Corrida_Model();
		raceTest.setTaxi(tx);
		assertEquals(raceTest.getTaxi().getNome(), tx.getNome());
		assertEquals(raceTest.getTaxi().getUsuario(), tx.getUsuario());
		assertEquals(raceTest.getTaxi().getSenha(), tx.getSenha());
	
	}

	@Test
	void testGetStatus() {
		Corrida_Model raceTest = new Corrida_Model();
		assertTrue(raceTest.getStatus());
	}

	@Test
	void testSetStatus() {
		Corrida_Model raceTest = new Corrida_Model();
		raceTest.setStatus(false);
		assertFalse(raceTest.getStatus());
	}

	@Test
	void testGetIdentificador() {
		Corrida_Model raceTest = new Corrida_Model();
		assertEquals(raceTest.getIdentificador(), 0);
	}

	@Test
	void testSetIdentificador() {
		Corrida_Model raceTest = new Corrida_Model();
		raceTest.setIdentificador(1);
		assertEquals(raceTest.getIdentificador(), 1);
	}

	@Test
	void testGetAvaliacao() {
		Corrida_Model raceTest = new Corrida_Model();
		assertEquals(raceTest.getAvaliacao(), 0);
	}

	@Test
	void testSetAvaliacao() {
		Corrida_Model raceTest = new Corrida_Model();
		raceTest.setAvaliacao(1.25f);
		assertEquals(raceTest.getAvaliacao(), 1.25f);
	}

	@Test
	void testGetTempo() {
		Corrida_Model raceTest = new Corrida_Model();
		assertEquals(raceTest.getTempo(), 0);
	}

	@Test
	void testSetTempo() {
		Corrida_Model raceTest = new Corrida_Model();
		raceTest.setTempo(10);
		assertEquals(raceTest.getTempo(), 10);
	}

	@Test
	void testCalculaTempo() {
		Corrida_Model raceTest = new Corrida_Model();
		LocalDateTime dateTime = LocalDateTime.now().minusMinutes(120);
		raceTest.calculaTempo(dateTime);
		assertEquals(raceTest.getTempo(), 120);
		
		
	}

	@Test
	void testCalculaDistancia() {
		Corrida_Model raceTest = new Corrida_Model();
		int latitude1 = (int) (Math.random()*100);
		int longetude1 = (int) (Math.random()*100);
		double[] coordenadas1 = {latitude1, longetude1};
		int latitude2 = (int) (Math.random()*100);
		int longetude2 = (int) (Math.random()*100);
		double[] coordenadas2 = {latitude2, longetude2};
		raceTest.setPartida(coordenadas1);
		raceTest.setChegada(coordenadas2);
		raceTest.calculaDistancia();
		assertTrue(raceTest.getDistancia()>0);
	}

}
