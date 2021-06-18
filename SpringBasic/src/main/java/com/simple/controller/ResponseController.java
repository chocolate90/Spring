package com.simple.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.simple.command.ReqVO;

@Controller
@RequestMapping("/response")
public class ResponseController {

	@RequestMapping("/res_ex01")
	public void res_ex01() {
		
	}
	
	// Model전달자 - 화면으로 전달할 데이터를 addAtrribute(키, 값)으로 전달
	@RequestMapping("/res_ex02")
	public String res_ex02(Model model) {
		
		model.addAttribute("serverTime", new Date());
		model.addAttribute("name", "홍길동");
		
		return "response/res_ex02";
	}
	
	// ModelAnaView 방법 - 데이터 addObject(키, 값), 화면정보 setViewName()
	
	@RequestMapping("/res_ex03")
	public ModelAndView res_ex03() {
		
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("serverTime", new Date() );
		mv.setViewName("response/res_ex03");
		
		return mv; // 디스패쳐 서블릿으로 반환
	}
	
	// @ModelAttribute 전달자 - @requestParam + Model
	
	@RequestMapping("/res_ex04")
	public String res_ex04(@ModelAttribute("id") String a) {
		
		System.out.println("넘어온 값:" + a);
		
		return "response/res_ex04";
	}
	
	// @ModelAttribute 여러값
	
	@RequestMapping("/res_ex05")
	public String res_ex05(@ModelAttribute("info") ReqVO vo) {
		
		System.out.println("넘어온 값: " + vo.toString());
		
		return "response/res_ex05";
	}
	
	//================================리다이렉트와 리다이렉트어트리뷰트============================
	
	//화면 처리
	
	@RequestMapping("res_redirect")
	public void res_redirect() {
		
	}
	
	@RequestMapping("/login")
	public String login(ReqVO vo,
						RedirectAttributes RA) {
		
		if(vo.getId().equals(vo.getPw())) {
			
			return "response/res_login_ok";
			
		} else {
			
			/*
			 * redirect:/ 절대경로 - 다시 컨트롤러를 타게한다.
			 * 이때 화면에 1회성 데이터로 값을 전달하고 싶다면
			 * RedirectAttribute객체의 addFlashAttribute를 이용한다. 
			 */
			
			
			
			RA.addFlashAttribute("msg", "아이디와 비밀번호를 확인하세요.");
			
			return "redirect:/response/res_redirect";
		}
		
	}
	
	@RequestMapping("/res_quiz01")
	public void res_quiz01() {
		
	}
	
	@RequestMapping("/res_login")
	public String res_login(@ModelAttribute("join") ReqVO vo) {
		
		if(vo.getId().equals("iu93") && vo.getPw().equals("1234")) {
			
			return "response/res_quiz01_ok";
			
		} else {
			
			
			return "response/res_quiz01_no";
		}
		
	}
	
}





































