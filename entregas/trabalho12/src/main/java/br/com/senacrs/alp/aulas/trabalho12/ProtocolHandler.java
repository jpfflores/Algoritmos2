package br.com.senacrs.alp.aulas.trabalho12;

import java.io.File;

public class ProtocolHandler {

	private String port = null;
	//private String root_dir = null;
	private File root_dir = null;
	
	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	
	public void getRequisition(String req){
		return;
	}
	
	public void postRequisition(String req){
		return;
	}
	
	public ProtocolHandler(Arquivo arquivo)
	{
		carregarConfiguracao(arquivo);
	}

	private void carregarConfiguracao(Arquivo arquivo2) {
		port = arquivo2.GetConfiguration("port");
		String path = null;
		path = arquivo2.GetConfiguration("root_dir");
		path.replaceAll("/",File.pathSeparator);
		path.replace(".", System.getProperty("user.dir"));
		
	}
	
	
}
