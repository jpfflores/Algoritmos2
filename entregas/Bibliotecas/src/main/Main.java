
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;


public class Main {

	public static Random random = new Random(System.currentTimeMillis());
	/**
	 * @param args
	 */
	public static void main(String[] args) {
/*
		manipulaArquivo();
		manipulaLista();
		testaFrase();
*/
		testeAssert();
		
	}
	
	public static void testeAssert(){
		String var = null;
		assert var != null:"Não pode mais ser null"; //podem ser usados métodos não void
		System.out.println(var);
		
	}
	
	public static void manipulaArquivo(){
		// Manipulação de arquivos
		String proj = System.getProperty("user.dir");
		String dir = "src";
		String arq = "teste.txt";
		String path = proj + File.separatorChar + dir + File.separatorChar + arq;
		Arquivo arquivo = null;
		Arquivo arquivo2 = null;
		FileOutputStream out = null;
		try {
			arquivo = new Arquivo(path);
			//arquivo.imprimirConteudo();
			arquivo.fecharArquivo();
		}catch(IOException ex){
			System.out.println("Falha já tratada.");
		}
		arq = "teste2.txt";
		path = proj + File.separatorChar + dir + File.separatorChar + arq;
		try {
			arquivo2 = new Arquivo();
			File arq2 = new File(path);
			arquivo2.setArquivo(arq2);
			out = new FileOutputStream(arq2);
			arquivo2.setOutput(out);
			byte[] texto = new byte[] {'S','A','I','D','A'};
			arquivo2.escreverConteudo(texto);
			arquivo2.fecharArquivo();
		}catch(IOException ex){
			System.out.println("Falha já tratada.");
		}
	}
	
	public static void manipulaLista(){
		Object obj = null;
		String msg = null;
		obj = new Main();
		msg = "Objeto: " + String.valueOf(obj);
		LinkedList<Pessoa> lista = null;
		lista = new LinkedList<Pessoa>();
		
		generateLista(lista,8);
		msg = "Lista desordenada: " + lista.toString();
		System.out.println(msg);
		CompararIdade comparador = null;
		comparador = new CompararIdade(); 
		Collections.sort(lista, comparador);
		msg = "Lista ordenada: " + lista.toString();
		System.out.println(msg);
	}
	public static void testaFrase(){
		frase();
		frase("Argumento único");
		frase("argumento","em","linha");
		
	}
	public static void generateLista(LinkedList<Pessoa> lista, int tamanho){
		String nome = null;
		int idade = 0;
		
		for( int i = 0 ; i < tamanho; i++)
		{
			Pessoa pes = null;
			nome = criarString(10);
			idade = 10 + random.nextInt(70);
			pes = new Pessoa(nome, idade);
			lista.add(pes);
		}
		
	}
	
	public static String criarString(int quantidade) {
		
		StringBuffer resultado = new StringBuffer();
		
		for (int i = 0; i < quantidade; i++) {
			resultado.append(criarChar());
		}
		
		return resultado.toString();
	}
	
	public static  char criarChar() {
		
		char resultado = '\0';
		
		resultado = (char)((int)'A' + random.nextInt((int)'Z' - (int)'A'));
		
		return resultado;
	}
	

	public static void frase(String ... argumentos){
		String msg = null;
		if(argumentos.length == 0){
			msg = "Não há argumentos.";
		} else {
			msg = "A frase é: ";
			msg += argumentos[0];
			for(int i = 1 ; i < argumentos.length ; i++){
				msg += " " +  argumentos[i];
			}
		}
		System.out.println(msg);
		
	}
	
	/**
	 * Utilização do assert Assert <expressao booleana> [: <mensagens>]
	 * 
	 * String var = null;
	 * assert var != null // isto vem por padrão desligado. utilizado normalmente para validação interna
	 * assert (var!=null) : "Erro encontrado"; (exemplo)  lança um AssertException
	 * if(var == null){
	 * 	throw new IllegalArgumentException();
	 * }
	 *  System.out.println(var);
	 *  para habilitar o assert:
	 *  configurações da JVM -ea (EnableAssert)
	 */
	
}
