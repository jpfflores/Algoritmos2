package br.com.senac.alp.aulas;


public class MinhaListaImp<Tipo> implements MinhaLista<Tipo>{

	private Nodo<Tipo> inicio = null;
	
	public MinhaListaImp()
	{
		Tipo obj = (Tipo) new Object();
		this.inicio = new Nodo<Tipo>(obj);
		
	}
	
	public MinhaListaImp(Tipo valorinicio)
	{
		if(valorinicio == null){
			throw new IllegalArgumentException();
		}
		
		Tipo obj = (Tipo) new Object();
		this.inicio = new Nodo<Tipo>(obj);
		
		Nodo<Tipo> nodo = new Nodo<Tipo>(valorinicio);
		this.inicio.setProximo(nodo);
			
	}
	/*
	protected void setInicio(Nodo<Tipo> valor){
		this.inicio = valor;
	}
	*/
	
	protected Nodo<Tipo> getInicio(){
		return this.inicio;
	}
	
	public void sufixar(Tipo valor) {
		Nodo<Tipo> ultimo = ultimoElemento();
		Nodo<Tipo> novoUltimo = new Nodo<Tipo>(valor);
		ultimo.setProximo(novoUltimo);		
	}

	public void prefixar(Tipo valor) {
		Nodo<Tipo> primeiro = buscarPrimeiroNodo();
		Nodo<Tipo> novoPrimeiro = new Nodo<Tipo>(valor);
		Nodo<Tipo> fantasma = getInicio();
		if(primeiro != null){
			novoPrimeiro.setProximo(primeiro);
		}
		fantasma.setProximo(novoPrimeiro);		
	}

	public Tipo buscar(int pos) {
		Nodo<Tipo> nodo = buscarNodo(pos);
		return nodo.getValor();
	}

	public void inserir(int pos, Tipo valor) {
		Nodo<Tipo> nodoAnt = buscarNodo(pos -1);
		Nodo<Tipo> nodo = new Nodo<Tipo>(valor);
		Nodo<Tipo> velhoNodoPos = nodoAnt.getProximo();
		nodoAnt.setProximo(nodo);
		nodo.setProximo(velhoNodoPos);
	}

	public Tipo remover(int pos) {
		Nodo<Tipo> nodoA = buscarNodo(pos -1);
		Nodo<Tipo> nodoB = nodoA.getProximo();
		Nodo<Tipo> nodoC = nodoB.getProximo();
		nodoA.setProximo(nodoC);
		return (Tipo) nodoB.getValor();
	}

	public int tamanho() {
		int tamanho = 0;
		Nodo<Tipo> nodo = this.getInicio();
		while(nodo.getProximo()!= null)
		{
			nodo = nodo.getProximo();
			tamanho++;
		}
		return tamanho;
	}

	private Nodo<Tipo> ultimoElemento(){
		int ultimaPos = tamanho() -1;
		Nodo<Tipo> ultimo = buscarNodo(ultimaPos);
		return ultimo;
	}
	
	private Nodo<Tipo> buscarNodo(int pos){
		Nodo<Tipo> nodo = getInicio();
		if(nodo.getProximo() == null){
			throw new IndexOutOfBoundsException("Lista vazia.");
		}
		if(pos > tamanho()){
			throw new IndexOutOfBoundsException("Posição maior que o tamanho da Lista");
		}
		for (int i = 0; i < pos ; i++)
		{
			nodo = nodo.getProximo();
		}
		return nodo;
	}
	
	private Nodo<Tipo> buscarPrimeiroNodo()
	{
		Nodo<Tipo> resultado = this.inicio.getProximo();
		return resultado;
	}
	
}
