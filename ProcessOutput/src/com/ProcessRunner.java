package com;

import java.io.IOException;

public class ProcessRunner {

	public static void main(String[] args) throws IOException {
		
		ProcessBuilder builder = new ProcessBuilder("sh", "/Users/shariqiqbal/Documents/workspace/ProcessOutput/ProcessOutput/src/com/print.sh");
		Process process = builder.start();
		
		ProcessOutputPrinter processOutputPrinter = new ProcessOutputPrinter();
		
		processOutputPrinter.printProcessOutput(process);
		
	}

}
