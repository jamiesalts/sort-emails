package com.jamiesalts.emailsort.email;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Component;

@Component
public class FileParser {
	public List<String> getLines(String filePath) throws FileNotFoundException{
		
		ArrayList<String> retVal = new ArrayList<String>();
		Scanner scanner = null;
		try {
			scanner = new Scanner(new File(filePath));
			while (scanner.hasNextLine()){
				retVal.add(scanner.nextLine());
			}
			scanner.close();
		} finally{
			if (scanner != null){
				scanner.close();
			}
		}
		return retVal;
	}
}
