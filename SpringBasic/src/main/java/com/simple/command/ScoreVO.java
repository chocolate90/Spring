package com.simple.command;

public class ScoreVO {

	private int bno;
	private String name;
	private String kor;
	private String math;
	
	public ScoreVO() {
	
	}

	public ScoreVO(int bno, String name, String kor, String math) {
		super();
		this.bno = bno;
		this.name = name;
		this.kor = kor;
		this.math = math;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKor() {
		return kor;
	}

	public void setKor(String kor) {
		this.kor = kor;
	}

	public String getMath() {
		return math;
	}

	public void setMath(String math) {
		this.math = math;
	}

	
	
	
	
}
