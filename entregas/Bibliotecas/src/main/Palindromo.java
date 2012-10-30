
public class Palindromo {

	public static boolean testarPalindromo(String palavra){
		if(palavra == null){
			throw new IllegalArgumentException();
		}
		if(palavra.length() == 0){
			throw new IllegalArgumentException();
		}

		
		String resultado = null;
		resultado = gerarPalindromo(palavra);
		
		if(resultado == palavra){
			return true;
		}
		return false;
		
	}

	private static String gerarPalindromo(String palavra) {
		// TODO Auto-generated method stub
		return palavra;
	}
	
}
