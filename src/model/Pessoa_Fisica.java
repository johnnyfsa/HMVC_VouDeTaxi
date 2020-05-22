package model;

public class Pessoa_Fisica extends Usuario_Model {
	
	private String cpf;
	
	public Pessoa_Fisica() 
	{
		cpf = "";
	}
	
	public Pessoa_Fisica(String nome, String usuario, String senha, String cpf) 
	{
		
		setNome("");
		setUsuario("");
		setSenha("");
		setCpf("");
	}
	


	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

}
