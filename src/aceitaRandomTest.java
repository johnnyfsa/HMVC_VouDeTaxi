import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class aceitaRandomTest {

	@Test
	void test() 
	{
		aceitaRandom aceita = new aceitaRandom();
		
		assertEquals(aceita.aceitaCorrida(), "true" );
	}

}
