import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class Arquivo {
	public File arquivo = null;

	static String NEW_LINE = System.getProperty("line.separator");
	
	FileInputStream input = null;
	FileOutputStream output = null;
	
	public FileInputStream getInput() {
		return input;
	}

	public FileOutputStream getOutput() {
		return output;
	}

	public void setOutput(FileOutputStream output) {
		this.output = output;
	}

	public void setInput(FileInputStream input) {
		this.input = input;
	}

	public File getArquivo() {
		return arquivo;
	}

	public void setArquivo(File arquivo) {
		this.arquivo = arquivo;
	}
	
	public Arquivo(String arq) throws IOException{
		
		try
		{
			arquivo = new File(arq);
			input = new FileInputStream(arquivo);
			System.out.println("Abriu o arquivo");
		}catch(FileNotFoundException fex){
			System.out.println("Falha ao abrir o arquivo");
		} finally {
			input.close();
		}
		
	}
	
	public Arquivo() {
		// TODO Auto-generated constructor stub
	}

	public void fecharArquivo() throws IOException{
		if(arquivo.exists()){
			try {
				input.close();
			} catch (IOException e) {
				System.out.println("Falha ao fechar o arquivo");
				throw e;
			}
		}
	}
	
	public void imprimirConteudo() throws IOException{
		int conteudo = 0;
		char letra ='\0';
		System.out.println("Tamanho " + this.input.available());
		conteudo = this.input.read();
		while(conteudo != -1 ){
			letra = (char) conteudo;
			System.out.print(letra);
		}
	}
	
	public void escreverConteudo(byte[] texto) throws IOException{
		System.out.println("Tamanho do texto " + texto.length);
		for(int i = 0; i < texto.length; i++){
			this.output.write(texto[i]);
		}
	}
}
