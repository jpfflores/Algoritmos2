package br.com.senacrs.alp.aulas.trabalho12;

import java.io.File;

public class ProtocolHandler {

	private int port = 0;
	//private String root_dir = null;
	private File root_dir = null;
	
	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	
	public void getRequisition(String req){
		return;
	}
	
	public void postRequisition(String req){
		return;
	}
	
	public ProtocolHandler(Arquivo arquivo) throws IllegalArgumentException {
	
		carregarConfiguracao(arquivo);
	}

	private void carregarConfiguracao(Arquivo arquivo2)  throws IllegalArgumentException,NumberFormatException {
		System.out.println("Vai Carregar a Configuração.");
		String pTemp = null;
		
		pTemp = arquivo2.GetConfiguration("port");
		System.out.println("Port :" + pTemp);
		port = Integer.parseInt(pTemp);
			
		
		String path = null;
		path = arquivo2.GetConfiguration("root_dir");
		System.out.println(path);
		path.replaceAll("/",File.pathSeparator);
		path.replace(".", System.getProperty("user.dir"));
		System.out.println("Path alterado " + path);
		File arquivo = new File(path);
		if(!arquivo.isDirectory()){
			throw new IllegalArgumentException();
		}
		
		
	}

	public String getRoot_dir() {
		return root_dir.getPath();
	}

		
	
}
