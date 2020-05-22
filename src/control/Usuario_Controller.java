package control;

import java.util.ArrayList;

import model.Pessoa_Fisica;
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
	
	public static  ArrayList<Pessoa_Fisica> buscar()
	{
		ArrayList<Pessoa_Fisica> user = new ArrayList<Pessoa_Fisica>();
		
		return user;
	}

}
