package br.com.senacrs.alp.aulas.trabalho12;

import java.io.File;

public class ProtocolHandler {

	private String port = null;
	private String host = null;
	
	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public void getRequisition(String req){
		return;
	}
	
	public void posRequisition(String req){
		return;
	}
	
	public ProtocolHandler(Arquivo arquivo)
	{
		carregarConfiguracao(arquivo);
	}

	private void carregarConfiguracao(Arquivo arquivo2) {
		port = arquivo2.GetConfiguration("port");
		host = arquivo2.GetConfiguration("host");
		host.replaceAll("/",File.pathSeparator);
		host.replace(".", System.getProperty("user.dir"));
		
	}
	
	
}
