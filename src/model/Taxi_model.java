package model;

public class Taxi_model extends Usuario {
	
	
	private String cpf;
	private String ModeloCarro;
	private String CorCarro;
	private String Placa;
	
	
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

}
