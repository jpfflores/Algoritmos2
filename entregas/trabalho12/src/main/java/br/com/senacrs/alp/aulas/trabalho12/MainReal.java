package br.com.senacrs.alp.aulas.trabalho12;

public class MainReal {

	public MainReal(String[] args) throws Exception {
		String resultado = null;
		/* Testando a existência de todos os parâmetros */
		if (args == null || args.length == 0 || args[0] == null
				|| args[1] == null || args[2] == null) {
			throw new IllegalArgumentException();
		}

		String configFile, getFile, exitFile;
		configFile = args[0];
		getFile = args[1];
		exitFile = args[2];

		Arquivo arq = null;
		ProtocolHandler protocol = null;
		protocol = new ProtocolHandler();

		try {

			arq = new Arquivo(configFile);
			protocol.carregarConfig(arq);
			protocol.carregarConfiguracao();

			arq = new Arquivo(getFile);
			protocol.carregarGet(arq);
			protocol.carregarExit(exitFile);
			protocol.gerarResposta();
			
		} catch (IllegalArgumentException ex) {
			System.out.println("ERRO");
			throw new Exception(ex);
		}

	}

}
