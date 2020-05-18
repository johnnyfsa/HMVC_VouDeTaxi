package model;

import java.util.ArrayList;

public class Adm_Model extends Usuario_Model{
	ArrayList<Taxi_Model> Relatorio_Geral;
	
	public Adm_Model()
	{
		Relatorio_Geral = new ArrayList<Taxi_Model>();
	}

	public ArrayList<Taxi_Model> getRelatorio_Geral() {
		return Relatorio_Geral;
	}

	public void setRelatorio_Geral(ArrayList<Taxi_Model> relatorio_Geral) {
		Relatorio_Geral = relatorio_Geral;
	}
}
