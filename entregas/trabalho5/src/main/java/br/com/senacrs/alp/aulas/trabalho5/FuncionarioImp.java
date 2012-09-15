package br.com.senacrs.alp.aulas.trabalho5;

public class FuncionarioImp implements Funcionario, Pessoa{


	private String nome = null;

	private int salario = 0;
	
	public FuncionarioImp(String nome2, int salario) {
		// TODO Auto-generated constructor stub
		
		nome = nome2;
		this.salario = salario ;
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getSalario() {
		return salario;
	}

	public void setSalario(int salario) {
		this.salario = salario;
	}
	
	public String toString(){
		String ret = null;
		ret = "Nome: " + this.nome + " Salario: " + this.salario;
		return ret;
	}
	
}
