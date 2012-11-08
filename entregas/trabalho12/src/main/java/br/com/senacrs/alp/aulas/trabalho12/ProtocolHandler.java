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

	private void carregarConfiguracao(Arquivo arquivo2)  throws IllegalArgumentException{
		String pTemp = null;
		pTemp = arquivo2.GetConfiguration("port");
		try	{
			port = Integer.parseInt(pTemp);
		} catch(NumberFormatException ex){
			throw new IllegalArgumentException(ex);
		}
		
		String path = null;
		path = arquivo2.GetConfiguration("root_dir");
		path = path.replace(".", System.getProperty("user.dir"));
		
		String replace = "/";
		
		while(path.contains(replace)){
			path = path.replace(replace,File.separator);
		}
		
		root_dir = new File(path);
		if(!root_dir.exists()){
			System.out.println("Nao existe");
			throw new IllegalArgumentException();
		}
		
		if(!root_dir.isDirectory()){
			System.out.println("Não é diret´rorio");
			throw new IllegalArgumentException();
		}
		
	}

	public String getRoot_dir() {
		return root_dir.toString();
	}

		
	
}
