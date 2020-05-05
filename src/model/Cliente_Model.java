package model;

public class Cliente_Model extends Usuario_Model {
	
	private String cpf;
	
	public Cliente_Model() 
	{
		cpf = "";
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

}
