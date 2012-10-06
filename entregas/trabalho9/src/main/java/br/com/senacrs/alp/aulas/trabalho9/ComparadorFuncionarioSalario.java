package br.com.senacrs.alp.aulas.trabalho9;

import java.util.Comparator;

public class ComparadorFuncionarioSalario implements Comparator<Funcionario>{
	private int order; // 0 = crescente 1 = decrescente
	
	public ComparadorFuncionarioSalario(){
		order = 0;
	}
	
	public int compare(Funcionario arg0, Funcionario arg1) {
		int resultado = 0;
		resultado = arg0.getSalario() - arg1.getSalario();
		if(order == 0){
			if(resultado > 0){
				resultado = 1;
			} else if (resultado < 0){
				resultado = -1;
			}
			
		} else {
			if(resultado > 0){
				resultado = -1;
			} else if (resultado < 0){
				resultado = 1;
			}

		}
		
		return resultado;
		
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

}
