package model;

public class Usuario_Model {
	
	private String Nome;
	private String Usuario;
	private String Senha;
	private String cpf;
	
	public Usuario_Model() 
	{
		setNome("");
		setSenha("");
		setUsuario("");
		
	}
	
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getUsuario() {
		return Usuario;
	}
	public void setUsuario(String usuario) {
		Usuario = usuario;
	}
	public String getSenha() {
		return Senha;
	}
	public void setSenha(String senha) {
		Senha = senha;
	}
	
	public String getCpf()
	{
		return cpf;
	}
	public void setCpf(String cpf) 
	{
		this.cpf = cpf;
	}

}
