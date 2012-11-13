package br.com.senacrs.alp.aulas.trabalho12;


public class Main {
	public static void main(String[] args) {

		/*
		 * 
		 *  GET /index.html HTTP/1.1
			Host: www.exemplo.com => root_dir
			b)  print www.exemplo/index.html
				ERRO
				
			c) verificar se o arquivo de requisição existe
				- se a requisição for para um diretório, ou somente com uma barra, verificar se existe um index.html no diretório
				- 200 OK <caminho completo do arquivo> (se for diretorio, do index.html)
				- 404 Not Found
				- ERRO
		 */
		
		MainReal realmain = null;
		try{
			realmain = new MainReal(args);
			
		}catch(Exception ex ){
			System.out.println("ERRO");
		}
		

	}
	
	
}
