package br.com.senacrs.alp.aulas.trabalho5;

import br.com.senacrs.alp.aulas.MinhaListaImp;


public class EmpresaImp implements Empresa{

	private MinhaListaImp<Funcionario> listaFuncionarios = null;
	
	public EmpresaImp()
	{
			listaFuncionarios = new MinhaListaImp<Funcionario>();
	}
	
	@Override
	public void adicionaFuncionario(Funcionario funcionario) {
		if(funcionario == null){
			throw new IllegalArgumentException();
		}
		System.out.println("Fucionario " +  funcionario.toString());
		listaFuncionarios.prefixar(funcionario);
		System.out.println("Número de funcionarios " +  listaFuncionarios.tamanho());
	}

	@Override
	public Funcionario buscaFuncionario(String nome) {
		
		FuncionarioImp func = null;
		
		for (int i = 0 ; i < listaFuncionarios.tamanho(); i++) {
			func = (FuncionarioImp) listaFuncionarios.buscar(i);
			if(func.getNome().equalsIgnoreCase(nome)){
				return func;
			}
				
		}
		
		return null;
	}

	@Override
	public int totalFolhaPgto() {
		
		FuncionarioImp func = null;
		int total = 0;
		System.out.println("Número de funcionario" +  listaFuncionarios.tamanho());
		for (int i = 0 ; i < listaFuncionarios.tamanho(); i++) {
			func = (FuncionarioImp) listaFuncionarios.buscar(i);
			System.out.println(func.toString());
			total += func.getSalario();
		}
				
		return total;
	}

	//private  listaFuncionarios = null;
}
