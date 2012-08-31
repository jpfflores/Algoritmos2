package br.com.senac.alp.aulas;

public class Nodo<Tipo extends Object> {
	private Tipo valor;
	private Nodo<Tipo> proximo = null;
	
	public void setProximo(Nodo<Tipo> left){
		this.proximo = left;
	}
	public Tipo getValor(){
		return this.valor;
	}
	public Nodo<Tipo> getProximo() {
		return this.proximo;
	}
	public void setValor(Tipo valor) {
		this.valor = valor;
	}
	public Nodo(Tipo valor){
		this.valor = valor;
	}
}
