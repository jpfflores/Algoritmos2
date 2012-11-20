package br.com.senacrs.alp.aulas.trabalho12;


public class Main {
	public static void main(String[] args) {

		/*
		 * 
		 *  a) 	GET /index.html HTTP/1.1
				Host: www.exemplo.com => root_dir
				
			b)  print www.exemplo/index.html
				ERRO
				
			c) 	verificar se o arquivo de requisição existe
				- se a requisição for para um diretório, ou somente com uma barra, verificar se existe um index.html no diretório
				- 200 OK <caminho completo do arquivo> (se for diretorio, do index.html)
				- 404 Not Found
				- ERRO
				
			d) terceiro argumento - arquivo saída 200 | 404
				- formatar o arquivo conforme o padrão
					- respota
					- cabeçalho
					- conteúdo do arquivo html
					-------------------------------------
					HTTP/1.0 200 OK ou 404 NotFound
					Date: <data em GMT-0>
					Server: <alguma coisa>
					Content-length: <tamanho em bytes>
					Content-type: text/html; charset-utf8
					Connection: close
					-- linha em branco -- 
					<conteúdo>  Verificar o tamanho do conteúdo, pois é Content-length. No caso de 404 o valor é zero.
		 */
		
		MainReal realmain = null;
		try{
			realmain = new MainReal(args);
			
		}catch(Exception ex ){
			
		}
		

	}
	
	
}
