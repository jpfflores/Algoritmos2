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

	private final static String NOME_GET_ERRADO = "get.nok";
	private final static String NOME_GET_CORRETO = "get.txt";

	private final static String ARQUIVO_GET_ENTRADA = DIRETORIO_ENTRADA
			+ NOME_ARQUIVO_ENTRADA;
	private final static String ARQUIVO_GET_ERRADO = DIRETORIO_ENTRADA
			+ NOME_ARQUIVO_ERRADO;
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCriarNulo() {
		MainReal  main = null;
		try {
			main = criarMainWS(null);
			fail("Deveria ter abortado");
		} catch (Exception e) {
			Assert.assertTrue(true);
		}
	}

	private MainReal criarMainWS(String[] args) throws Exception{

		MainReal mainreal = new MainReal(args);
		return mainreal;

	}

	@Test
	public void testConfigIsDiretorio() {
		String[] args = new String[2];
		MainReal  main = null;
		try {
			args[0] = DIRETORIO_ENTRADA;
			args[1] = ARQUIVO_GET_ENTRADA;
			main = criarMainWS(args);
			fail("Deveria ter abortado");
		} catch (Exception e) {
			Assert.assertTrue(true);
		}
	}

	@Test
	public void testParametroIsDiretorio() {
		String[] args = new String[2];
		MainReal  main = null;
		try {
			args[0] = ARQUIVO_ENTRADA;
			args[1] = DIRETORIO_ENTRADA;
			main = criarMainWS(args);
			fail("Deveria ter abortado");
		} catch (Exception e) {
			Assert.assertTrue(true);
		}
	}
	@Test
	public void testCriarArquivoValido() {
		String[] args = new String[2];
		MainReal  main = null;
		try {
			args[0] = DIRETORIO_ENTRADA;
			args[1] = ARQUIVO_GET_ENTRADA;
			main = criarMainWS(args);
			Assert.assertTrue(true);
			
		} catch (Exception e) {
			fail("Não deveria ter abortado");
		}
		
	}

	@Test
	public void testCarregarConfigInexistente() {

		String[] args = new String[2];
		MainReal  main = null;
		try {
			args[0] = ARQUIVO_INEX;
			args[1] = ARQUIVO_GET_ENTRADA;
			main = criarMainWS(args);			
			fail("Deveria ter abortado");
		} catch (Exception e) {
			Assert.assertTrue(true);
		}
	}

	@Test
	public void testCarregarConfigComErro() {

		String[] args = new String[2];
		MainReal  main = null;
		try {
			args[0] = ARQUIVO_ERRADO;
			args[1] = ARQUIVO_GET_ENTRADA;
			main = criarMainWS(args);			
			fail("Deveria ter abortado");
		} catch (Exception e) {
			Assert.assertTrue(true);
		}
	}
	
	@Test
	public void testCarregarSomenteUmParametro() {

		MainReal  main = null;
		String[] args = new String[2];
		try {
			args[0] = DIRETORIO_ENTRADA;
			args[1] = null;
			main = criarMainWS(args);			
			fail("Deveria ter abortado");
		} catch (Exception e) {
			Assert.assertTrue(true);
		}
	}

	@Test
	public void testCarregarGETInexistente() {

		String[] args = new String[2];
		MainReal  main = null;
		try {
			args[0] = DIRETORIO_ENTRADA;
			args[1] = ARQUIVO_INEX;
			main = criarMainWS(args);			
			fail("Deveria ter abortado");
		} catch (Exception e) {
			Assert.assertTrue(true);
		}
	}

	@Test
	public void testCarregarGETInvalido() {

		String[] args = new String[2];
		MainReal  main = null;
		try {
			args[0] = DIRETORIO_ENTRADA;
			args[1] = ARQUIVO_GET_ERRADO;
			main = criarMainWS(args);			
			fail("Deveria ter abortado");
		} catch (Exception e) {
			Assert.assertTrue(true);
		}
	}
	
}
