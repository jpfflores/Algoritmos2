package br.com.senacrs.alp.aulas.trabalho13;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

public class ListaDiretorio {
	/*
	 * Parametro de entrada: uma String, caminho de um diretorio
	 * 
	 * Saida: Lista de Strings list:_<caminho completo de entrada> total:_<qtd
	 * de itens> <lista de itens ordenados> --> Primeiro os diretórios em ordem
	 * alfabética -->formato:d_<nome do dir> --> Segundo os arquivos em ordem
	 * alfabética -->formato:a_<nome do arquivo>
	 */
	private String m_Path = null;
	private File m_Diretorio = null;
	private int m_Tamanho = 0;

	public ListaDiretorio() {

	}

	public String[] listaConteudoDiretorio(String diretorio) {
		String[] resultado = null;
		ArrayList<String> diretorios = null;
		ArrayList<String> arquivos = null;
		validaDiretorio(diretorio);

		File listDir[] = m_Diretorio.listFiles();
		m_Tamanho = listDir.length;

		if (m_Tamanho == 0) {
			resultado = gerarListagemDiretorioVazio(listDir);
			return resultado;
		}
		diretorios = new ArrayList<String>();
		arquivos = new ArrayList<String>();
		for (int i = 0; i < listDir.length; i++) {
			if (listDir[i].isDirectory()) {
				diretorios.add("d " + listDir[i].getName());
			} else {
				arquivos.add("a " + listDir[i].getName());
			}
		}

		resultado = gerarListagemDiretorio(diretorios, arquivos);
		return resultado;
	}

	private void validaDiretorio(String dir) {
		if (dir == null) {
			throw new IllegalArgumentException();
		}
		File diretorio = null;
		diretorio = new File(dir);
		if (!diretorio.exists()) {
			throw new IllegalArgumentException();
		}
		if (!diretorio.isDirectory()) {
			throw new IllegalArgumentException();
		}

		m_Path = dir;
		m_Diretorio = new File(dir);
	}

	private String[] gerarListagemDiretorioVazio(File[] listDir) {
		String resultado[] = null;
		resultado = new String[2];
		resultado[0] = "list: " + m_Path;
		resultado[1] = "total: " + listDir.length;

		return resultado;
	}

	private String[] gerarListagemDiretorio(ArrayList<String> diretorios,
			ArrayList<String> arquivos) {

		String resultado[] = null;
		resultado = new String[(int) (2 + m_Tamanho)];
		resultado[0] = "list: " + m_Path;
		resultado[1] = "total: " + m_Tamanho;
		// Adicionando os diretorios
		adicionarEntidades(resultado, 2, diretorios);
		// Adicionando os arquivos
		adicionarEntidades(resultado, (2 + diretorios.size()), arquivos);

		return resultado;
	}

	private void adicionarEntidades(String[] resultado, int idx,
			ArrayList<String> entidades) {
		ordenandoEntidades(entidades);
		for (int i = 0; i < entidades.size(); i++) {
			resultado[idx] = entidades.get(i);
			idx++;
		}

	}

	private void ordenandoEntidades(ArrayList entidades) {
		CompararNomes compara = null;
		compara = new CompararNomes();
		Collections.sort(entidades, compara);
	}

}
