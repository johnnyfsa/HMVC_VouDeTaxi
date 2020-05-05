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

import model.Cliente_Model;

public class Cliente_File_Controller extends File_Controller {
	
	private ArrayList<Cliente_Model> L;
	
	
	public Cliente_File_Controller() 
	{
		L = new ArrayList<Cliente_Model>();
	}
	
	public void jsonRead() 
	{
			
		   	JSONObject jsonObject;
	        JSONArray jsonArray;
	        //Cria o parse de tratamento
	        JSONParser parser = new JSONParser();
	        //Variaveis que irao armazenar os dados do arquivo JSON
	        try {
	        	FileReader file = new FileReader("clientes.json");
	        	if(file.read() ==-1) 
	        	{
	        		System.out.println("Arquivo vazio\n");
	        		extracted();
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
	            	Cliente_Model aux = new Cliente_Model();
	            	jsonObject = externalIterator.next();
	            	 aux.setNome((String) jsonObject.get("Nome"));
	                 aux.setUsuario((String) jsonObject.get("Usuario"));
	                 aux.setSenha((String) jsonObject.get("Senha"));
	                 aux.setCpf((String) jsonObject.get("CPF"));
	                
	                 L.add(aux);
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

	private void extracted() {
	}
	
	public void jsonWrite() 
	{
		//Cria um Objeto JSON
        JSONArray arrJson = new JSONArray();
        
        FileWriter writeFile = null;
        
        Iterator<Cliente_Model> clienteIterator = L.iterator();
        while(clienteIterator.hasNext()) 
        {
        	JSONObject jsonObject = new JSONObject();
        	Cliente_Model aux = new Cliente_Model();
        	aux = clienteIterator.next();
        	 //Armazena dados em um Objeto JSON
        	jsonObject.put("Usuario", aux.getUsuario());
            jsonObject.put("Nome", aux.getNome());
            jsonObject.put("Senha", aux.getSenha());
            jsonObject.put("CPF", aux.getCpf());
           
           arrJson.add(jsonObject);
        }
         
        try{
            writeFile = new FileWriter("clientes.json");
            //Escreve no arquivo conteudo do Objeto JSON
            writeFile.write(arrJson.toJSONString());
            writeFile.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
	}
	
	public ArrayList<Cliente_Model> getList()
	{
		return L;
	}

}
