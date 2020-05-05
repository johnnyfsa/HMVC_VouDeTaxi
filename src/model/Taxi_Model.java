package model;

import java.util.ArrayList;

public class Taxi_Model extends Usuario_Model {
	
	
	private String cpf;
	private String ModeloCarro;
	private String CorCarro;
	private String Placa;
	private ArrayList<Corrida_Model> Corridas;
	
	public Taxi_Model() 
	{
		cpf = "";
		ModeloCarro= "";
		CorCarro = "";
		Placa = "";
		Corridas = new ArrayList<Corrida_Model>();
	}
	
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getModeloCarro() {
		return ModeloCarro;
	}
	public void setModeloCarro(String modeloCarro) {
		ModeloCarro = modeloCarro;
	}
	public String getCorCarro() {
		return CorCarro;
	}
	public void setCorCarro(String corCarro) {
		CorCarro = corCarro;
	}
	public String getPlaca() {
		return Placa;
	}
	public void setPlaca(String placa) {
		Placa = placa;
	}
	public ArrayList<Corrida_Model> getCorridas() {
		return Corridas;
	}
	public void setCorridas(ArrayList<Corrida_Model> corridas) {
		Corridas = corridas;
	}

}
