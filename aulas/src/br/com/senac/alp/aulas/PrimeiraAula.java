package br.com.senac.alp.aulas;



public class PrimeiraAula implements InterfacePrimeiraAula {
	
	private static PrimeiraAula instancia = new PrimeiraAula(); //atributo de classe
	
	
	private PrimeiraAula() {

		super();
	}
	
	public double somaTotal(double[] valores) {
		
		double resultado = 0.0;
		
		String val = new String("valor");
		if(val == "valor")
			return resultado;
		
		if (valores == null) {
			resultado = Double.NaN;
		}else 
		{
			for(int i = 0; i < valores.length;i++)
			{
					resultado += valores[i];
			}
		}
		
		return resultado;
	}
	
	public static PrimeiraAula getInstancia() {
		
		return PrimeiraAula.instancia;
	}
	

}
