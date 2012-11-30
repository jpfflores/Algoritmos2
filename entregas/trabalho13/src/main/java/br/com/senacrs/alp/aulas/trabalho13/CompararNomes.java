package br.com.senacrs.alp.aulas.trabalho13;


import java.util.Comparator;


public class CompararNomes implements Comparator<String>{

	public int compare(String arg0, String arg1) {
		int resultado = 0;
		resultado = arg0.compareToIgnoreCase(arg1);
		if(resultado > 0){
			resultado = 1;
		} else if (resultado < 0){
			resultado = -1;
		}
		return resultado;
	}

}
