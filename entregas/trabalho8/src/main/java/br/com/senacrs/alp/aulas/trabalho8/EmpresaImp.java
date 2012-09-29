package br.com.senacrs.alp.aulas.trabalho8;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class EmpresaImp implements Empresa {

	private Map<String, Funcionario> funcionarios = null;
	
	public EmpresaImp(){
		this.funcionarios = new HashMap<String,Funcionario>();
	}
	
	@Override
	public void adicionaFuncionario(Funcionario funcionario) {
		
		if(funcionario == null){
			throw new IllegalArgumentException();
		}
		
		if(funcionario.getNome() == null){
			throw new IllegalArgumentException();
		}
		
		funcionarios.put(funcionario.getNome(),funcionario);
	}

	@Override
	public Funcionario buscaFuncionario(String nome) {
		Funcionario resposta = null;
		resposta = funcionarios.get(nome);
		
		return resposta;
	}

	@Override
	public int totalFolhaPgto() {
		
		int totalFolha = 0;
        Set<Map.Entry<String,Funcionario>> s= funcionarios.entrySet();

        Iterator<Map.Entry<String,Funcionario>> it= s.iterator();

        while(it.hasNext())
        {
        	Entry<String, Funcionario> ent =it.next();
        	FuncionarioImp funcionarioTemp = (FuncionarioImp)ent.getValue();
        	totalFolha += funcionarioTemp.getSalario();
		}
		return totalFolha;
	}

}
