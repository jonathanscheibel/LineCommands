package main.webapp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CriacaoScriptExemplo {

	final static String meuArquivo = "/home/jonathan/meuArquivo2.txt";

	public void criarScript() {
		escreverArquivo();
		atribuirPermissao(meuArquivo);
	}

	private static void escreverLinha(String linha) throws IOException, InterruptedException {
		List<String> commands = new ArrayList<String>();
		commands.add("/bin/sh");
		commands.add("-c");
		commands.add("echo " + linha + " >> " + meuArquivo);		

		SystemCommandExecutor commandExecutor = new SystemCommandExecutor(commands);
		commandExecutor.executeCommand();
	}

	private static void executarComando(String comando) throws IOException, InterruptedException {
		List<String> commands = new ArrayList<String>();
		commands.add("/bin/sh");
		commands.add("-c");
		commands.add(comando);

		SystemCommandExecutor commandExecutor = new SystemCommandExecutor(commands);
		commandExecutor.executeCommand();
	}
	
	private static void escreverArquivo() {
		try {
			escreverLinha("Minha linha aqui");
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	private static void atribuirPermissao(String file) {
		try {
			executarComando("chmod 777 " + file);
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
}
