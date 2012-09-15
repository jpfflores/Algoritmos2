package br.com.senacrs.alp.aulas.trabalho5;

public class FuncionarioFactoryImp implements FuncionarioFactory {

	static private FuncionarioFactoryImp instancia = null;
	@Override
	public Funcionario criaFuncionario(String nome, int salario) {
		// TODO Auto-generated method stub
		
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
