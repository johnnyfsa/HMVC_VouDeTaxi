package model;

import java.time.LocalDateTime;

public class Corrida_Model {
	
	private int[] partida;
	private int[] chegada;
	private LocalDateTime horario;
	private float distancia;
	private String cliente;
	private String taxi;
	private boolean status;
	
	public Corrida_Model() 
	{
		partida = new int[2];
		chegada = new int[2];
		horario = LocalDateTime.now();
		distancia = 0;
		cliente = "";
		taxi = "";
		status = true;
	}
	
	public int[] getPartida() {
		return partida;
	}
	public void setPartida(int[] partida) {
		this.partida = partida;
	}
	public int[] getChegada() {
		return chegada;
	}
	public void setChegada(int[] chegada) {
		this.chegada = chegada;
	}
	public float getDistancia() {
		return distancia;
	}
	public void setDistancia(float distancia) {
		this.distancia = distancia;
	}
	public LocalDateTime getHorario() {
		return horario;
	}
	public void setHorario(LocalDateTime horario) {
		this.horario = horario;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public String getTaxi() {
		return taxi;
	}
	public void setTaxi(String taxi) {
		this.taxi = taxi;
	}
	public boolean getStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}

}
