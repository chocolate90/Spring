package com.simple.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// 아래 어노테이션이 붙은 클래스를 component-scan이 읽어서 bean으로 생성한다.
@Controller
public class MainController {

	@RequestMapping("/")
	public String home() {
		
		System.out.println("실행!");
		
		return "home";
		//return "/WEB-INF/jsp/home.jsp";
	}
}
