package main.webapp;

import java.io.IOException;
import java.util.*;

/* Fontes:
 * http://alvinalexander.com/java/java-exec-processbuilder-process-3
 */

public class ProcessBuilderExample {

	public static void main(String[] args) {
		
//		CriacaoScriptExemplo exemplo = new CriacaoScriptExemplo();
//		exemplo.criarScript();
		
		try {
			new ProcessBuilderExample();
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
		
	}

	// can run basic ls or ps commands
	// can run command pipelines
	// can run sudo command if you know the password is correct
	public ProcessBuilderExample() throws IOException, InterruptedException {
		
		
		// build the system command we want to run
		List<String> commands = new ArrayList<String>();
		commands.add("/bin/sh");
		commands.add("-c");
		commands.add("ls -lah");
		
		// execute the command
		SystemCommandExecutor commandExecutor = new SystemCommandExecutor(commands);
		int result = commandExecutor.executeCommand();

		// get the stdout and stderr from the command that was run
		StringBuilder stdout = commandExecutor.getStandardOutputFromCommand();
		StringBuilder stderr = commandExecutor.getStandardErrorFromCommand();

		// print the stdout and stderr
		System.out.println("Resultado numérico do resultado: " + result);
		System.out.println("STDOUT:");
		System.out.println(stdout);
		System.out.println("STDERR:");
		System.out.println(stderr);
	}
}
