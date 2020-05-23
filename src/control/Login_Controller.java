package control;

import model.Usuario_Model;

public class Login_Controller 
{
	private static Usuario_Model usuario_atual;
	
	public static void setUsuario(Usuario_Model usuario) 
	{
		usuario_atual = usuario;
	}
	
	public static Usuario_Model getUsuario() 
	{
		return usuario_atual;
	}
}
