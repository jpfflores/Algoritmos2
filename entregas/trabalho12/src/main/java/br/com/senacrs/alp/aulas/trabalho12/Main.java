package br.com.senacrs.alp.aulas.trabalho12;


public class Main {
	public static void main(String[] args) {

		/*
		 * Recovering the configuration parameters At this moment we got only
		 * one parameter
		  	GET /index.html HTTP/1.1
			Host: www.exemplo.com => root_dir
			b)  print www.exemplo/index.html
				ERRO
		 */
		
		MainReal realmain = null;
		try{
			realmain = new MainReal(args);
			
		}catch(Exception ex ){
			System.out.println("ERRO");
		}
		

	}
	
	
}
