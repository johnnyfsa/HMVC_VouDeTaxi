package model;

import java.util.ArrayList;

public class Taxi_Model extends Pessoa_Fisica {
	
	
	private String ModeloCarro;
	private String CorCarro;
	private String Placa;
	private ArrayList<Corrida_Model> Corridas;
	private float pontuacao;
	private int[] localizacao;
	private boolean visible;
	
	public Taxi_Model() 
	{
		ModeloCarro= "";
		CorCarro = "";
		Placa = "";
		Corridas = new ArrayList<Corrida_Model>();
		pontuacao =0;
		localizacao = new int[2];
		visible = true;
		
	}
	public Taxi_Model(String nome, String usuario, String senha) 
	{
		setNome(nome);
		setUsuario(usuario);
		setSenha(senha);
		ModeloCarro= "";
		CorCarro = "";
		Placa = "";
		Corridas = new ArrayList<Corrida_Model>();
		pontuacao =0;
		localizacao = new int[2];
		visible = true;
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



	public float getPontuacao() {
		return pontuacao;
	}



	public void setPontuacao(float pontuacao) {
		this.pontuacao = pontuacao;
	}



	public int[] getLocalizacao() {
		return localizacao;
	}



	public void setLocalizacao(int[] localizacao) {
		this.localizacao = localizacao;
	}



	public boolean isVisible() {
		return visible;
	}



	public void setVisible(boolean visible) {
		this.visible = visible;
	}

}
