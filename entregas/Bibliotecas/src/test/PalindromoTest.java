import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class PalindromoTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testPalindromoNulo() {
		String palavra = null;  
		@SuppressWarnings("unused")
		boolean resultado = false;
		try{
			resultado = Palindromo.testarPalindromo(palavra);
			Assert.fail("Deveria ter falhado pois palavra é nulo");
		}catch(IllegalArgumentException ex){
			Assert.assertTrue(true);
		}
		
	}

	@Test
	public void testPalindromoVazio() {
		String palavra = null;  
		palavra = "";
		@SuppressWarnings("unused")
		boolean resultado = false;
		try{
			resultado = Palindromo.testarPalindromo(palavra);
			Assert.fail("Deveria ter falhado pois palavra é vazio");
		}catch(IllegalArgumentException ex){
			Assert.assertTrue(true);
		}
		
	}
	
	@Test
	public void testPalindromo() {
		String palavra = null;  
		palavra = "ouro";
		boolean resultado = false;
		
		resultado = Palindromo.testarPalindromo(palavra);
		Assert.assertTrue(resultado);
		
	}
}
