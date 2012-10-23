package br.com.senacrs.alp.aulas.trabalho11;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class EmissorMensagens {

	File arquivo = null;
	String separador = "=";
	Map<String,String> mapa = new HashMap<String,String>();

	public EmissorMensagens(String nomeArquivo) {

		if (nomeArquivo == null) {
			throw new IllegalArgumentException("Valor Inválido");
		}
		arquivo = new File(nomeArquivo);
		if (!arquivo.exists() || arquivo.isDirectory()) {
			throw new IllegalArgumentException("Arquivo não existe.");
		}
		try {
			carregarArquivo();
		} catch (Exception x) {
			throw new IllegalArgumentException(x);
		}

	}

	public String formatarMensagem(String chave, Object... argumentos) {
		String linha = null;
		linha = mapa.get(chave);
		if(linha == null){
			throw new IllegalArgumentException();
		}

			
		for(int i = 1 ; i < argumentos.length ; i++){
			linha += " " +  argumentos[i];
		}
		
		
		return linha;
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
			mapa.put(idxVal[0],idxVal[1]);
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
	
	
}
