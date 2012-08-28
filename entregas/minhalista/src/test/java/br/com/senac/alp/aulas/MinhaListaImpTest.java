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
		MinhaListaImp<String> obj = null;
		String valor = null;
		String sufixo = null;
		obj =  new MinhaListaImp<String>("inicio");
		valor = "valor";
		obj.sufixar(valor);
		sufixo = obterSufixo(obj);
		Assert.assertEquals(valor, sufixo);
	}

	private String obterSufixo(MinhaListaImp<String> lista)
	{
		String resultado = null;
		Nodo<String> nodo = null;
		nodo = lista.getInicio();
		while(nodo.getProximo() != null){
			nodo = nodo.getProximo();
		}
		resultado = nodo.getValor();
		
		return resultado;
	}
	
	@Test
	public void testPrefixar() {
		MinhaListaImp<String> obj = null;
		String valor = null;
		String prefixo = null;
		obj =  new MinhaListaImp<String>("inicio");
		valor = "valor";
		obj.prefixar(valor);
		prefixo = obterPrefixo(obj);
		Assert.assertEquals(valor, prefixo);
	}

	private String obterPrefixo(MinhaListaImp<String> obj) {

		String resultado = null;
		Nodo<String> nodo = null;
		nodo = obj.getInicio();
		resultado = nodo.getValor();
		return resultado;
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
