package br.com.senacrs.alp.aulas.trabalho12;

import java.io.IOException;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) {

		/*
		 * Recovering the configuration parameters At this moment we got only
		 * one parameter
		 */

		String msg = null;
		msg = "Argumentos: ";
		
		if(args == null || args.length == 0 || args[0] == null){
			System.out.println("ERRO");
			throw new IllegalArgumentException();
		}
		
		msg += Arrays.toString(args);
		System.out.println(msg);

		String configFile;
		configFile = args[0];
		System.out.println("Parametro de entrada: " + configFile);
		Arquivo arq = null;
		ProtocolHandler protocol = null;

		try {
			arq = new Arquivo(configFile);
			arq.carregarArquivo();
		} catch (IOException e) {
			System.out.println("ERRO");
			return;
		} catch (IllegalArgumentException ex) {
			System.out.println("ERRO");
			return;
		}
		try{
			protocol = new ProtocolHandler(arq);
			

		}catch(Exception ex){
			System.out.println("ERRO");
		}
		System.out.println("["+ protocol.getPort() + "]"+":" + protocol.getRoot_dir());

		/*
		 * Output in standard output porta:root_dir ERRO
		 */
	}

}
