package com.cov.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cov.beans.Student;

public class App_08 {

	public static void main(String[] args) {
		// TODO Auto-generated method 
		ApplicationContext ctxt = new ClassPathXmlApplicationContext("spring.xml");
		Student student1 = (Student)ctxt.getBean("stud");
		System.out.println("Id: "+student1.getId()+", Name :"+student1.getName());
		

	}

}
