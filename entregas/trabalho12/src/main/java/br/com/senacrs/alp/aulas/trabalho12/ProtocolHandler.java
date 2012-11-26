package br.com.senacrs.alp.aulas.trabalho12;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

public class ProtocolHandler {

	private int port = 0;
	// private String root_dir = null;
	private Arquivo root_dir = null;
	static private String separador = "=";

	private String requisicao = null;

	private String resposta = null;
	private boolean encontrado = false;
	private String conteudo = null;
	private Map<String, String> mapa = new HashMap<String, String>();
	private Arquivo target = null;

	private Arquivo saida = null;
	
	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public void getRequisition(String req) {
		return;
	}

	public void postRequisition(String req) {
		return;
	}

	public ProtocolHandler() {

	}

	public void carregarConfiguracao() throws IllegalArgumentException {
		String pTemp = null;
		pTemp = mapa.get("port");
		try {
			port = Integer.parseInt(pTemp);
		} catch (NumberFormatException ex) {
			throw new IllegalArgumentException(ex);
		}

		String path = null;
		path = mapa.get("root_dir");
		if (path == null) {
			throw new IllegalArgumentException();
		}
		if (!path.startsWith(".", 0)) {
			throw new IllegalArgumentException();
		}

		path = path.replace(".", System.getProperty("user.dir"));

		path = corrigeSeparador(path);

		root_dir = new Arquivo(path);
		if (!root_dir.exists()) {
			throw new IllegalArgumentException();
		}

		if (!root_dir.isDirectory()) {
			System.out.println("Não é diretório");
			throw new IllegalArgumentException();
		}

	}

	public String getRequisicao() {
		return requisicao;
	}

	public void setRequisicao(String requisicao)
			throws IllegalArgumentException {
		this.requisicao = requisicao;
	}

	public String getRoot_dir() {
		return root_dir.toString();
	}

	private String corrigeSeparador(String endereco) {

		String replace = "/";

		while (endereco.contains(replace)) {
			endereco = endereco.replace(replace, File.separator);
		}
		return endereco;
	}

	public String getResposta() {
		return resposta;
	}

	public void gerarResposta() {
		String resultado = "";

		/* Saida trabalho12a */
		// resultado = protocol.getPort() + ":" + protocol.getRoot_dir();

		/* Saída trabalho 12b */
		// resultado = protocol.getRoot_dir() + protocol.getRequisicao();

		// Construindo o cabeçalho

		gerarConteudo();
		resultado += "HTTP/1.0 " + resposta + '\n';
		resultado += "Date: " + gerarData() + "\n";
		resultado += "Server: Cris-Jose.edu \n";
		if (encontrado && conteudo != null) {
			resultado += "Content-Length: " + conteudo.length() + " \n";
		} else {
			resultado += "Content-Length: 0 \n";
		}
		resultado += "Content-type: text/html; charset-utf-8 \n";
		resultado += "Connection: close \n \n";
		resposta = resultado + conteudo;
		saida.escreveArquivo(resposta);

	}

	public String gerarData() {
		// Mon, 23 May 2005 22:38:34 GMT e.g.

		String resultado = null;
		Date data = null;
		SimpleDateFormat formatador = null;

		data = new Date();
		formatador = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z",
				Locale.getDefault());
		formatador.setTimeZone(TimeZone.getTimeZone("GMT"));
		resultado = formatador.format(data);
		return resultado;

	}

	public void carregarConfig(Arquivo arquivo) throws Exception {
		String[] idxVal = null;
		FileReader file = null;
		BufferedReader reader = null;
		String linha = null;
		if (!arquivo.exists() || arquivo.isDirectory()) {
			throw new IllegalArgumentException();
		}
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

	private String lerLinha(BufferedReader reader) throws IOException {
		String resultado = null;
		resultado = reader.readLine();
		return resultado;
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

	public void carregarGet(Arquivo arquivo) throws IOException,
			IllegalArgumentException {
		String resultado = null;
		String[] idxVal = null;
		FileReader file = null;
		BufferedReader reader = null;
		String linha = null;
		if (!arquivo.exists() || arquivo.isDirectory()) {
			throw new IllegalArgumentException();
		}

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

		requisicao = resultado;
		validaRequisicao();

	}

	private void validaHost(String[] args) throws IllegalArgumentException {
		if (args.length != 2) {
			throw new IllegalArgumentException();
		}

		if (!args[0].equalsIgnoreCase("HOST:")) {
			throw new IllegalArgumentException();
		}

	}

	public static String validaGet(String[] args)
			throws IllegalArgumentException {
		String resultado = null;

		if (args.length != 3) {
			throw new IllegalArgumentException();
		}
		if (!args[0].equalsIgnoreCase("GET")) {
			throw new IllegalArgumentException();
		}

		resultado = args[1];
		if (!args[2].equalsIgnoreCase("HTTP/1.1")) {
			throw new IllegalArgumentException();
		}

		return resultado;
	}

	private void validaRequisicao() {
		String inicio = "/";
		if (!requisicao.startsWith(inicio, 0)) {
			throw new IllegalArgumentException();
		}

		requisicao = corrigeSeparador(requisicao);
		String path = null;
		path = root_dir.getPath() + requisicao;
		Arquivo file = null;
		file = new Arquivo(path);
		if (!file.exists()) {
			resposta = "404 NotFound";
			encontrado = false;
			return;
		}

		if (!file.isDirectory()) {
			resposta = "200 OK ";
			encontrado = true;
			target = file;
			return;
		}

		file = new Arquivo(path + "index.html");
		if (!file.exists()) {
			resposta = "404 NotFound";
			encontrado = false;
		} else {
			resposta = "200 OK ";
			encontrado = true;
		}
		target = file;
	}

	public void carregarExit(String trg) {
		trg = root_dir.getPath() + File.separator + trg;
		saida = new Arquivo(trg);

		
	}
	
	private void gerarConteudo(){
		if(!encontrado){
			conteudo = "";
			return;
		}
		LinkedList<String> linhas = new LinkedList<String>();
		String linha = new String();
		BufferedReader reader = null;
		FileReader file = null;
		try{
			file = new FileReader((File)target);
			reader = new BufferedReader(file);
			linha = reader.readLine();
			while(linha!= null){
				linhas.add(linha);
				linha = reader.readLine();
			}
		}catch(Exception ex){
			throw new IllegalArgumentException();
		}
		conteudo = "";
		
		for(int i = 0 ; i < linhas.size(); i++){
			conteudo += linhas.get(i) + "\n";
		}
		
	}
}
