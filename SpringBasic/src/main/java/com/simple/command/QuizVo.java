package com.simple.command;

public class QuizVo {

	private String year;
	private int month;
	private int day;
	
	public QuizVo() {
		
	}

	public QuizVo(String year, int month, int day) {
		super();
		this.year = year;
		this.month = month;
		this.day = day;
	}

	@Override
	public String toString() {
		return "QuizVo [year=" + year + ", month=" + month + ", day=" + day + "]";
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}
	
	
	
}
