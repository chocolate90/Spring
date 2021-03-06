package com.simple.contoller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.simple.test.mapper.TestMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/config/root-context.xml")
public class MybatisTest {

	// 1. 세션팩토리 빈 주입 확인
	@Autowired
	SqlSessionFactoryBean slqSessionFactory;
	
	// 2. mapper파일 주입
	@Autowired
	TestMapper testMapper;
	
	@Test
	public void MybatisTest1() {
		
		System.out.println("mybatis session factory bean:" + slqSessionFactory);
		
		System.out.println(testMapper.getTest());
		
	}
	
}
