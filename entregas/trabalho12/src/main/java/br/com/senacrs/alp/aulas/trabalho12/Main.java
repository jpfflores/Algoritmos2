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
		msg += Arrays.toString(args);
		System.out.println(msg);

		String configFile;
		configFile = args[1];
		Arquivo arq = null;
		ProtocolHandler protocol = null;

		try {
			arq = new Arquivo(configFile);
		} catch (IOException e) {
			System.out.println("ERRO");
			return;
		}
		try{
			protocol = new ProtocolHandler(arq);

		}catch(Exception ex){
			System.out.println("ERRO");
		}
		System.out.println("["+"]"+":");

		/*
		 * Output in standard output porta:root_dir ERRO
		 */
	}

}
