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

import model.Adm_Model;

public class Adm_Controller extends Usuario_Controller {
	
	private static ArrayList<Adm_Model> L = new ArrayList<Adm_Model>();
	
	public static void jsonRead() 
	{
			
		JSONObject jsonObject;
	    JSONArray jsonArray;
	    //Cria o parse de tratamento
	    JSONParser parser = new JSONParser();
	    //Variaveis que irao armazenar os dados do arquivo JSON
	     try 
	     {
	        FileReader file = new FileReader("adm.json");
	        if(file.read() ==-1) 
	        {
	        	System.out.println("Arquivo vazio\n");
	        		//extracted();
	        }
	        else
	        {
	        	//o java n�o aceita resetar a filereader pra posi��o inicial, ent�o cria outro filereader
	        	file = new FileReader("adm.json");
	        }
	        	
	        jsonArray = (JSONArray) parser.parse(file);
	        Iterator<JSONObject> externalIterator = jsonArray.iterator();
	  
	        while(externalIterator.hasNext()) 
	        {
	            Adm_Model aux = new Adm_Model();
	            jsonObject = externalIterator.next();
	            aux.setNome((String) jsonObject.get("Nome"));
	            aux.setUsuario((String) jsonObject.get("Usuario"));
	            aux.setSenha((String) jsonObject.get("Senha"));
	            
	                
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
        Iterator<Adm_Model> admIterator = L.iterator();

        while(admIterator.hasNext()) 
        {
        	JSONObject jsonObject = new JSONObject();
        	Adm_Model aux = new Adm_Model();
        	aux = admIterator.next();
        	
        	//Armazena dados em um Objeto JSON
        	jsonObject.put("Usuario", aux.getUsuario());
            jsonObject.put("Nome", aux.getNome());
            jsonObject.put("Senha", aux.getSenha());
            arrJson.add(jsonObject);
        }
         
        try
        {
            writeFile = new FileWriter("adm.json");
            //Escreve no arquivo conteudo do Objeto JSON
            writeFile.write(arrJson.toJSONString());
            writeFile.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
	}
	
	public static void adicionar(String nome, String usuario, String senha, String cpf)
	{				 
		Adm_Model adm = new Adm_Model();
		
		adm.setNome(nome);
	    adm.setUsuario(usuario);
	    adm.setSenha(senha);
	    L.add(adm);
	        
	    jsonWrite();
           	
	}
	
	public static void remover(String nome, String usuario)
	{
		try 
		{
			ArrayList<Adm_Model> lista = busca(nome, usuario);
				
			// Prepara a união
			ArrayList<Adm_Model> union = new ArrayList<Adm_Model>(lista);
			union.addAll(L);
			// Prepara a intersecção
			ArrayList<Adm_Model> intersection = new ArrayList<Adm_Model>(lista);
			intersection.retainAll(L);
			// Subtrai a intersecção da união
			union.removeAll(intersection);
			// Atualiza a lista
			L = union;
		
			jsonWrite();		
		}
		
		catch(NullPointerException e) 
		{
			String g="Não há ninguém com esses dados no banco!";
		}
	}
	
	public static ArrayList<Adm_Model> busca(String nome, String usuario) 
	{
		//Adm_Model m = new Adm_Model();
		ArrayList<Adm_Model> lista = new ArrayList<Adm_Model>();
		//boolean achou = false;
		try 
		{
			for(Adm_Model aux:L)
			{
				if(aux.getNome().equals(nome)  || aux.getUsuario().equals(usuario))
				{
					lista.add(aux);
					//achou = true;
				
				}
			
			}
		}
		catch(NullPointerException e) 
		{
			System.out.println("Não há ninguém com esses dados no banco!");
		}
		 return lista;
		//else return null;
		
	}
	
	public static void editar(String nome, String usuario, String senha) 
	{
		
		L.get(0).setNome(nome);
		L.get(0).setUsuario(usuario);
		L.get(0).setSenha(senha);
		jsonWrite();
	}
	
	public static ArrayList<Adm_Model> getList()
	{
		return L;
	}

}
