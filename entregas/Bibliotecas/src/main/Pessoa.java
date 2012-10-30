
public class Pessoa {

	private String nome;
	
	private int idade;

	public Pessoa(String nome2, int idade2) {
		nome = nome2;
		idade = idade2;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	public String toString(){
		return "|" + nome +  "|" + idade;
		
	}
}
