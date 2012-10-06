package br.com.senacrs.alp.aulas.trabalho9;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import br.com.senacrs.alp.aulas.trabalho9.Funcionario;
import br.com.senacrs.alp.aulas.trabalho9.FuncionarioImp;

public class EmpresaImpl implements Empresa {

	private Map<String, Funcionario> funcionarios = null;
	


	public EmpresaImpl(){
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

	@Override
	public List<Funcionario> ordemCrescenteSalario() {
		LinkedList<Funcionario> lista = null;
		lista = new LinkedList<Funcionario>(funcionarios.values());
		ComparadorFuncionarioSalario compara = null;
		compara = new ComparadorFuncionarioSalario();
		Collections.sort(lista, compara);
		return lista;
	}

	@Override
	public List<Funcionario> ordemDecrescenteSalario() {
		LinkedList<Funcionario> lista = null;
		lista = new LinkedList<Funcionario>(funcionarios.values());
		ComparadorFuncionarioSalario compara = null;
		compara = new ComparadorFuncionarioSalario();
		compara.setOrder(1);
		Collections.sort(lista, compara);
		return lista;
	}

	@Override
	public List<Funcionario> ordemAlfabetica() {
		LinkedList<Funcionario> lista = null;
		lista = new LinkedList<Funcionario>(funcionarios.values());
		ComparadorFuncionarioNome compara = null;
		compara = new ComparadorFuncionarioNome();
		Collections.sort(lista, compara);
		return lista;
	}

}
