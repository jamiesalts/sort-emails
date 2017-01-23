package com.jamiesalts.emailsort.app;

import java.io.FileNotFoundException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jamiesalts.emailsort.email.EmailAddress;

public class TestApp {

	private Application app;
	
	@Before
	public void before() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"services.xml"});
		try{
			app = (Application)context.getBean("application");
		}finally{
			context.close();
		}
	}
	
	@Test
	public void test() throws FileNotFoundException {
		// TODO: Use spring to search classpath instead
		List<EmailAddress> addresses = app.sortEmails(new String[]{"src\\test\\resources\\samples\\sample.txt"});
		
		// TODO: validate against sample.expected.txt to simplify
		assert(addresses.size() == 5);
		assert(addresses.get(0).getEmail().equals("abc@abc.com"));
		assert(addresses.get(1).getEmail().equals("rwq@abc.org"));
		assert(addresses.get(2).getEmail().equals("dave@gibson.com"));
		assert(addresses.get(3).getEmail().equals("joe@npr.org"));
		assert(addresses.get(4).getEmail().equals("cde@yahoo.com"));
	}

}
