package ex06;

import javax.annotation.Resource;

public class Printer2 {

	/*
	 * 자바 1.8 어노테이션
	 * @Resource -> 이름으로 찾아서 주입 이름이 없으면 타입으로 찾아서 주입 
	 * 
	 * Resource의 반객체 강제 연결은
	 * name속성을 이용하면 된다.
	 */
	
	@Resource(name="doc2")
	private Document document;
	
	public Printer2() {
		
	}
	
	public Printer2(Document document) {
		this.document = document;
	}

	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}
	
	
}
