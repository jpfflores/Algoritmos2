package br.com.senac.alp.aulas;

public interface MinhaLista <Tipo extends Object> { //Generics, semelhante ao Template
	
	void sufixar(Tipo valor);
	void prefixar(Tipo valor);
	Tipo buscar(int pos);
	void inserir(int pos, Tipo valor);
	Tipo remover(int pos);
	int tamanho();
	
}
