package ex04;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("application.xml");
		
		Car car = (Car)ctx.getBean("car");
		
		car.getBattery().energy();
		
		AirPlane air = (AirPlane)ctx.getBean("air");
		
		air.getBattery().energy();
		
	}
}
