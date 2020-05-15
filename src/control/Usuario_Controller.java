package control;

import java.util.ArrayList;

import model.Cliente_Model;
import model.Usuario_Model;

public abstract class Usuario_Controller 
{
	private ArrayList<Usuario_Model> L;
	
	//File_Controller
	
	public static void jsonRead(){} 
	
	public static void jsonWrite(){} 
	
	public static void adicionar(){}
	
	public static void remover(){}
	
	public static void editar() {}
	
	public static  Usuario_Model buscar()
	{
		Usuario_Model user = new Usuario_Model();
		
		return user;
	}

}
