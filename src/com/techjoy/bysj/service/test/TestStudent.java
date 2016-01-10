package com.techjoy.bysj.service.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.techjoy.bysj.domain.Student;
import com.techjoy.bysj.service.StudentService;

public class TestStudent {
	StudentService studentService;
	@Before
	public void init(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationcontext.xml");
		studentService=(StudentService)ac.getBean("studentService");
		                                          
	}
	@Test
	public void save(){
		Student student=new Student("124");
		studentService.save(student);
	}
	@Test
	public void find(){
		Student student=studentService.findByName("name","124");
		System.out.println(student.getId());
	}
	@Test
	public void update(){
		Student student=studentService.find(1);
		student.setName("123");
		studentService.update(student);
		System.out.println(student.getName());
	}

}
