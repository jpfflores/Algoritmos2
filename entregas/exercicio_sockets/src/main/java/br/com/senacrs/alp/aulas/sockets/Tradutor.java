package br.com.senacrs.alp.aulas.sockets;

import br.com.senacrs.alp.aulas.trabalho11.EmissorMensagens;

public class Tradutor extends EmissorMensagens {

	public Tradutor(String nomeArquivo) {
		super(nomeArquivo);
		// TODO Auto-generated constructor stub
	}
	
	public String Buscar(String chave){
		String linha = null;
		linha = new String();
		linha = "";
		
		System.out.println(chave);
		linha = (String)super.getMapa().get(chave);
		
		return linha;

		
	}
	
}
