package br.com.senac.alp.aulas;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinhaLista<String> lista = new MinhaListaImp<String>("inicio");
		System.out.println(lista.tamanho());
		System.out.println(lista.buscar(0));
		lista.prefixar("novoInicio");
		lista.sufixar("novoFim");
		System.out.println(lista.tamanho());
	}

}
