package br.com.senacrs.alp.aulas.trabalho12;

import java.io.File;
import java.util.Map;

public class ProtocolHandler {

	private int port = 0;
	//private String root_dir = null;
	private File root_dir = null;
	
	private String requisicao = null;
	
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
	
	public ProtocolHandler(Map<String,String> mapa) throws IllegalArgumentException {
	
		carregarConfiguracao(mapa);
	}

	private void carregarConfiguracao(Map<String,String> mapa)  throws IllegalArgumentException{
		String pTemp = null;
		pTemp = mapa.get("port");
		try	{
			port = Integer.parseInt(pTemp);
		} catch(NumberFormatException ex){
			throw new IllegalArgumentException(ex);
		}
		
		String path = null;
		path = mapa.get("root_dir");
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

	public String getRequisicao() {
		return requisicao;
	}

	public void setRequisicao(String requisicao) {
		this.requisicao = requisicao;
	}

	public String getRoot_dir() {
		return root_dir.toString();
	}

	private boolean ValidaRequisicao(){
		return true;
	}
		
	
}
