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

import model.Corrida_Model;
import model.Pessoa_Fisica;
import model.Taxi_Model;

public class Copia_Taxi_Controller extends Copia_Usuario_Controller
{
	private ArrayList<Taxi_Model> L = new ArrayList<Taxi_Model>();
	
	
	
	public void jsonRead() 
	{
			
		JSONObject jsonObject;
	    JSONArray jsonArray;
	    //Cria o parse de tratamento
	    JSONParser parser = new JSONParser();
	    //Variaveis que irao armazenar os dados do arquivo JSON
	     try 
	     {
	        FileReader file = new FileReader("taxis.json");
	        if(file.read() ==-1) 
	        {
	        	System.out.println("Arquivo vazio\n");
	        		//extracted();
	        }
	        else
	        {
	        	//o java n�o aceita resetar a filereader pra posi��o inicial, ent�o cria outro filereader
	        	file = new FileReader("taxis.json");
	        }
	        	
	        jsonArray = (JSONArray) parser.parse(file);
	        Iterator<JSONObject> externalIterator = jsonArray.iterator();
	  
	        while(externalIterator.hasNext()) 
	        {
	            Taxi_Model aux = new Taxi_Model();
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
	
	public void jsonWrite() 
	{
		//Cria um Objeto JSON
        JSONArray arrJson = new JSONArray(); 
        FileWriter writeFile = null;
        Iterator<Taxi_Model> clienteIterator = L.iterator();

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
            writeFile = new FileWriter("taxis.json");
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
		 
				 
		Taxi_Model taxi = new Taxi_Model();
		
		taxi.setNome(nome);
	    taxi.setCpf(cpf);
	    taxi.setUsuario(usuario);
	    taxi.setSenha(senha);
	    L.add(taxi);
	        
	    jsonWrite();
           	
	}
	
	public void remover(String nome, String usuario, String cpf)
	{
		try 
		{
			ArrayList<Taxi_Model> lista = busca(nome, usuario, cpf);
				
			// Prepara a união
			ArrayList<Taxi_Model> union = new ArrayList<Taxi_Model>(lista);
			union.addAll(L);
			// Prepara a intersecção
			ArrayList<Taxi_Model> intersection = new ArrayList<Taxi_Model>(lista);
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
	
	public ArrayList<Taxi_Model> busca(String nome, String usuario, String cpf) 
	{
		//Pessoa_Fisica m = new Pessoa_Fisica();
		ArrayList<Taxi_Model> lista = new ArrayList<Taxi_Model>();
		boolean achou = false;
		try 
		{
			for(Taxi_Model aux:L)
			{
				if(aux.getNome().equals(nome) || aux.getCpf().equals(cpf) || aux.getUsuario().equals(usuario))
				{
					lista.add(aux);
					achou = true;
				
				}
			
			}
		}
		catch(NullPointerException e) 
		{
			String g="Não há ninguém com esses dados no banco!";
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
	
	public void adcionarCorrida(Taxi_Model taxi, Corrida_Model corrida)
	{
		
		taxi.getCorridas().add(corrida);
	}
	
	public ArrayList<Taxi_Model> getList()
	{
		return L;
	}
}
