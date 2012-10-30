package br.com.senacrs.alp.aulas.sockets;
import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorMain {

	private final static String DIRETORIO_ENTRADA = System
			.getProperty("user.dir")
			+ File.separatorChar
			+ "mensagens"
			+ File.separatorChar;
	private final static String NOME_ARQUIVO_ENTRADA = "mensagens_pt.txt";
	
	public static void main(String[] args) {
		
		ServerSocket server = null;
		Socket socket = null;
		ManipuladorSocket obj = null;
		String line = null;
		Tradutor arquivo = null;
		arquivo = new Tradutor(DIRETORIO_ENTRADA+NOME_ARQUIVO_ENTRADA);
		String resposta;
		
		try {
			server = new ServerSocket(54321);
			socket = server.accept();
			obj = new ManipuladorSocket(socket);
			line = obj.receberTexto();
			//System.out.println(line);
			resposta = arquivo.Buscar(line);
			//obj.enviarTexto("OK");
			obj.enviarTexto(resposta);
			obj.finalizar();
		} catch (IOException e) {
			throw new IllegalArgumentException(e);
		} finally {
			closeSocket(socket);
			closeServer(server);
		}
	}

	private static void closeSocket(Socket socket) {

		if (socket != null) {
			try {
				socket.close();
			} catch (IOException e) {
				throw new IllegalStateException(e);
			}				
		}
	}

	private static void closeServer(ServerSocket server) {
		
		if (server != null) {
			try {
				server.close();
			} catch (IOException e) {
				throw new IllegalStateException(e);
			}							
		}
	}
}
