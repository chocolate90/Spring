package ex08;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ex01.SpringTest;
import ex02.Chef;
import ex02.Hotel;
import ex03.DatabaseDev;
import ex03.MemberDAO;

/*
 * xml 설정 파일을 자바 파일로 사용하기.
 * 
 * Configuration이 붙은 클래스를 스프링 설정파일로 사용한다.
 */

@Configuration
public class JavaConfig {

	// @Bean을 이용해서 메서드를 컨테이너의 bean처럼 사용한다.
	
	// <bean id="test" class="ex01.SpringTest" />
	
	@Bean
	public SpringTest test() {
		
		return new SpringTest();
	}
	
	/*
	 	<bean id="chef" class="ex02.Chef"></bean>
	
		<bean id="hotel" class="ex02.Hotel">
			<constructor-arg ref="chef" />
		</bean>
	 */
	
	@Bean
	public Chef chef() {
		
		return new Chef();
	}
	
	@Bean
	public Hotel hotel() {
		
		return new Hotel(chef());
	}
	
	/*
	 	<bean id="dev" class="ex03.DatabaseDev">
			<property name="url" value="데이터베이스주소" />
			<property name="uid" value="데이터베이스아이디" />
			<property name="upw" value="데이터베이스비밀번호" />
		
		</bean>
	 */
	
	@Bean
	public DatabaseDev dev() {
		
		DatabaseDev dev = new DatabaseDev();
		dev.setUrl("DB주소");
		dev.setUid("아이디");
		dev.setUpw("비밀번홓");
		
		return dev;
	}
	
	/*
	 	<bean id="dao" class="ex03.MemberDAO">
			<property name="dev" ref="dev" />
		</bean>
	 */
	
	@Bean
	public MemberDAO dao() {

		MemberDAO dao = new MemberDAO();
		
		dao.setDev(dev());
		
		return dao;
	}
	

}
