package main.java.br.com.senac.alp.aulas;


public class PrimeiraAulaTestesEmMain {

	public static void main(String[] args){
		PrimeiraAula obj = null;
		obj = PrimeiraAula.getInstancia();
		testeComNull(obj);
		testComArgumentoVazio(obj);
		testComArgumentoArrayUnitario(obj);
		testComArgumentoArray(obj);
		
	}
	
	static public void testeComNull(InterfacePrimeiraAula obj)
	{
		double esperado = 0.0;
		double resultado = 0.0;

		resultado = obj.somaTotal(null);
		esperado = Double.NaN;
		if(Double.compare(resultado, esperado) == 0)
		{
			System.out.println("Teste com null: OK");
		}
		else
		{
			System.out.println("Teste com null: NOK");
		}
	}
	
	static public void testComArgumentoVazio(InterfacePrimeiraAula obj) {

		double[] valores = null;		
		double esperado = 0.0;
		double resultado = 0.0;
		
		valores = new double[0];
		resultado = obj.somaTotal(valores);
		if(Double.compare(resultado, esperado) == 0)
		{
			System.out.println("Teste com argumento vazio: OK");
		}
		else
		{
			System.out.println("Teste com argumento vazio: NOK");
		}		
	}

	static public void testComArgumentoArrayUnitario(InterfacePrimeiraAula obj) {

		double[] valores = null;		
		double esperado = 0.0;
		double resultado = 0.0;
		
		valores = new double[1];
		valores[0] = Math.random();
		esperado = valores[0];
		resultado = obj.somaTotal(valores);
		if(Double.compare(resultado, esperado) == 0)
		{
			System.out.println("Teste com array unitário: OK");
		}
		else
		{
			System.out.println("Teste com array unitário: NOK");
		}
				
	}

	static public void testComArgumentoArray(InterfacePrimeiraAula obj) {

		double[] valores = null;		
		double esperado = 0.0;
		double resultado = 0.0;
		
		valores = new double[10];
		for (int i = 0; i < valores.length; i++) {
			double val = Math.random();
			valores[i] = val;
			esperado += val;
		}
		resultado = obj.somaTotal(valores);
		if(Double.compare(resultado, esperado) == 0)
		{
			System.out.println("Teste com argumento array: OK");
		}
		else
		{
			System.out.println("Teste com argumento array: NOK");
		}
		
	}
}
