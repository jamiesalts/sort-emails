package com.jamiesalts.emailsort.app;

import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jamiesalts.emailsort.email.EmailAddress;
import com.jamiesalts.emailsort.email.EmailFileParser;

@Component
public class Application {

	@Autowired
	private EmailFileParser emailFileParser;
	
	public List<EmailAddress> sortEmails(String[] args) throws FileNotFoundException{
		String filePath = args[0];
		List<EmailAddress> emails = emailFileParser.getEmails(filePath);
		
		// Compare by domain name, and then by mailbox
		emails.sort(new Comparator<EmailAddress>(){
			@Override
			public int compare(EmailAddress o1, EmailAddress o2) {
				// Undefined behavior for invalid email addresses
				if (!o1.isValid() || !o2.isValid()){
					return 0;
				}
				
				// Ignore TLD when sorting per requirements
				// Reverse domain to sort by domain before sub domains. 
				String o1Domain = o1.getReverseDomainWithoutTLD();
				String o2Domain = o2.getReverseDomainWithoutTLD();
				
				int retVal = o1Domain.compareTo(o2Domain);
				
				if (retVal == 0){
					retVal = o1.getMailbox().compareTo(o2.getMailbox());
				}
				
				return retVal;
			}
		});
		
		emails
			.stream()
			.filter(e -> e.isValid())
			.forEach(System.out::println);
		
		return emails;
	}
}
