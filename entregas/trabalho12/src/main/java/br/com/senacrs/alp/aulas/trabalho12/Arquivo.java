package br.com.senacrs.alp.aulas.trabalho12;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;


public class Arquivo extends File{
	
	
	public Arquivo(String arq){
		super(arq);
	}
	
	public void escreveArquivo(String conteudo){
		BufferedWriter bufferedWriter = null;
        
        try {
        	if(!this.exists()){
        		this.createNewFile();
        	}
            bufferedWriter = new BufferedWriter(new FileWriter(this));
            bufferedWriter.write(conteudo);
            
        } catch (IOException ex) {
            System.out.println("ERRO");
        } finally {
            //Close the BufferedWriter
            try {
                if (bufferedWriter != null) {
                    bufferedWriter.flush();
                    bufferedWriter.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

	}

}
