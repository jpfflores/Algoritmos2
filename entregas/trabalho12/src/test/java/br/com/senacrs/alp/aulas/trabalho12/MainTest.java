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
	private final static String NOME_ARQUIVO_ERRADO_PORT = "server_conf.nok";
	private final static String NOME_ARQUIVO_ERRADO_ROOT = "server_conf2.nok";
	private final static String ARQUIVO_ENTRADA = DIRETORIO_ENTRADA
			+ NOME_ARQUIVO_ENTRADA;
	private final static String ARQUIVO_INEX = DIRETORIO_ENTRADA
			+ NOME_ARQUIVO_INEX;
	private final static String ARQUIVO_ERRADO_PORT = DIRETORIO_ENTRADA
			+ NOME_ARQUIVO_ERRADO_PORT;
	private final static String ARQUIVO_ERRADO_ROOT = DIRETORIO_ENTRADA
			+ NOME_ARQUIVO_ERRADO_ROOT;

	
	private final static String NOME_GET_ERRADO = "get1.nok";
	private final static String NOME_GET_ERRADO_HTTP = "get1.nok";
	private final static String NOME_GET_ERRADO_HOST = "get2.nok";
	
	private final static String NOME_GET_CORRETO = "get.txt";

	private final static String ARQUIVO_GET_ENTRADA = DIRETORIO_ENTRADA
			+ NOME_GET_CORRETO;
	private final static String ARQUIVO_GET_ERRADO = DIRETORIO_ENTRADA
			+ NOME_GET_ERRADO;
	private final static String ARQUIVO_GET_ERRADO_HTTP = DIRETORIO_ENTRADA
			+ NOME_GET_ERRADO_HTTP;
	private final static String ARQUIVO_GET_ERRADO_HOST = DIRETORIO_ENTRADA
			+ NOME_GET_ERRADO_HOST;

	private final static String NOME_DESTINO_INEXISTENTE = "index.nok";
	private final static String NOME_DESTINO_VAZIO = "index.emp";
	private final static String NOME_DESTINO_EXISTE = "index.html";

	private final static String ARQUIVO_DESTINO_INEXISTENTE = DIRETORIO_ENTRADA
			+ NOME_DESTINO_INEXISTENTE;
	private final static String ARQUIVO_DESTINO_VAZIO = DIRETORIO_ENTRADA
			+ NOME_DESTINO_VAZIO;
	private final static String ARQUIVO_DESTINO_EXISTE = DIRETORIO_ENTRADA
			+ NOME_DESTINO_EXISTE;

	
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

	@Test
	public void testConfigIsDiretorio() {
		String[] args = new String[3];
		MainReal  main = null;
		try {
			args[0] = DIRETORIO_ENTRADA;
			args[1] = ARQUIVO_GET_ENTRADA;
			args[2] = ARQUIVO_DESTINO_EXISTE;

			main = criarMainWS(args);
			fail("Deveria ter abortado");
		} catch (Exception e) {
			Assert.assertTrue(true);
		}
	}

	@Test
	public void testParametroIsDiretorio() {
		String[] args = new String[3];
		MainReal  main = null;
		try {
			args[0] = ARQUIVO_ENTRADA;
			args[1] = DIRETORIO_ENTRADA;
			args[2] = ARQUIVO_DESTINO_EXISTE;

			main = criarMainWS(args);
			fail("Deveria ter abortado");
		} catch (Exception e) {
			Assert.assertTrue(true);
		}
	}
	
	@Test
	public void testCarregarConfigInexistente() {

		String[] args = new String[3];
		MainReal  main = null;
		try {
			args[0] = ARQUIVO_INEX;
			args[1] = ARQUIVO_GET_ENTRADA;
			args[2] = ARQUIVO_DESTINO_EXISTE;

			main = criarMainWS(args);			
			fail("Deveria ter abortado");
		} catch (Exception e) {
			Assert.assertTrue(true);
		}
	}

	@Test
	public void testCarregarConfigComErroPort() {

		String[] args = new String[3];
		MainReal  main = null;
		try {
			args[0] = ARQUIVO_ERRADO_PORT;
			args[1] = ARQUIVO_GET_ENTRADA;
			args[2] = ARQUIVO_DESTINO_EXISTE;

			main = criarMainWS(args);			
			fail("Deveria ter abortado");
		} catch (Exception e) {
			Assert.assertTrue(true);
		}
	}

	@Test
	public void testCarregarConfigComErroRoot() {

		String[] args = new String[3];
		MainReal  main = null;
		try {
			args[0] = ARQUIVO_ERRADO_ROOT;
			args[1] = ARQUIVO_GET_ENTRADA;
			args[2] = ARQUIVO_DESTINO_EXISTE;

			main = criarMainWS(args);			
			fail("Deveria ter abortado");
		} catch (Exception e) {
			Assert.assertTrue(true);
		}
	}
	
	@Test
	public void testCarregarSomenteUmParametro() {

		MainReal  main = null;
		String[] args = new String[3];
		try {
			args[0] = DIRETORIO_ENTRADA;
			args[1] = null;
			args[2] = null;

			main = criarMainWS(args);			
			fail("Deveria ter abortado");
		} catch (Exception e) {
			Assert.assertTrue(true);
		}
	}

	@Test
	public void testCarregarGETInexistente() {

		String[] args = new String[3];
		MainReal  main = null;
		try {
			args[0] = DIRETORIO_ENTRADA;
			args[1] = ARQUIVO_INEX;
			args[2] = ARQUIVO_DESTINO_EXISTE;

			main = criarMainWS(args);			
			fail("Deveria ter abortado");
		} catch (Exception e) {
			Assert.assertTrue(true);
		}
	}

	@Test
	public void testCarregarGETInvalido() {

		String[] args = new String[3];
		MainReal  main = null;
		try {
			args[0] = DIRETORIO_ENTRADA;
			args[1] = ARQUIVO_GET_ERRADO;
			args[2] = ARQUIVO_DESTINO_EXISTE;

			main = criarMainWS(args);			
			fail("Deveria ter abortado");
		} catch (Exception e) {
			Assert.assertTrue(true);
		}
	}
	
	@Test
	public void testCarregarGETHostInvalido() {

		String[] args = new String[3];
		MainReal  main = null;
		try {
			args[0] = DIRETORIO_ENTRADA;
			args[1] = ARQUIVO_GET_ERRADO_HOST;
			args[2] = ARQUIVO_DESTINO_EXISTE;

			main = criarMainWS(args);			
			fail("Deveria ter abortado");
		} catch (Exception e) {
			Assert.assertTrue(true);
		}
	}
	
	@Test
	public void testCarregarGETHTTPInvalido() {

		String[] args = new String[3];
		MainReal  main = null;
		try {
			args[0] = DIRETORIO_ENTRADA;
			args[1] = ARQUIVO_GET_ERRADO_HTTP;
			args[2] = ARQUIVO_DESTINO_EXISTE;

			main = criarMainWS(args);			
			fail("Deveria ter abortado");
		} catch (Exception e) {
			Assert.assertTrue(true);
		}
	}
	
	@Test
	public void testCarregarTargetInvalido() {

		String[] args = new String[3];
		MainReal  main = null;
		try {
			args[0] = ARQUIVO_ENTRADA;
			args[1] = ARQUIVO_GET_ENTRADA;
			args[2] = ARQUIVO_DESTINO_INEXISTENTE;
			main = criarMainWS(args);			
			fail("Deveria ter abortado");
		} catch (Exception e) {
			Assert.assertTrue(true);
		}
	}
	
	@Test
	public void testCarregarTargetVazio() {

		String[] args = new String[3];
		MainReal  main = null;
		try {
			args[0] = ARQUIVO_ENTRADA;
			args[1] = ARQUIVO_GET_ENTRADA;
			args[2] = ARQUIVO_DESTINO_VAZIO;
			main = criarMainWS(args);	
			Assert.assertTrue(true);
		} catch (Exception e) {
			fail("Não deveria ter abortado");
		}
	}
	
	@Test
	public void testCriarArquivoValido() {
		String[] args = new String[3];
		MainReal  main = null;
		try {
			args[0] = ARQUIVO_ENTRADA;
			args[1] = ARQUIVO_GET_ENTRADA;
			args[2] = ARQUIVO_DESTINO_EXISTE;

			main = criarMainWS(args);
			Assert.assertTrue(true);
			
		} catch (Exception e) {
			fail("Não deveria ter abortado");
		}
		
	}
	
	private MainReal criarMainWS(String[] args) throws Exception{

		MainReal mainreal = new MainReal(args);
		return mainreal;

	}

}
