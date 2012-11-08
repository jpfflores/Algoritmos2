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
	private String separador = "=";
	static String NEW_LINE = System.getProperty("line.separator");
	private Map<String,String> mapa = new HashMap<String,String>();
	
	
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

	public void carregarArquivo() throws IllegalArgumentException {
		String[] idxVal = new String[2];
		FileReader file = null;
		BufferedReader reader = null;
		String linha = null;

		try {
			file = new FileReader(arquivo);
		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException(e);
		}
		reader = new BufferedReader(file);
		try {
			linha = reader.readLine();
		} catch (IOException e) {
			throw new IllegalArgumentException(e);
		}
		while (linha != null) {
			if (!isLinhaValida(linha)) {
				throw new IllegalArgumentException("Valor Inválido");
			}
			idxVal = linha.split(separador, 2);
			mapa.put(idxVal[0].trim(),idxVal[1].trim());
			try {
				linha = reader.readLine();
			} catch (IOException e) {
				throw new IllegalArgumentException(e);
			}
		}

	}
	
	public boolean isLinhaValida(String linha) {

		int count = 0;
		int pos = 1;
		do {
			pos = linha.indexOf(separador, pos);
			if (pos == -1) {
				break;
			}
			count++;
			pos += separador.length();
		} while (true);

		if (count == 1) {
			return true;
		} else {
			return false;
		}

	}
	
	public String GetConfiguration(String parameter){
		String result;
		result = mapa.get(parameter);
		return result;
	}
}
