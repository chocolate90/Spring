package ex07;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Computer {

	@Autowired
	@Qualifier("mu")
	private Mouse mu;
	@Autowired
	@Qualifier("kb")
	private Keyboard kb;
	@Autowired
	@Qualifier("mt")
	private Monitor mt;

	public void computerInfo() {
		System.out.println("***컴퓨터 정보***");
		mu.info();
		kb.info();
		mt.info();
	}
	
	
	
	
	
	
	
	
}
