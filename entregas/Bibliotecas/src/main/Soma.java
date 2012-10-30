
public class Soma {

	public static int somaPares(int[] valores){
		
		if(verificaNulo(valores)){
			throw new IllegalArgumentException();
		}

		return somaValores(valores, 0);
	}
	
	public static int somaImpares(int[] valores){

		if(verificaNulo(valores)){
			throw new IllegalArgumentException();
		}
	
		return somaValores(valores, 1);
	
	}

	private static int somaValores(int[] valores, int inicio) {
		int soma = 0;
		for (int i= inicio ; i < valores.length ;i+=2){
			soma += valores[i];
		}
		return soma;
	}
	
	private static boolean verificaNulo(int[] valores){
		if(valores == null){
			return true;
		}
		return false;
		
	}
}
