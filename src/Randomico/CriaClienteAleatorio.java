package Randomico;
import java.util.Random;

import control.Cliente_Controller;
import model.Pessoa_Fisica;


public class CriaClienteAleatorio {
	
	private int RandomIndex;
	private Pessoa_Fisica cobaia;
	private double[] partida;
	private double[] chegada;
	
	public CriaClienteAleatorio() 
	{
		RandomIndex = (int) (Math.random()*Cliente_Controller.getList().size());
		cobaia = Cliente_Controller.getList().get(RandomIndex);
		setPartida(new double[2]);
		setChegada(new double[2]);
		getPartida()[0]= (Math.random()*10000);
		getPartida()[1]= (Math.random()*10000);
		getChegada()[0]= (Math.random()*10000);
		getChegada()[1]= (Math.random()*10000);
	}
	
	public Pessoa_Fisica getCobaia() {
		return cobaia;
	}
	public void setCobaia(Pessoa_Fisica cobaia) {
		this.cobaia = cobaia;
	}
	public int getRandomIndex() {
		return RandomIndex;
	}
	public void setRandomIndex(int randomIndex) {
		RandomIndex = randomIndex;
	}

	public double[] getPartida() {
		return partida;
	}

	public void setPartida(double[] partida) {
		this.partida = partida;
	}

	public double[] getChegada() {
		return chegada;
	}

	public void setChegada(double[] chegada) {
		this.chegada = chegada;
	}

}
