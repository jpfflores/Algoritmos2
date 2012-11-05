package br.com.senacrs.alp.aulas.trabalho12;

import java.io.File;

public class ProtocolHandler {

	private String port = null;
	private String root_dir = null;
	
	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getRootDir() {
		return root_dir;
	}

	public void setRootDir(String host) {
		this.root_dir = host;
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
		root_dir = arquivo2.GetConfiguration("root_dir");
		root_dir.replaceAll("/",File.pathSeparator);
		root_dir.replace(".", System.getProperty("user.dir"));
		
	}
	
	
}
