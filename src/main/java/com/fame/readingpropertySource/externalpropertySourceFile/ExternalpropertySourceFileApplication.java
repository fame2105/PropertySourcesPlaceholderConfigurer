package com.fame.readingpropertySource.externalpropertySourceFile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.fame.readingpropertySource.externalpropertySourceFile.dataSource.FakeDataSource;
import com.fame.readingpropertySource.externalpropertySourceFile.dataSource.JMSDataSource;

@SpringBootApplication
public class ExternalpropertySourceFileApplication {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(ExternalpropertySourceFileApplication.class, args);
		FakeDataSource fakeDataSource = ctx.getBean(FakeDataSource.class);
		System.out.println("Hello There Everybody");
		System.out.println(fakeDataSource.getUser());
		System.out.println(fakeDataSource.getPassword());
		JMSDataSource jmsDataSource = ctx.getBean(JMSDataSource.class);
		System.out.println(jmsDataSource.getUserName());
		System.out.println(jmsDataSource.getPassword());
	}
}
