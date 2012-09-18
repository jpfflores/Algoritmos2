package br.com.senacrs.alp.aulas.trabalho6;

public interface Empresa {
	
	void adicionaFuncionario(Funcionario funcionario);
	
	Funcionario buscaFuncionario(String nome);
	
	int totalFolhaPgto();
}
