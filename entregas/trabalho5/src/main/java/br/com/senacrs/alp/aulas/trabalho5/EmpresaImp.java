package br.com.senacrs.alp.aulas.trabalho5;
import br.com.senacrs.alp.aulas.MinhaLista;
import br.com.senacrs.alp.aulas.MinhaListaImp;


public class EmpresaImp implements Empresa{

	@Override
	public void adicionaFuncionario(Funcionario funcionario) {
		MinhaLista<Funcionario> lista = new MinhaListaImp<Funcionario>();
		lista.sufixar(funcionario);
	}

	@Override
	public Funcionario buscaFuncionario(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int totalFolhaPgto() {
		// TODO Auto-generated method stub
		return 0;
	}

	//private  listaFuncionarios = null;
}
