package com.simple.controller;



import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.simple.command.ReqVO;

@Controller
@RequestMapping("/request") // 클래스의 RequestMapping은 메서드의 요청경로를 묶어서 사용한다.
public class RequestController {

//	@RequestMapping("/req_ex01")
//	public String req_ex01() {
//		
//		System.out.println("실행됨");
//		
//		return "request/req_ex01";
//	}
	
	// void형 메서드는 들어오는 경로자체가 뷰 리졸버로 돌아가게 된다.
	@RequestMapping("/req_ex01")
	public void req_ex01() {
		
	}
	
//	// get방식
//	
//	@RequestMapping(value = "/basic01", method = RequestMethod.GET)
//	public void basic01() { 
//		System.out.println("basic01 실행됨");
//	}
//	
//	// post방식
//	
//	@RequestMapping(value = "/basic02", method = RequestMethod.POST)
//	public void basic02() {
//		System.out.println("basic02 실행됨");
//	}
//	
//	// 둘다
//
//	@RequestMapping(value = "basic03")
//	public void basic03() {
//		System.out.println("basic03 실행됨");
//	}
	
	// basic01, 02, 03을 하나의 메서드로 받아서 처리
	@RequestMapping({"basic01", "basic02", "basic03"})
	public void basic() {
		System.out.println("실행됨");
	}
	
	//================================요청파라미터값 받기======================================
	
	// req_ex02화면처리
	
	@RequestMapping("req_ex02")
	public String req_ex02() {
		
		return "request/req_ex02";
	}
	
	// param 요청처리
	// 1st - request객체 이용하기
	
//	@RequestMapping("/param")
//	public String param(HttpServletRequest request) {
//		
//		System.out.println(request.getParameter("id"));
//		
//		System.out.println(Arrays.toString(request.getParameterValues("inter")));
//		
//		return "request/req_ex02_result";
//	}
	
	// 2nd - 어노테이션 방법
	
//	@RequestMapping("/param")
//	public String param(@RequestParam("id") String id,
//						@RequestParam("pw") String pw,
//						@RequestParam("name") String name,
//						@RequestParam(value ="inter", required = false, defaultValue = "") ArrayList<String> inter) {
//		
//		System.out.println(id);
//		System.out.println(pw);
//		System.out.println(name);
//		System.out.println(inter.toString());
//		
//		return "request/req_ex02_result";
//	}
	
	// 3nd - 커맨드 객체를 이용하는 방법
	
	@RequestMapping("/param")
	public String param(ReqVO vo) {
		
		System.out.println(vo.toString());
		
		return "request/req_ex02_result";
	}
	
	// 문제
	
	@RequestMapping("/req_quiz01")
	public String req_quiz01() {
		return "request/req_quiz01";
	}
	
	@RequestMapping("/login")
	public String login(@RequestParam("id") String id,
						@RequestParam("pw") String pw) {
		
		if(id.equals("abc123") && pw.equals("xxx123")) {
			
			return "request/req_quiz01_ok";
		} else {
			
			return "request/req_quiz01_no";
		}
		
	}
	
}




















































