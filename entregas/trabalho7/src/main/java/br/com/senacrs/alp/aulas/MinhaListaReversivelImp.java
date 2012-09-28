package br.com.senacrs.alp.aulas;


public class MinhaListaReversivelImp<Tipo> implements MinhaListaReversivel<Tipo> {

	private Nodo<Tipo> inicio = null;
	
	public MinhaListaReversivelImp() {
		
		this.inicio = new Nodo<Tipo>(null);
	}

	protected Nodo<Tipo> getInicio() {
		return inicio;
	}


	public void sufixar(Tipo valor) {

		Nodo<Tipo> ultimo = buscarUltimoNodo();
		Nodo<Tipo> novoUltimo = new Nodo<Tipo>(valor);
		if(tamanho() == 0){
			this.inicio.setProximo(novoUltimo);
			novoUltimo.setAnterior(this.inicio);
			return;
		}
			
		ultimo.setProximo(novoUltimo);
		novoUltimo.setAnterior(ultimo);
	}


	private Nodo<Tipo> buscarUltimoNodo() {
		
		int tamanho = tamanho();
		Nodo<Tipo> resultado = buscarNodo(tamanho-1);
		
		return resultado;
	}


	private Nodo<Tipo> buscarNodo(int posicao) {
		
		Nodo<Tipo> resultado = getInicio();
		
		for (int i = 0; i <= posicao; i++) {
			resultado = resultado.getProximo();
		}
				
		return resultado;
	}

	public void prefixar(Tipo valor) {
		
		Nodo<Tipo> primeiro = null;
		Nodo<Tipo> novoPrimeiro = null;
		
		novoPrimeiro = new Nodo<Tipo>(valor);
		if(tamanho() == 0 ){
			this.inicio.setProximo(novoPrimeiro);
			novoPrimeiro.setAnterior(this.inicio);
			return;
		}
		primeiro = this.inicio.getProximo();
				
		novoPrimeiro.setProximo(primeiro);
		this.inicio.setProximo(novoPrimeiro);
		novoPrimeiro.setAnterior(this.inicio);
		
	}

	public Tipo buscar(int posicao) {
		
		Nodo<Tipo> nodo = null;
		
		verificarPosicaoParaBuscar(posicao);
		nodo = buscarNodo(posicao);
		
		return nodo.getValor();
	}

	private void verificarPosicaoParaBuscar(int posicao) {
		
		int posicaoMaxima = 0;

		posicaoMaxima = this.tamanho() - 1;
		verificarPosicao(posicao, posicaoMaxima);
	}

	private void verificarPosicao(int posicao, int posicaoMaxima) {
		
		boolean posicaoValida = false;

		posicaoValida = posicaoDentroDeLimitesValidos(posicao, posicaoMaxima); 
		if (!posicaoValida) {
			throw new IndexOutOfBoundsException();
		}
	}

	private boolean posicaoDentroDeLimitesValidos(int posicao, int posicaoMaxima) {
		
		boolean resultado = false;
		
		resultado = (posicao >= 0) && (posicao <= posicaoMaxima);
		
		return resultado;
	}

	public void inserir(int posicao, Tipo valor) {

		Nodo<Tipo> antigo = null;
		Nodo<Tipo> anterior = null;
		Nodo<Tipo> nodo = null;
		
		if(this.tamanho() == 0) {
			nodo = new Nodo<Tipo>(valor);
			this.inicio.setProximo(nodo);
			nodo.setAnterior(this.inicio);
			return;
		}
		verificarPosicaoParaInserir(posicao);
		antigo = buscarNodo(posicao);
		anterior = antigo.getAnterior();
		nodo = new Nodo<Tipo>(valor);
		anterior.setProximo(nodo);
		nodo.setAnterior(anterior);
		nodo.setProximo(antigo);	
		antigo.setAnterior(nodo);
		
	}
	
	private void verificarPosicaoParaInserir(int posicao) {
		
		int posicaoMaxima = 0;

		posicaoMaxima = this.tamanho();
		verificarPosicao(posicao, posicaoMaxima);
	}

	public Tipo remover(int posicao) {
		
		Nodo<Tipo> anterior = null;
		Nodo<Tipo> nodo = null;
		Nodo<Tipo> proximo = null;
		
		verificarPosicaoParaBuscar(posicao);
		anterior = buscarNodo(posicao);
		nodo = anterior.getProximo();
		proximo = nodo.getProximo();
		anterior.setProximo(proximo);
		proximo.setAnterior(anterior);
		
		return nodo.getValor();
	}

	public int tamanho() {
		
		Nodo<Tipo> nodo = getInicio();
		int resultado = 0;

		while (nodo.getProximo() != null) {
			nodo = nodo.getProximo();
			resultado++;
		}
		
		return resultado;
	}
	
	@Override
	public String toString() {
		
		String resultado = null;
		Nodo<Tipo> nodo = null;
		
		resultado = this.getClass().getSimpleName() +  ":";
		nodo = this.inicio;
		while (nodo.getProximo() != null) {
			nodo = nodo.getProximo();
			resultado += nodo;
		}

		return resultado;
	}


	@Override
	public void reverter() {
		Nodo<Tipo> nodo = null;
		Nodo<Tipo> nodoPosterior = null;
		if(this.tamanho() == 0){
			return;
		}
		
		for(int i = 0 ; i < this.tamanho() ; i++) {
			nodo = buscarNodo(i);
			if(nodoPosterior == null){
				nodoPosterior = nodo;
				continue;
			}
			nodoPosterior.setAnterior(nodo);
			nodoPosterior = nodo;
		}
		this.inicio.setProximo(nodoPosterior);
		nodoPosterior.setAnterior(this.inicio);
	}

}
