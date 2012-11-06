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
	private final static String NOME_ARQUIVO_ENTRADA = "entrada.txt";
	private final static String NOME_ARQUIVO_SAIDA = "saida.txt";
	private final static String ARQUIVO_ENTRADA = DIRETORIO_ENTRADA
			+ NOME_ARQUIVO_ENTRADA;
	private final static String ARQUIVO_SAIDA = DIRETORIO_ENTRADA
			+ NOME_ARQUIVO_SAIDA;
	private final static String LIDO = "ler";
	private final static String RETORNADO = "manipular";
	private final static String[] CONTEUDO = new String[] {
			"Este e o arquivo de entrada e deve", // 0
			"ser utilizado nos testes", // 1
			"Verifique que voce nao apagou o mesmo", // 2
			"", // 3
			"Eu consigo ler o arquivo", // 4
			"Eu consigo escrever no arquivo", // 5
	};
	private static String SUBSTITUICAO = "Eu consigo " + RETORNADO
			+ " o arquivo";

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

	private Main criarMainWS(String arquivoEntrada) {

		Main obj = new Main();
		String[] parameters = new String[1];
		parameters[0] = arquivoEntrada;
		obj.main(parameters);
		return obj;

	}

	@Test
	public void testCriarDiretorio() {

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
			obj = criarMainWS(ARQUIVO_SAIDA);
			fail("Deveria ter abortado");
		} catch (IllegalArgumentException e) {
			Assert.assertTrue(true);
		}
	}

	@Test
	public void testLerArquivo() {

		Main obj = null;
		String[] resultado = null;
		String msg = null;

		obj = criarMainWS(ARQUIVO_ENTRADA);
		
		msg = "Resultado :" + Arrays.toString(resultado);
		msg += " Esperado :" + Arrays.toString(CONTEUDO);
		Assert.assertTrue(msg, Arrays.deepEquals(CONTEUDO, resultado));
	}

	

}
