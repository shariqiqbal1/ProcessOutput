package com;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ProcessOutputPrinter {
	
	public void printProcessOutput(Process process) {
		Thread errThread = new Thread(() -> {
		    try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getErrorStream()))) {
		    	while ((reader.readLine()) != null)
	                System.out.println(reader.readLine());
		    } catch (Exception e) {
		    }
		});
		errThread.start();

		try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
			while ((reader.readLine()) != null)
                System.out.println(reader.readLine());
		} catch (Exception e) {
		}

		int exitCode = -1;
		try {
		    exitCode = process.waitFor();
		    errThread.join();
		} catch (Exception e) {
		}
		
	}

}
