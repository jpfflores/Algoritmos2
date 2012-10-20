package br.com.senacrs.alp.aulas.trabalho10;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.LinkedList;

public class GerenciadorDeArquivo {

	public File arquivo = null;
	
	public GerenciadorDeArquivo(String nomeArquivo) {
		

		if(nomeArquivo == null){
			throw new IllegalArgumentException();
		}
		arquivo = new File(nomeArquivo);
		if(arquivo.isDirectory()){
			throw new IllegalArgumentException();
		}
		
	}

	public String[] lerArquivo() throws IllegalArgumentException {

		
		LinkedList<String> linhas = new LinkedList<String>();
		String linha = new String();
		BufferedReader reader = null;
		FileReader file = null;
		if(!arquivo.exists()){
			throw new IllegalArgumentException();
		}
		try{
			file = new FileReader(arquivo);
			reader = new BufferedReader(file);
			linha = reader.readLine();
			while(linha!= null){
				linhas.add(linha);
				linha = reader.readLine();
			}
		}catch(Exception ex){
			return null;
		}
		String [] texto = null;
		texto = new String[linhas.size()];
		for(int i = 0 ; i < linhas.size(); i++){
			texto[i] = linhas.get(i);
		}
		return texto;
	}

	public String[] lerArquivoComSubstituicao(String lido, String retornado) {

		String[] texto = lerArquivo();
		for(int i = 0 ; i < texto.length;i++){
			texto[i] = texto[i].replace(lido, retornado);
		}

		return texto;
	}

	public void escreverArquivo(String[] conteudo) {

		String texto = null;
		BufferedWriter writer = null;
		FileWriter file = null;
		try{
			file = new FileWriter(arquivo);
			writer = new BufferedWriter(file);
					
			for(int i = 0 ; i< conteudo.length; i++){
				System.out.println(conteudo[i].toString());
				texto = conteudo[i];
				writer.write(texto);
				writer.newLine();
				writer.flush();
			}		
		}catch (Exception ex){
			System.out.println("Erro ao escrever no arquivo.");
		}
		
	}
}
