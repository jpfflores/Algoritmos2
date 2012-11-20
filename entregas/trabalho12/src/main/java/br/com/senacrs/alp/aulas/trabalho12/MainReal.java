package br.com.senacrs.alp.aulas.trabalho12;


public class MainReal {

	public MainReal(String[] args) throws Exception {
		String resultado = null;

		if (args == null || args.length == 0 || args[0] == null
				|| args[1] == null || args[2] == null) {
			throw new IllegalArgumentException();
		}

		String configFile, getFile, targetFile;
		configFile = args[0];
		getFile = args[1];
		targetFile = args[2];

		Arquivo arq = null;
		ProtocolHandler protocol = null;
		protocol = new ProtocolHandler();

		try {
			
			arq = new Arquivo(configFile);
			protocol.carregarConfig(arq);
	
			arq = new Arquivo(getFile);
			String requisicao = null;
			protocol.carregarGet(arq);
	
			arq = new Arquivo(targetFile);
			
			protocol.carregarConfiguracao();
			resultado = protocol.getResposta();
	
			System.out.println(resultado);
			arq.escreveArquivo(resultado);
		} catch(IllegalArgumentException ex) {
			System.out.println("ERRO");
			throw new Exception(ex);
		}

	}

	void CriaConfig(String configFile) throws Exception {

	}

	void CriaGet(String getFile) throws Exception {

	}

}
