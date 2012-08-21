package br.com.senac.alp.aulas;

public class MinhaListaImp<Tipo> implements MinhaLista<Tipo>{

	private Nodo<Tipo> inicio = null;
	
	public MinhaListaImp(Tipo valorinicio)
	{
		this.inicio = new Nodo<Tipo>(valorinicio);
	}
	
	private void setInicio(Nodo<Tipo> valor){
		this.inicio = valor;
	}
	
	private Nodo<Tipo> getInicio(){
		return this.inicio;
	}
	
	public void sufixar(Tipo valor) {
		// TODO Auto-generated method stub
		Nodo<Tipo> ultimo = ultimoElemento();
		Nodo<Tipo> novoUltimo = new Nodo<Tipo>(valor);
		ultimo.setProximo(novoUltimo);		
	}

	public void prefixar(Tipo valor) {
		// TODO Auto-generated method stub
		Nodo<Tipo> primeiro = buscarPrimeiroNodo();
		Nodo<Tipo> novoPrimeiro = new Nodo<Tipo>(valor);
		novoPrimeiro.setProximo(primeiro);
		setInicio(novoPrimeiro);		
	}

	public Tipo buscar(int pos) {
		// TODO Auto-generated method stub
		Nodo<Tipo> nodo = buscarNodo(pos);
		return nodo.getValor();
	}

	public void inserir(int pos, Tipo valor) {
		// TODO Auto-generated method stub
		Nodo<Tipo> nodoAnt = buscarNodo(pos -1);
		Nodo<Tipo> nodo = new Nodo<Tipo>(valor);
		Nodo<Tipo> velhoNodoPos = nodoAnt.getProximo();
		nodoAnt.setProximo(nodo);
		nodo.setProximo(velhoNodoPos);
	}

	public Tipo remover(int pos) {
		// TODO Auto-generated method stub
		Nodo<Tipo> nodoA = buscarNodo(pos -1);
		Nodo<Tipo> nodoB = nodoA.getProximo();
		Nodo<Tipo> nodoC = nodoB.getProximo();
		nodoA.setProximo(nodoC);
		return (Tipo) nodoB.getValor();
	}

	public int tamanho() {
		// TODO Auto-generated method stub
		int tamanho = 1;
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
		
		for (int i = 0; i < pos ; i++)
		{
			nodo = nodo.getProximo();
		}
		return nodo;
	}
	
	private Nodo<Tipo> buscarPrimeiroNodo()
	{
		Nodo<Tipo> resultado = getInicio();
		return resultado;
	}
	
}
