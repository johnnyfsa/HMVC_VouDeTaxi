package Randomico;
import java.util.Random;

public class aceitaRandom 
{
	private int result;	
	private Random randomNum = new Random();

	public boolean aceitaCorrida()
	{
	  result = randomNum.nextInt(2);
	   if(result == 0)
	   {
		   System.out.println("Não aceitou");
	        return false;
	        
	    }
	   else
	   {
		   System.out.println("Aceitou");
	      return true;
	        
	    }
	 }
}

