import control.Cliente_File_Controller;
import control.Taxi_File_Controller;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Taxi_File_Controller taxi = new Taxi_File_Controller();
		 Cliente_File_Controller cliente = new Cliente_File_Controller();
		 
		 cliente.jsonRead();
		 taxi.jsonRead();

	}

}
