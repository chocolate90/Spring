package com.simple.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.simple.command.QuizVO_02;
import com.simple.command.QuizVO_03;
import com.simple.command.QuizVo;

@Controller
@RequestMapping("/quiz")
public class QuizController {
	
	@RequestMapping("/quiz01")
	public void quiz01() {
		
	}
	
	@RequestMapping("/sendBirth")
	public String sendBirth(@ModelAttribute("date") QuizVo vo) {
		
		
		System.out.println(vo.getYear() + (vo.getMonth()<10? "0" + vo.getMonth() : vo.getMonth()) + (vo.getDay()<10? "0" + vo.getDay() : vo.getDay()));
		
		return "quiz/quiz01_ok";
	}
	
	@RequestMapping("/quiz02")
	public void quiz02() {
		
		
	}
	
	@RequestMapping("/join")
	public String join(@ModelAttribute("join") QuizVO_02 vo) {
		
		
		return "quiz/quiz02_ok";
	}
	
	@RequestMapping("/quiz03")
	public void quiz03() {
		
	}
	
	@RequestMapping("join2")
	public String join2(@ModelAttribute("signUp") QuizVO_03 vo,
					  RedirectAttributes ra) {
		
		if(vo.getId().equals("") ) {
			
			ra.addFlashAttribute("idNull", "아이디를 입력하세요");
			
			return "redirect:/quiz/quiz03";
			
		} else if(!vo.getPw().equals(vo.getPw_check())) {
			
			ra.addFlashAttribute("pwCheck", "비밀번호를 확인하세요");
			
			return "redirect:/quiz/quiz03";
		} else {
			
			return "quiz/quiz03_ok";
		}
		
		
	}
	

}
