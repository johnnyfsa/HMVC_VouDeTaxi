package control;

import java.time.LocalDateTime;

import model.Corrida_Model;
import model.Pessoa_Fisica;
import model.Taxi_Model;

public class Corrida_Controller 
{
	private static Corrida_Model corrida_atual;
	
	
	public static void setCorrida(Corrida_Model corrida) 
	{
		corrida_atual = corrida;
	}
	
	public static Corrida_Model getCorrida() 
	{
		return corrida_atual;
	}
	
	public static void associarTaxi() 
	{
		Taxi_Model taxi = Taxi_Controller.selecionaTaxi(corrida_atual.getPartida());
		
		//Liga a corrida ao taxi
		corrida_atual.setTaxi(taxi);
		//Liga o taxi Ã  corrida
		Taxi_Controller.adcionarCorrida(taxi, corrida_atual);
	}
	
	public static boolean CriarCorrida(double[] partida, double[] chegada, LocalDateTime horario) 
	{
		Pessoa_Fisica pessoa;
		
		corrida_atual = new Corrida_Model();
		corrida_atual.setPartida(partida);
		corrida_atual.setChegada(chegada);
		corrida_atual.calculaDistancia();
		pessoa = (Pessoa_Fisica) Login_Controller.getUsuario();
		corrida_atual.setCliente(pessoa);
		corrida_atual.setHorario(horario);
		associarTaxi();
		//não não houver um cpf é porque não há taxis visíveis, ou ninguém aceitou a corrida
		if(corrida_atual.getTaxi().getCpf().isEmpty()) 
		{
			return false;
		}
		return true;
	}
	
	
	
		
		
}
