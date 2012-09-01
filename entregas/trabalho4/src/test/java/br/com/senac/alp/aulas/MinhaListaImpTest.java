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
		obj = new MinhaListaImp<String>();
		Assert.assertNotNull(obj);
		
	}
	

	@Test
	public void testSufixar() {
		MinhaListaImp<String> obj = new MinhaListaImp<String>();
		String valor = null;
		String sufixo = null;
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
		obj =  new MinhaListaImp<String>();
		valor = "valor";
		obj.prefixar(valor);
		prefixo = obterPrefixo(obj);
		Assert.assertEquals(valor, prefixo);
	}

	private String obterPrefixo(MinhaListaImp<String> obj) {

		String resultado = null;
		Nodo<String> nodo = null;
		nodo = obj.getInicio();
		nodo = nodo.getProximo();
		resultado = nodo.getValor();
		return resultado;
	}

	@Test
	public void testBuscar() {
		MinhaListaImp<String> obj = null;
		obj = new MinhaListaImp();
		int posicao = 5;
		int tamanho = 7;
		String esperado = "valor_5";
		String resultado = new String();
		gerarLista(obj,tamanho);
		
		try{
			
		}catch(IndexOutOfBoundsException e){
			Assert.assertTrue(false);
		}
	}

	@Test
	public void testBuscarExcede() {
		MinhaListaImp<String> obj = new MinhaListaImp<String>();
		int posicao = 7;
		int tamanho = 6;
		gerarLista(obj,tamanho);
		try{
			obj.buscar(posicao);
			Assert.assertTrue(false);
		}catch(IndexOutOfBoundsException e){
			Assert.assertTrue(true);
		}
	}
	@Test
	public void testInserir() {
		MinhaListaImp<String> obj = null;
		String esperado = "valor_inserido";
		String resultado = null;
		obj =  new MinhaListaImp<String>();
		int posicao = 5;
		int tamanho = 8;
		gerarLista(obj, tamanho);
		obj.inserir(posicao, esperado);
		resultado = buscarValor(obj,posicao);
		Assert.assertEquals(esperado, resultado);
	}

	@Test
	public void testInserirExcede() {
		MinhaListaImp<String> obj = null;
		String esperado = "valor_inserido";
		String resultado = null;
		obj =  new MinhaListaImp<String>();
		int posicao = 10;
		int tamanho = 8;
		gerarLista(obj, tamanho);
		try{
			obj.inserir(posicao, esperado);
			resultado = buscarValor(obj,posicao);
			Assert.assertTrue(false);
		}catch(IndexOutOfBoundsException e){
			Assert.assertTrue(true);
		}
	}

	public String buscarValor(MinhaListaImp<String> obj, int pos) {
		Nodo<String> nodo = obj.getInicio();
		
		for (int i = 0; i < pos; i++) {
			nodo = nodo.getProximo();
		}
		return nodo.getValor();
	}
	
	@Test
	public void testRemover() {
		MinhaListaImp<String> obj = null;
		int tamanho = 10;
		int posicao = 7;
		String previsto = null;
		String resultado = null;
		previsto = "valor_6";
		obj =  new MinhaListaImp<String>();
		gerarLista(obj,tamanho);
		resultado = obj.remover(posicao);
		Assert.assertEquals(previsto,resultado);
	}

	@Test
	public void testRemoverExcede() {
		MinhaListaImp<String> obj = null;
		int tamanho = 7;
		int posicao = 10;
		String resultado = null;
		obj =  new MinhaListaImp<String>();
		gerarLista(obj,tamanho);
		try{
			resultado = obj.remover(posicao);
			Assert.assertTrue(false);
		}catch(IndexOutOfBoundsException e){
			Assert.assertTrue(true);
		}
	}
	
	@Test
	public void testTamanhoZero() {
		MinhaListaImp<String> obj = null;
		int tamanho = 0;
		int previsto = 0;
		obj =  new MinhaListaImp<String>();
		gerarLista(obj,previsto);
		tamanho = obj.tamanho();
		Assert.assertEquals(previsto, tamanho);
	}
	
	@Test
	public void testTamanho() {
		MinhaListaImp<String> obj = null;
		int tamanho = 0;
		int previsto = 6;
		obj =  new MinhaListaImp<String>();
		gerarLista(obj,previsto);
		tamanho = obj.tamanho();
		Assert.assertEquals(previsto, tamanho);
	}

	private void gerarLista(MinhaListaImp<String> obj, int tamanho) {
		Nodo<String> nodo = null;
		nodo = obj.getInicio();
		
		for (int i = 0 ; i < tamanho ; i++){
			Nodo<String> novo = null;
			novo = new Nodo<String>("valor_" + (i));
			nodo.setProximo(novo);
			nodo = novo;
		}
		
	}

}
