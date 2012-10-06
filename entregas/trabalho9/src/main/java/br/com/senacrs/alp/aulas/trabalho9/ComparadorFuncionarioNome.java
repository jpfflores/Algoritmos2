package br.com.senacrs.alp.aulas.trabalho9;

import java.util.Comparator;

public class ComparadorFuncionarioNome implements Comparator<Funcionario> {

	@Override
	public int compare(Funcionario arg0, Funcionario arg1) {

		// O compareTo não serve para comparadores com caracteres especiais ou acentuados
		
		int resultado = 0;
		resultado = arg0.getNome().compareToIgnoreCase(arg1.getNome());     
		if(resultado > 0){
			resultado = 1;
		} else if (resultado < 0){
			resultado = -1;
		}
		return resultado;
	}

}
