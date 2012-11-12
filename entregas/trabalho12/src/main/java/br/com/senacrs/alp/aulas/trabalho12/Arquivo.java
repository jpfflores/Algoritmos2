package br.com.senacrs.alp.aulas.trabalho12;
import java.io.File;


public class Arquivo {
	private File arquivo = null;
	
	public File getArquivo() {
		return arquivo;
	}

	public void setArquivo(File arquivo) {
		this.arquivo = arquivo;
	}
	
	public Arquivo(String arq) throws Exception{
		
		try
		{
			arquivo = new File(arq);
			if(!arquivo.exists()){
				throw new IllegalArgumentException();
			}
			if(arquivo.isDirectory()){
				throw new IllegalArgumentException();
			}
		}catch(Exception fex){
			throw new IllegalArgumentException(fex);
		}
		
	}
	
	public Arquivo() {
		
	}


}
