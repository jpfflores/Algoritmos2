package br.com.senacrs.alp.aulas.trabalho5;
import br.com.senac.alp.aulas.MinhaLista;
import br.com.senac.alp.aulas.MinhaListaImp;


public class EmpresaImp implements Empresa{

	@Override
	public void adicionaFuncionario(Funcionario funcionario) {
		MinhaLista<FuncionarioImp> lista = new MinhaListaImp<FuncionarioImp>();
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
