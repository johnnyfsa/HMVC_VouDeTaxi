package control;

import model.Corrida_Model;

public class Corrida_Controller 
{
	private Corrida_Model corrida_atual;
	
	
	public void setCorrida(Corrida_Model corrida_atual) 
	{
		this.corrida_atual = corrida_atual;
	}
	
	public Corrida_Model getCorrida() 
	{
		return corrida_atual;
	}
	
	public void associarTaxi() 
	{
		
	}
}
