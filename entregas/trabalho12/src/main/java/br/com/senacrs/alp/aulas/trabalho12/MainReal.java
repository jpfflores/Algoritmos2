package br.com.senacrs.alp.aulas.trabalho12;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MainReal {
	/* Commitando mesmo desatualizado */
	private Map<String, String> mapa = new HashMap<String, String>();
	static private String separador = "=";

	public MainReal(String[] args) throws Exception {
		String resultado = null;

		if (args == null || args.length == 0 || args[0] == null
				|| args[1] == null) {
			System.out.println("ERRO");
			throw new IllegalArgumentException();
		}

		String configFile, getFile;
		configFile = args[0];
		getFile = args[1];

		Arquivo arq = null;
		Arquivo arqGet = null;
		ProtocolHandler protocol = null;

		arq = new Arquivo(configFile);
		carregarConfig(arq);

		arq = new Arquivo(getFile);
		String requisicao = null;
		requisicao = carregarGet(arq);

		protocol = new ProtocolHandler(mapa);
		protocol.setRequisicao(requisicao);
		resultado = protocol.getResposta();

		System.out.println(resultado);

	}

	void CriaConfig(String configFile) throws Exception {

	}

	void CriaGet(String getFile) throws Exception {

	}

	public void carregarConfig(Arquivo arq) throws Exception {
		String[] idxVal = null;
		FileReader file = null;
		BufferedReader reader = null;
		String linha = null;
		File arquivo = null;
		arquivo = arq.getArquivo();
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
			mapa.put(idxVal[0].trim(), idxVal[1].trim());
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

	public String GetConfiguration(String parameter) {
		String result;
		result = mapa.get(parameter);
		return result;
	}

	private String carregarGet(Arquivo arq) throws IOException, IllegalArgumentException {
		String resultado = null;
		String[] idxVal = null;
		FileReader file = null;
		BufferedReader reader = null;
		String linha = null;
		File arquivo = null;
		arquivo = arq.getArquivo();
		try {
			file = new FileReader(arquivo);
		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException(e);
		}
		reader = new BufferedReader(file);
		linha = lerLinha(reader);
		idxVal = linha.split(" ");
		resultado = validaGet(idxVal);

		linha = lerLinha(reader);
		idxVal = linha.split(" ");
		validaHost(idxVal);
		
		return resultado;

	}

	private String validaGet(String[] args) throws IllegalArgumentException{
		String resultado = null;
		
		if(args.length!=3) {
			throw new IllegalArgumentException();
		}
		if(!args[0].equalsIgnoreCase("GET")){
			throw new IllegalArgumentException();
		}
		
		resultado = args[1];
		if(!args[2].equalsIgnoreCase("HTTP/1.1")){
			throw new IllegalArgumentException();
		}
		
		return resultado;
	}

	private void validaHost(String[] args) throws IllegalArgumentException {
		if(args.length!=2) {
			throw new IllegalArgumentException();
		}
		
		if (!args[0].equalsIgnoreCase("HOST:")) {
			throw new IllegalArgumentException();
		}
		
	}

	private String lerLinha(BufferedReader reader) throws IOException {
		String resultado = null;
		resultado = reader.readLine();
		return resultado;
	}
}
