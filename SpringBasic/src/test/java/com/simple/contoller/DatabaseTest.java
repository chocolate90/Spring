package com.simple.contoller;

import java.sql.Connection;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

// 필요 스펙 - junit 4.12이상 spring-test 라이브러리 필요
@RunWith(SpringJUnit4ClassRunner.class) // was의 가동없이 클래스를 실행시켜준다.
@ContextConfiguration("file:src/main/webapp/WEB-INF/config/root-context.xml") // 해당 파일을 스프링 설정파일로 참조
public class DatabaseTest {

	@Autowired
	private DataSource dataSource;
	
	@Test // 해당 메서드를 실행
	public void test() {
		
		try {
			
			Connection conn = dataSource.getConnection();
			
			System.out.println(conn);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
