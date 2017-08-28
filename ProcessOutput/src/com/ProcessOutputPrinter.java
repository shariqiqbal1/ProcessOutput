package com;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ProcessOutputPrinter {
	
	public void printProcessOutput(Process process) {
	    
		Thread outThread = new Thread(() -> {
		    try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
	            while ((reader.readLine()) != null)
	                System.out.println(reader.readLine());
	        } catch (Exception e) {
	        }
		});
		outThread.start();

		int exitCode = -1;
		try {
		    exitCode = process.waitFor();
		    outThread.join();
		} catch (Exception e) {
		}
		
	}

}
