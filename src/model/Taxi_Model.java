package model;

public class Taxi_Model extends Pessoa_Fisica {
	
	
	private String ModeloCarro;
	private String CorCarro;
	private String Placa;
	private double pontuacao;
	private double[] localizacao;
	private boolean visible;
	private int totalCorridas;
	private long tempoTotal;
	private double pontuacaoTotal;
	
	public Taxi_Model() 
	{
		ModeloCarro= "";
		CorCarro = "";
		Placa = "";
		pontuacao =0;
		totalCorridas=0;
		tempoTotal = 0;
		pontuacaoTotal = 0;
		localizacao = new double[2];
		visible = true;
		
	}
	public Taxi_Model(String nome, String usuario, String senha) 
	{
		setNome(nome);
		setUsuario(usuario);
		setSenha(senha);
		ModeloCarro= "";
		CorCarro = "";
		Placa = "";
		pontuacao =0;
		totalCorridas=0;
		tempoTotal = 0;
		pontuacaoTotal = 0;
		localizacao = new double[2];
		visible = true;
	}
	
	public String getModeloCarro() {
		return ModeloCarro;
	}
	public void setModeloCarro(String modeloCarro) {
		ModeloCarro = modeloCarro;
	}
	public String getCorCarro() {
		return CorCarro;
	}
	public void setCorCarro(String corCarro) {
		CorCarro = corCarro;
	}
	public String getPlaca() {
		return Placa;
	}
	public void setPlaca(String placa) {
		Placa = placa;
	}



	public double getPontuacao() {
		return pontuacao;
	}



	public void setPontuacao(double pontuacao) {
		
		this.pontuacao = pontuacao;
	}



	public double[] getLocalizacao() {
		return localizacao;
	}



	public void setLocalizacao(double[] localizacao) {
		this.localizacao = localizacao;
	}



	public boolean isVisible() {
		return visible;
	}



	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	public int getTotalCorridas() {
		return totalCorridas;
	}
	public void setTotalCorridas(int totalCorridas) {
		this.totalCorridas = totalCorridas;
	}
	public long getTempoTotal() {
		return tempoTotal;
	}
	public void setTempoTotal(long tempoTotal) {
		this.tempoTotal = tempoTotal;
	}
	public void addCorrida() 
	{
		totalCorridas++;
	}
	public void addTempo(long tempo) 
	{
		tempoTotal+=tempo;
	}
	
	public void recebePonto(double ponto) 
	{
		this.pontuacao += ponto/totalCorridas;
	}
	
	public void setPontuacaoTotal(double pontuacaoTotal) 
	{
		this.pontuacaoTotal = pontuacaoTotal;
	}
	
	public double getPontuacaoTotal() 
	{
		return pontuacaoTotal;
	}
	
	
	

}
