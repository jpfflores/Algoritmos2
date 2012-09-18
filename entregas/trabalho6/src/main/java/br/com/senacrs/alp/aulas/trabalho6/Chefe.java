package br.com.senacrs.alp.aulas.trabalho6;


public class Chefe extends FuncionarioImp {

		public Chefe(String nome2, int salario) {
		super(nome2, salario);
		// TODO Auto-generated constructor stub
	}

		private Secretaria secretaria = null;

		public Secretaria getSecretaria() {
			return secretaria;
		}

		public void setSecretaria(Secretaria secretaria) {
			this.secretaria = secretaria;
		}
	

}
