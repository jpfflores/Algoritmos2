package br.com.senacrs.alp.aulas.trabalho12;

import java.io.IOException;

public class Main 
{
    public static void main( String[] args )
    {
        
    	/* Recovering the configuration parameters
    	 * At this moment we got only one parameter
    	 */
    	
    	String configFile;
    	configFile = args[1];
    	Arquivo arq = null;
    	ProtocolHandler protocol = null;
    	
    	try {
			arq = new Arquivo(configFile);
		} catch (IOException e) {
			System.out.println("Erro ao abrir o arquivo. Aplicação encerrada.");
			return;
		}
    	
    	protocol = new ProtocolHandler(arq);
    	
    	System.out.println( "Hello WWWorld! in " + protocol.getHost() + " na porta " + protocol.getPort());
    	/* Output in standard output
    	 * porta:root_dir
    	 * ERRO
    	 */
    }
    
}
