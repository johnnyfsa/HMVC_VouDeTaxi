package control;

import java.util.ArrayList;

import model.Adm_Model;
import model.Pessoa_Fisica;
import model.Taxi_Model;
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
	
	public static int autenticarLogin(String usuario, String senha) 
	{
		//legenda: 0:erro, 1:adm, 2:taxi, 3:cliente
		
		
		ArrayList<Pessoa_Fisica> clientes = new ArrayList<Pessoa_Fisica>();
		clientes = Cliente_Controller.busca("", usuario, "");
		if(clientes.isEmpty()) 
		{
			//não tem ninguém com esse usuário dentro dos clientes, procura em taxi
			ArrayList<Taxi_Model> Taxis = new ArrayList<Taxi_Model>();
			Taxis = Taxi_Controller.busca("", usuario, "");
			if(Taxis.isEmpty()) 
			{
				//não está em taxis, procura entre os adms
				ArrayList<Adm_Model> adms = new ArrayList<Adm_Model>();
				adms = Adm_Controller.busca("", usuario);
				if(adms.isEmpty()) 
				{
					//é por que ele não achou nada de nada
					return 0;
				}
				else 
				{
					Adm_Model aux = new Adm_Model();
					aux = adms.get(0);
					if(aux.getSenha().equals(senha)) 
					{
						usuario_atual = adms.get(0);
						return 1;
					}
					else 
					{
						return 0;
					}
				}
			}
			else 
			{
				Taxi_Model aux = new Taxi_Model();
				aux = Taxis.get(0);
				if(aux.getSenha().equals(senha)) 
				{
					usuario_atual = Taxis.get(0);
					return 2;
				}
				else
				{
					return 0;
				}
			}
		}else
		{
			Pessoa_Fisica aux = new Pessoa_Fisica();
			aux = clientes.get(0);
			if(aux.getSenha().equals(senha)) 
			{
				usuario_atual = clientes.get(0);
				return 3;
			}
			else
			{
				return 0;
			}
		}
	}
}
