package br.com.senacrs.alp.aulas.trabalho12;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {

		/*
		 * Recovering the configuration parameters At this moment we got only
		 * one parameter
		 */

		if(args == null || args.length == 0 || args[0] == null){
			System.out.println("ERRO");
			throw new IllegalArgumentException();
		}
		
		String configFile;
		configFile = args[0];
		Arquivo arq = null;
		ProtocolHandler protocol = null;

		try {
			arq = new Arquivo(configFile);
			arq.carregarArquivo();
		} catch (Exception e) {
			System.out.println("ERRO");
			throw new IllegalArgumentException(e);
		}
		
		try{
			protocol = new ProtocolHandler(arq);
			
			System.out.println("["+ protocol.getPort() + "]"+":" + protocol.getRoot_dir());
		}catch(Exception ex){
			System.out.println("ERRO");
			throw new IllegalArgumentException();
		}
		

		/*
		 * Output in standard output porta:root_dir ERRO
		 */
	}

}
