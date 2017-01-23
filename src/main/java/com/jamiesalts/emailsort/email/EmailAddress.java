package com.jamiesalts.emailsort.email;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailAddress {

	private String mailbox;
	private String domainName;
	private String email;
	
	public EmailAddress(String email){
		this.email = email;
		
		Pattern p = Pattern.compile("(.*)@(.*)");
		Matcher m = p.matcher(email);
		if (m.matches()){
			mailbox = m.group(1);
			domainName = m.group(2);
		}
	}
	
	public boolean isValid(){
		return mailbox != null && domainName != null && email != null;
	}
	
	public String getReverseDomainWithoutTLD(){
		String[] tokens = domainName.split("\\.");
		
		StringBuilder builder = new StringBuilder();
		for (int i = tokens.length - 2; i >= 0; i--){
			String token = tokens[i];
			
			if (i == 0){
				builder.append(token);
			}else{
				builder.append(token + ".");
			}
		}
		
		return builder.toString();
	}
	
	@Override
	public String toString(){
		return mailbox + "@" + domainName;
	}

	public String getMailbox() {
		return mailbox;
	}

	public String getDomainName() {
		return domainName;
	}

	public String getEmail() {
		return email;
	}
}
