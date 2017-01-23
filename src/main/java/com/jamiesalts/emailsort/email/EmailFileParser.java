package com.jamiesalts.emailsort.email;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

@Component
public class EmailFileParser extends FileParser {

	public List<EmailAddress> getEmails(String filePath) throws FileNotFoundException{
		List<EmailAddress> emails = getLines(filePath)
			.stream()
			.map(s -> new EmailAddress(s))
			.collect(Collectors.toList());
		
		return emails;
	}
}
