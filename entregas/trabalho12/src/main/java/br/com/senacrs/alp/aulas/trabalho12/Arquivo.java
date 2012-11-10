package br.com.senacrs.alp.aulas.trabalho12;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


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
