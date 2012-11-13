package br.com.senacrs.alp.aulas.trabalho12;

import java.io.File;
import java.util.Map;

public class ProtocolHandler {

	private int port = 0;
	// private String root_dir = null;
	private File root_dir = null;

	private String requisicao = null;

	private String resposta = null;

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

	public ProtocolHandler(Map<String, String> mapa)
			throws IllegalArgumentException {

		carregarConfiguracao(mapa);
	}

	private void carregarConfiguracao(Map<String, String> mapa)
			throws IllegalArgumentException {
		String pTemp = null;
		pTemp = mapa.get("port");
		try {
			port = Integer.parseInt(pTemp);
		} catch (NumberFormatException ex) {
			throw new IllegalArgumentException(ex);
		}

		String path = null;
		path = mapa.get("root_dir");
		path = path.replace(".", System.getProperty("user.dir"));

		path = corrigeSeparador(path);

		root_dir = new File(path);
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

	public void setRequisicao(String requisicao) throws IllegalArgumentException {
		this.requisicao = requisicao;
		validaRequisicao();
	}

	public String getRoot_dir() {
		return root_dir.toString();
	}

	private void validaRequisicao() {
		String inicio = "/";
		if (!requisicao.startsWith(inicio, 0)) {
			throw new IllegalArgumentException();
		}
		requisicao = corrigeSeparador(requisicao);
		String path = null;
		path = root_dir + requisicao;
		File file = null;
		file = new File(path);
		if (!file.exists()) {
			throw new IllegalArgumentException();
		}

		if (!file.isDirectory()) {
			resposta = "200 OK " + file.getAbsolutePath();
			return;
		}

		file = new File(path + "index.html");
		if (!file.exists()) {
			resposta = "404 NotFound";
		} else {
			resposta = "200 OK " + file.getAbsolutePath();
		}

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
		String resultado = null;

		/* Saida trabalho12a */
		// resultado = protocol.getPort() + ":" + protocol.getRoot_dir();

		/* Saída trabalho 12b */
		// resultado = protocol.getRoot_dir() + protocol.getRequisicao();
	}

}
