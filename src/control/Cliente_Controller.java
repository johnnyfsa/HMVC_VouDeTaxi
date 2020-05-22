package control;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import model.Pessoa_Fisica;
import model.Usuario_Model;

public class Cliente_Controller extends Usuario_Controller
{
private static ArrayList<Pessoa_Fisica> L = new ArrayList<Pessoa_Fisica>();
	
	
	public static void jsonRead() 
	{
			
		JSONObject jsonObject;
	    JSONArray jsonArray;
	    //Cria o parse de tratamento
	    JSONParser parser = new JSONParser();
	    //Variaveis que irao armazenar os dados do arquivo JSON
	     try 
	     {
	        FileReader file = new FileReader("clientes.json");
	        if(file.read() ==-1) 
	        {
	        	System.out.println("Arquivo vazio\n");
	        		//extracted();
	        }
	        else
	        {
	        	//o java n�o aceita resetar a filereader pra posi��o inicial, ent�o cria outro filereader
	        	file = new FileReader("clientes.json");
	        }
	        	
	        jsonArray = (JSONArray) parser.parse(file);
	        Iterator<JSONObject> externalIterator = jsonArray.iterator();
	  
	        while(externalIterator.hasNext()) 
	        {
	            Pessoa_Fisica aux = new Pessoa_Fisica();
	            jsonObject = externalIterator.next();
	            aux.setNome((String) jsonObject.get("Nome"));
	            aux.setUsuario((String) jsonObject.get("Usuario"));
	            aux.setSenha((String) jsonObject.get("Senha"));
	            aux.setCpf((String) jsonObject.get("CPF"));
	                
	            L.add(aux);
	          }
	       } 
	        
	     //Trata as exceptions que podem ser lan�adas no decorrer do processo
	       catch (FileNotFoundException e) 
	     	{
	            e.printStackTrace();
	        } 
	     	catch (IOException e) 
	     	{
	            e.printStackTrace();
	        }
	     	catch (ParseException e) 
	     	{
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        } 
	}
	
	public static void jsonWrite() 
	{
		//Cria um Objeto JSON
        JSONArray arrJson = new JSONArray(); 
        FileWriter writeFile = null;
        Iterator<Pessoa_Fisica> clienteIterator = L.iterator();

        while(clienteIterator.hasNext()) 
        {
        	JSONObject jsonObject = new JSONObject();
        	Pessoa_Fisica aux = new Pessoa_Fisica();
        	aux = clienteIterator.next();
        	
        	//Armazena dados em um Objeto JSON
        	jsonObject.put("Usuario", aux.getUsuario());
            jsonObject.put("Nome", aux.getNome());
            jsonObject.put("Senha", aux.getSenha());
            jsonObject.put("CPF", aux.getCpf());
            arrJson.add(jsonObject);
        }
         
        try
        {
            writeFile = new FileWriter("clientes.json");
            //Escreve no arquivo conteudo do Objeto JSON
            writeFile.write(arrJson.toJSONString());
            writeFile.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
	}
	
	public void adicionar(String nome, String usuario, String senha, String cpf)
	{
		 
		jsonRead(); 		 
		Pessoa_Fisica cliente = new Pessoa_Fisica();
		
		cliente.setNome(nome);
	    cliente.setCpf(cpf);
	    cliente.setUsuario(usuario);
	    cliente.setSenha(senha);
	    L.add(cliente);
	        
	    jsonWrite();
           	
	}
	
	public void remover(String nome, String usuario, String cpf)
	{
		ArrayList<Pessoa_Fisica> lista = busca(nome, usuario, cpf);
				
		// Prepara a união
		ArrayList<Pessoa_Fisica> union = new ArrayList<Pessoa_Fisica>(lista);
		union.addAll(L);
		// Prepara a intersecção
		ArrayList<Pessoa_Fisica> intersection = new ArrayList<Pessoa_Fisica>(lista);
		intersection.retainAll(L);
		// Subtrai a intersecção da união
		union.removeAll(intersection);
		// Atualiza a lista
		L = union;
		
		jsonWrite();		
		
	}
	
	public ArrayList<Pessoa_Fisica> busca(String nome, String usuario, String cpf) 
	{
		//Pessoa_Fisica m = new Pessoa_Fisica();
		ArrayList<Pessoa_Fisica> lista = new ArrayList<Pessoa_Fisica>();
		boolean achou = false;
		for(Pessoa_Fisica aux:L)
		{
			if(aux.getNome().equals(nome) || aux.getCpf().equals(cpf) || aux.getUsuario().equals(usuario))
			{
				lista.add(aux);
				achou = true;
				
			}
			
		}
		
		if(achou==true) return lista;
		else return null;
		
	}
	
	public void editar(Pessoa_Fisica cliente,String nome, String usuario, String senha, String cpf) 
	{
		cliente.setNome(nome);
		cliente.setUsuario(usuario);
		cliente.setSenha(senha);
		cliente.setCpf(cpf);
	}
	
	public ArrayList<Pessoa_Fisica> getList()
	{
		return L;
	}

}
