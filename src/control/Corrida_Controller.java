package control;

import java.time.LocalDateTime;

import Randomico.CriaClienteAleatorio;
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
		//Liga o taxi à corrida
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
		//n�o n�o houver um cpf � porque n�o h� taxis vis�veis, ou ningu�m aceitou a corrida
		if(corrida_atual.getTaxi().getCpf().isEmpty()) 
		{
			return false;
		}
		return true;
	}
	
	public static boolean CriarCorridaTaxi() 
	{
		CriaClienteAleatorio cca = new CriaClienteAleatorio();
		Pessoa_Fisica cliente = cca.getCobaia();
		corrida_atual = new Corrida_Model();
		corrida_atual.setPartida(cca.getPartida());
		corrida_atual.setChegada(cca.getChegada());
		corrida_atual.calculaDistancia();
		corrida_atual.setCliente(cliente);
		corrida_atual.setHorario(LocalDateTime.now());
		
		return false;
	}
	
	public static void reset() 
	{
		corrida_atual = new Corrida_Model();
	}
	
	public static void aceitaCorrida(boolean aceita) 
	{
		corrida_atual.setStatus(aceita);
		corrida_atual.setTaxi((Taxi_Model)Login_Controller.getUsuario());
		
	}
			
}
