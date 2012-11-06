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
	private final static String ARQUIVO_ENTRADA = DIRETORIO_ENTRADA
			+ NOME_ARQUIVO_ENTRADA;

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
	public void testParametroIsArquivo() {

		try {
			criarMainWS(DIRETORIO_ENTRADA);
			fail("Deveria ter abortado");
		} catch (IllegalArgumentException e) {
			Assert.assertTrue(true);
		}
	}

	@Test
	public void testCriarArquivoValido() {

		criarMainWS(ARQUIVO_ENTRADA);
	}

	@Test
	public void testLerArquivoInexistente() {

		Main obj = null;

		try {
			obj = criarMainWS(ARQUIVO_ENTRADA);
			fail("Deveria ter abortado");
		} catch (IllegalArgumentException e) {
			Assert.assertTrue(true);
		}
	}

	

}
