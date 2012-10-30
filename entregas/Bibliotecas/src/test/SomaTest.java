import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class SomaTest {

	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSomaParesNulo() {
		int resultado = 0;
		int[] valores = null;  
		try{
			resultado = Soma.somaPares(valores);
			Assert.fail("Deveria ter falhado pois valores é nulo e o resultado é " + resultado);
		}catch(IllegalArgumentException ex){
			Assert.assertTrue(true);
		}
		
	}

	@Test
	public void testSomaParesVazio() {
		int esperado =0;
		int resultado = 0;
		int[] valores = null;  
		valores = new int[0];
		resultado = Soma.somaPares(valores);
		Assert.assertEquals(esperado, resultado);
	}

	@Test
	public void testSomaPares() {
		int esperado = 0;
		int resultado = 0;
		int[] valores = null;  
		valores = new int[]{ 3, 5, 10, 11, 8, 4, 7, 0, -2, -3};
		esperado = 3 + 10 + 8 + 7 -2;
		resultado = Soma.somaPares(valores);
		Assert.assertEquals(esperado, resultado);
	}
	
	
	@Test
	public void testSomaImparesNulo() {
		int resultado = 0;
		int[] valores = null;  
		try{
			resultado = Soma.somaImpares(valores);
			Assert.fail("Deveria ter falhado pois valores é nulo e o resultado é " + resultado);
		}catch(IllegalArgumentException ex){
			Assert.assertTrue(true);
		}
	}

	@Test
	public void testSomaImparesVazio() {
		int esperado =0;
		int resultado = 0;
		int[] valores = null;  
		valores = new int[0];
		resultado = Soma.somaImpares(valores);
		Assert.assertEquals(esperado, resultado);
	}

	@Test
	public void testSomaImpares(){
		int esperado = 0;
		int resultado = 0;
		int[] valores = null;  
		valores = new int[]{ 3, 5, 10, 11, 8, 4, 7, 0, -2, -3, -1};
		esperado = 5 + 11 + 4 + 0 -3;
		resultado = Soma.somaImpares(valores);
		Assert.assertEquals(esperado, resultado);
	}
}
