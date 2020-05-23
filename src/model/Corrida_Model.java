package model;

import java.time.Duration;
import java.time.LocalDateTime;

public class Corrida_Model {
	
	private double[] partida;
	private double[] chegada;
	private LocalDateTime horario;
	private double distancia;
	private Pessoa_Fisica cliente;
	private Taxi_Model taxi;
	private boolean status;
	private int identificador;
	private float avaliacao;
	private long tempo; // o tempo t� sendo gerado em minutos nesse caso, se a corrida durar horas, a gente vai precisar fazer uma convers�o
	
	public Corrida_Model() 
	{
		partida = new double[2];
		chegada = new double[2];
		horario = LocalDateTime.now();
		distancia = 0;
		cliente = new Pessoa_Fisica();
		taxi = new Taxi_Model();
		status = true;
		identificador= 0;
		avaliacao = 0;
		tempo =0;
	}
	
	public double[] getPartida() {
		return partida;
	}
	public void setPartida(double[] partida) {
		this.partida = partida;
	}
	public double[] getChegada() {
		return chegada;
	}
	public void setChegada(double[] chegada) {
		this.chegada = chegada;
	}
	public double getDistancia() {
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
	public Pessoa_Fisica getCliente() {
		return cliente;
	}
	public void setCliente(Pessoa_Fisica cliente) {
		this.cliente = cliente;
	}
	public Taxi_Model getTaxi() {
		return taxi;
	}
	public void setTaxi(Taxi_Model taxi) {
		this.taxi = taxi;
	}
	public boolean getStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}

	public int getIdentificador() {
		return identificador;
	}

	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}

	public float getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(float avaliacao) {
		this.avaliacao = avaliacao;
	}
	
	public long getTempo() 
	{
		return tempo;
	}
	
	public void setTempo(long tempo) 
	{
		this.tempo = tempo;
	}
	
	public void calculaTempo(LocalDateTime agora) 
	{
		long diferenca = Duration.between(agora, horario).toMinutes();
		tempo = diferenca;
	}
	
	public void calculaDistancia() 
	{
		double delta1, delta2;
		delta1 = (partida[0]-partida[1])*(partida[0]-partida[1]);
		delta2 = (chegada[0]-chegada[1])*(chegada[0]-chegada[1]);
		distancia = Math.sqrt(delta1+delta2);
		
	}
}
