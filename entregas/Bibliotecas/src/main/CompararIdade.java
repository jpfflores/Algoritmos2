import java.util.Comparator;


public class CompararIdade implements Comparator<Pessoa>{

	public int compare(Pessoa o1, Pessoa o2) {
		int resultado = 0;
		resultado = o1.getIdade() - o2.getIdade();
		if(resultado > 0){
			resultado = 1;
		} else if (resultado < 0){
			resultado = -1;
		}
		return resultado;
	}

}
