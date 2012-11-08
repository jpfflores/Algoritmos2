package br.com.senacrs.alp.aulas.trabalho12;

import static org.junit.Assert.fail;

import java.io.File;
import java.util.Arrays;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class MainTest 
    
{
    
	private final static String DIRETORIO_ENTRADA = System
			.getProperty("user.dir")
			+ File.separatorChar
			+ "diretorio"
			+ File.separatorChar;
	private final static String NOME_ARQUIVO_ENTRADA = "server_conf.txt";
	private final static String NOME_ARQUIVO_INEX = "server_conf.err";
	private final static String NOME_ARQUIVO_ERRADO = "server_conf.nok";
	private final static String ARQUIVO_ENTRADA = DIRETORIO_ENTRADA
			+ NOME_ARQUIVO_ENTRADA;
	private final static String ARQUIVO_ERRADO = DIRETORIO_ENTRADA
			+ NOME_ARQUIVO_ERRADO;
	private final static String ARQUIVO_INEX = DIRETORIO_ENTRADA
			+ NOME_ARQUIVO_INEX;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCriarNulo() {

		try {
			criarMainWS(null);
			fail("Deveria ter abortado");
		} catch (IllegalArgumentException e) {
			Assert.assertTrue(true);
		}
	}

	private Main criarMainWS(String arquivoEntrada) throws IllegalArgumentException{

		Main obj = new Main();
		String[] parameters = new String[1];
		parameters[0] = arquivoEntrada;
		obj.main(parameters);
		return obj;

	}

	@Test
	public void testParametroIsDiretorio() {

		try {
			criarMainWS(DIRETORIO_ENTRADA);
			fail("Deveria ter abortado");
		} catch (IllegalArgumentException e) {
			Assert.assertTrue(true);
		}
	}

	@Test
	public void testCriarArquivoValido() {

		try {
			criarMainWS(ARQUIVO_ENTRADA);
			Assert.assertTrue(true);
			
		} catch (IllegalArgumentException e) {
			fail("Não deveria ter abortado");
		}
		
	}

	@Test
	public void testCarregarArquivoInexistente() {

		Main obj = null;

		try {
			obj = criarMainWS(ARQUIVO_INEX);
			fail("Deveria ter abortado");
		} catch (IllegalArgumentException e) {
			Assert.assertTrue(true);
		}
	}

	@Test
	public void testCarregarArquivoComErro() {

		Main obj = null;

		try {
			obj = criarMainWS(ARQUIVO_ERRADO);
			fail("Deveria ter abortado");
		} catch (IllegalArgumentException e) {
			Assert.assertTrue(true);
		}
	}
	

}
