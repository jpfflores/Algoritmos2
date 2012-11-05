package br.com.senacrs.alp.aulas.trabalho12;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class Arquivo {
	private File arquivo = null;
	private String separador = "=";
	static String NEW_LINE = System.getProperty("line.separator");
	private Map<String,String> mapa = new HashMap<String,String>();
	
	FileInputStream input = null;
	FileOutputStream output = null;
	
	public FileInputStream getInput() {
		return input;
	}

	public FileOutputStream getOutput() {
		return output;
	}

	public void setOutput(FileOutputStream output) {
		this.output = output;
	}

	public void setInput(FileInputStream input) {
		this.input = input;
	}

	public File getArquivo() {
		return arquivo;
	}

	public void setArquivo(File arquivo) {
		this.arquivo = arquivo;
	}
	
	public Arquivo(String arq) throws IOException{
		
		try
		{
			arquivo = new File(arq);
			input = new FileInputStream(arquivo);
			System.out.println("Abriu o arquivo");
		}catch(FileNotFoundException fex){
			System.out.println("Falha ao abrir o arquivo");
		} finally {
			input.close();
		}
		
	}
	
	public Arquivo() {
	
	}

	public void fecharArquivo() throws IOException{
		if(arquivo.exists()){
			try {
				input.close();
			} catch (IOException e) {
				System.out.println("Falha ao fechar o arquivo");
				throw e;
			}
		}
	}
	
	
	public void carregarArquivo() throws Exception, IllegalArgumentException {
		String[] idxVal = new String[2];
		FileReader file = null;
		BufferedReader reader = null;
		String linha = null;

		file = new FileReader(arquivo);
		reader = new BufferedReader(file);
		linha = reader.readLine();
		while (linha != null) {
			if (!isLinhaValida(linha)) {
				throw new IllegalArgumentException("Valor Inválido");
			}
			idxVal = linha.split(separador, 2);
			System.out.println("Valor : " + idxVal[0] + " " + idxVal[1]);
			mapa.put(idxVal[0].trim(),idxVal[1].trim());
			linha = reader.readLine();
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
