package br.com.senacrs.alp.aulas.trabalho6;

import java.util.LinkedList;


public class EmpresaImp implements Empresa{

	private LinkedList<Funcionario> listaFuncionarios = null;
	
	public EmpresaImp()
	{
			listaFuncionarios = new LinkedList<Funcionario>();
	}
	
	public void adicionaFuncionario(Funcionario funcionario) {
		if(funcionario == null){
			throw new IllegalArgumentException();
		}
		System.out.println("Fucionario " +  funcionario.toString());
		listaFuncionarios.add(funcionario);
		System.out.println("Número de funcionarios " +  listaFuncionarios.size());
	}

	public Funcionario buscaFuncionario(String nome) {
		
		FuncionarioImp func = null;
		
		for (int i = 0 ; i < listaFuncionarios.size(); i++) {
			func = (FuncionarioImp) listaFuncionarios.get(i);
			if(func.getNome().equalsIgnoreCase(nome)){
				return func;
			}
				
		}
		
		return null;
	}

	public int totalFolhaPgto() {
		
		FuncionarioImp func = null;
		int total = 0;
		System.out.println("Número de funcionario" +  listaFuncionarios.size());
		for (int i = 0 ; i < listaFuncionarios.size(); i++) {
			func = (FuncionarioImp) listaFuncionarios.get(i);
			System.out.println(func.toString());
			total += func.getSalario();
		}
				
		return total;
	}

	//private  listaFuncionarios = null;
}
