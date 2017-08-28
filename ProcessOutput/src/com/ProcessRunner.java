package com;

import java.io.IOException;

public class ProcessRunner {

	public static void main(String[] args) throws IOException {
				
		ProcessBuilder builder = new ProcessBuilder("sh", "C:\\Users\\shariq_iqbal\\workspace\\ReadProcessOutput\\ProcessOutput\\src\\com\\print.sh");		
		
		builder.redirectErrorStream(true); //make sure to call redirectErrorStream(true) on the process builder object so that the processes' error output gets megred with standard output 
		
		Process process = builder.start();
		
		ProcessOutputPrinter processOutputPrinter = new ProcessOutputPrinter();
		
		processOutputPrinter.printProcessOutput(process);
		
	}

}
