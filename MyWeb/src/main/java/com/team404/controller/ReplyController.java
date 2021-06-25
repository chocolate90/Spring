package com.team404.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team404.command.FreeReplyVO;
import com.team404.reply.service.ReplyService;

@RestController
@RequestMapping("reply")
public class ReplyController {

	
	@Autowired
	@Qualifier("replyService")
	private ReplyService replyService;
	
	@PostMapping(value = "/replyRegist", produces = "application/json") // contextPath/reply/replyRegist
	public int replyRegist(@RequestBody FreeReplyVO vo) {
		
		int result = replyService.regist(vo);
		
		return result;
	}
	
	//조회 메서드
	@GetMapping("/getList/{bno}/{pageNum}")
	public ArrayList<FreeReplyVO> getList(@PathVariable("bno") int bno,
										  @PathVariable("pageNum") int pageNum) {
		
		ArrayList<FreeReplyVO> list = replyService.getList(bno);
		System.out.println(list.toString());
		
		return list;
	}
	
}