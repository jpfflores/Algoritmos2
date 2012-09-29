package br.com.senacrs.alp.aulas.trabalho8;

public class FuncionarioFactoryImp implements FuncionarioFactory{

	static private FuncionarioFactoryImp instancia = null;
	
	public static FuncionarioFactoryImp getInstancia() {
		if(instancia == null)
		{
			instancia = new FuncionarioFactoryImp();
		}
		return instancia;
	}
	
	public Funcionario criaFuncionario(String nome, int salario){
		FuncionarioImp func = null;
		if(nome == null){
			throw new IllegalArgumentException();
		}
		
		if(nome == ""){
			throw new IllegalArgumentException();
		}
		
		if(salario < 0){
			throw new IllegalArgumentException();
		}
		
		func = new FuncionarioImp(nome,salario);
		return func;
	}
}
