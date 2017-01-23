package com.jamiesalts.emailsort.app;

import java.io.FileNotFoundException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {
        
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"services.xml"});
		try{
			Application app = (Application)context.getBean("application");
			app.start(args);
		}finally{
			context.close();
		}
		
	}

}
