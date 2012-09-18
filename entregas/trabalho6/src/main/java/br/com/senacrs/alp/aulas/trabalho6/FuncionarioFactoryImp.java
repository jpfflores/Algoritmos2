package br.com.senacrs.alp.aulas.trabalho6;

public class FuncionarioFactoryImp implements FuncionarioFactory {

	static private FuncionarioFactoryImp instancia = null;
	
	public Funcionario criaFuncionario(String nome, int salario) {

		
		if(nome == null){
			throw new IllegalArgumentException();
		}
		if(nome == ""){
			throw new IllegalArgumentException();
		}
		if(salario < 0){
			throw new IllegalArgumentException();
		}
		
		FuncionarioImp func = new FuncionarioImp(nome,salario);
		return func;
	}

	public static FuncionarioFactoryImp getInstancia() {
		// TODO Auto-generated method stub
		if(instancia == null)
		{
			instancia = new FuncionarioFactoryImp();
		}
		return instancia;
	}

	
}
