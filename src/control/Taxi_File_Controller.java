package control;

import java.io.File;
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

import model.Cliente_Model;
import model.Taxi_Model;
import model.Usuario_Model;

public class Taxi_File_Controller 
{
	
	private ArrayList<Taxi_Model> L;
	
	public Taxi_File_Controller() 
	{
		L = new ArrayList<Taxi_Model>();
	}
	
	private void extracted() 
	{
	}
	
	public void jsonRead()
	{
		L = new ArrayList<Taxi_Model>();
	   	JSONObject jsonObject;
        JSONArray jsonArray;
        
        //Cria o parse de tratamento
        JSONParser parser = new JSONParser();
        //Variaveis que irao armazenar os dados do arquivo JSON
        try {
        	FileReader file = new FileReader("taxis.json");
        	if(file.read() ==-1) 
        	{
        		System.out.println("Arquivo vazio\n");
        		extracted();
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
            	Taxi_Model user = new Taxi_Model();
            	jsonObject = externalIterator.next();
            	 user.setNome((String) jsonObject.get("Nome"));
                 user.setUsuario((String) jsonObject.get("Usuario"));
                 user.setSenha((String) jsonObject.get("Senha"));
                 user.setCpf((String) jsonObject.get("CPF"));
                
                 L.add(user);
            }
        }
        //Trata as exceptions que podem ser lan�adas no decorrer do processo
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
        
        
              
        
	}
	
	
	public void jsonWrite(String dados) 
	{
		JSONObject jsonObject;
        JSONArray jsonArray;
		File file = new File("taxis.json"); 
		 JSONParser parser = new JSONParser();
		
		try 
		{
			if(file.exists()) 
			{
				 FileWriter writer = new FileWriter(file);
				 writer.write(dados);
		         writer.close();
		         
		         
				 
			}
		}catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } 
		
	        	
	}
	
	public ArrayList<Taxi_Model> getList()
	{
		return L;
	}
}
