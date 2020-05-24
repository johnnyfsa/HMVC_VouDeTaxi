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

public class Taxi_Controller extends Usuario_Controller
{
private static ArrayList<Taxi_Model> L = new ArrayList<Taxi_Model>();
	
	
	
	public static void jsonRead() 
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
	        JSONArray localizacao;
	        Iterator<JSONObject> externalIterator = jsonArray.iterator();
	  
	        while(externalIterator.hasNext()) 
	        {
	            Taxi_Model aux = new Taxi_Model();
	            jsonObject = externalIterator.next();
	            aux.setNome((String) jsonObject.get("Nome"));
	            aux.setUsuario((String) jsonObject.get("Usuario"));
	            aux.setSenha((String) jsonObject.get("Senha"));
	            aux.setCpf((String) jsonObject.get("CPF"));
	            aux.setCorCarro((String) jsonObject.get("Cor do Carro"));
	            aux.setModeloCarro((String) jsonObject.get("Modelo do Carro"));
	            aux.setPlaca((String) jsonObject.get("Placa do Carro"));
	            aux.setPontuacao((Double) jsonObject.get("Pontuacao"));
	            localizacao = (JSONArray) jsonObject.get("Localizacao");
	            double[] darray = new double[2];
	            for(int i =0; i<localizacao.size();i++) 
	            {
	            	darray[i] = (double)localizacao.get(i);
	            }
	            aux.setLocalizacao(darray);
	            
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
        Iterator<Taxi_Model> taxiIterator = L.iterator();

        while(taxiIterator.hasNext()) 
        {
        	JSONObject jsonObject = new JSONObject();
        	Taxi_Model aux = new Taxi_Model();
        	aux = taxiIterator.next();
        	
        	//Armazena dados em um Objeto JSON
        	jsonObject.put("Usuario", aux.getUsuario());
            jsonObject.put("Nome", aux.getNome());
            jsonObject.put("Senha", aux.getSenha());
            jsonObject.put("CPF", aux.getCpf());
            jsonObject.put("Cor do Carro", aux.getCorCarro());
            jsonObject.put("Modelo do Carro", aux.getModeloCarro());
            jsonObject.put("Placa do Carro", aux.getPlaca());
            jsonObject.put("Localizacao", aux.getLocalizacao());
            jsonObject.put("Pontuacao", aux.getPontuacao());
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
	
	public static void adicionar(String nome, String usuario, String senha, String cpf)
	{
		 
				 
		Taxi_Model taxi = new Taxi_Model();
		
		taxi.setNome(nome);
	    taxi.setCpf(cpf);
	    taxi.setUsuario(usuario);
	    taxi.setSenha(senha);
	    L.add(taxi);
	        
	    jsonWrite();
           	
	}
	
	public static void remover(String nome, String usuario, String cpf)
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
	
	public static ArrayList<Taxi_Model> busca(String nome, String usuario, String cpf) 
	{
		//Pessoa_Fisica m = new Pessoa_Fisica();
		ArrayList<Taxi_Model> lista = new ArrayList<Taxi_Model>();
		try 
		{
			for(Taxi_Model aux:L)
			{
				if(aux.getNome().equals(nome) || aux.getCpf().equals(cpf) || aux.getUsuario().equals(usuario))
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
		
		//if(achou==true) 
		return lista;
		//else return null;
		
	}
	
	public static void editar(Pessoa_Fisica cliente,String nome, String usuario, String senha, String cpf) 
	{
		cliente.setNome(nome);
		cliente.setUsuario(usuario);
		cliente.setSenha(senha);
		cliente.setCpf(cpf);
	}
	
	public static void adcionarCorrida(Taxi_Model taxi, Corrida_Model corrida)
	{
		
		taxi.getCorridas().add(corrida);
	}
	
	public static Taxi_Model selecionaTaxi(double[] partida) 
	{
		ArrayList<Taxi_Model> disponiveis = new ArrayList<Taxi_Model>();
		Taxi_Model taxi = new Taxi_Model();
		
		double aux_distancia, taxi_distancia = 0.0;
		
		
		try 
		{
			for(Taxi_Model aux:L)
			{
				
				if(aux.isVisible())
				{
					disponiveis.add(aux);
			
				}
				
			}
		}
		catch(NullPointerException e) 
		{
			System.out.println("Não há taxistas próximos disponíveis. Tente novamente mais tarde");
		}
		
		try 
		{
			for(Taxi_Model aux:disponiveis)
			{
				aux_distancia = calculaDistancia(partida, aux.getLocalizacao());
				
				if(aux_distancia < 50 && aux_distancia < taxi_distancia)
				{
					taxi = aux;
			
				}
				taxi_distancia = aux_distancia;
			}
			return taxi;
		}
		catch(NullPointerException e) 
		{
			System.out.println("Não há taxistas próximos disponíveis. Tente novamente mais tarde");
		}
		return taxi;
	}
	
	public static double calculaDistancia(double[] partida, double chegada[]) 
	{
		double delta1, delta2, distancia;
		
		delta1 = (partida[0]-partida[1])*(partida[0]-partida[1]);
		delta2 = (chegada[0]-chegada[1])*(chegada[0]-chegada[1]);
		distancia = Math.sqrt(delta1+delta2);
		
		return distancia;
		
	}
	
	public static ArrayList<Taxi_Model> getList()
	{
		return L;
	}
}
