package ex01;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("application.xml");
		
		SpringTest t = (SpringTest)ctx.getBean("test");
		
		t.test();
		
		SpringTest t1 = (SpringTest)ctx.getBean("test");
		
		t1.test();
		
		System.out.println(t == t1);
		
	}
}
