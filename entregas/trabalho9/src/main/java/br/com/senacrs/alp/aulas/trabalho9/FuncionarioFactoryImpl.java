package br.com.senacrs.alp.aulas.trabalho9;

import br.com.senacrs.alp.aulas.trabalho9.Funcionario;
import br.com.senacrs.alp.aulas.trabalho9.FuncionarioFactoryImpl;
import br.com.senacrs.alp.aulas.trabalho9.FuncionarioImp;

public class FuncionarioFactoryImpl implements FuncionarioFactory {	

	static private FuncionarioFactoryImpl instancia = null;
	
	public static FuncionarioFactoryImpl getInstancia() {
		if(instancia == null)
		{
			instancia = new FuncionarioFactoryImpl();
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
