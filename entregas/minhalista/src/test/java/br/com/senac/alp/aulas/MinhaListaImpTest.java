package br.com.senac.alp.aulas;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MinhaListaImpTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMinhaListaImp() {
		MinhaListaImp<String> obj = null;
		String arg = null;
		arg = "valor valido";
		obj = new MinhaListaImp<String>(arg);
		Assert.assertNotNull(obj);
		
	}
	
	@Test
	public void testMinhaListaImpNull() {
		MinhaListaImp<String> obj = null;
		String arg = null;
		try{
			obj = new MinhaListaImp<String>(arg);
			fail();
		}catch(IllegalArgumentException e){
			// Por enquanto nada
			Assert.assertTrue(true);
		}
		
	}

	@Test
	public void testSufixar() {
		
	}

	@Test
	public void testPrefixar() {
		fail("Not yet implemented");
	}

	@Test
	public void testBuscar() {
		fail("Not yet implemented");
	}

	@Test
	public void testInserir() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemover() {
		fail("Not yet implemented");
	}

	@Test
	public void testTamanho() {
		fail("Not yet implemented");
	}

}
