package com.team404.controller;

import java.util.ArrayList;
import java.util.HashMap;

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
import com.team404.util.Criteria;

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
	public HashMap<String, Object> getList(@PathVariable("bno") int bno,
										  @PathVariable("pageNum") int pageNum) {
		// 1st - 일반 댓글
//		ArrayList<FreeReplyVO> list = replyService.getList(bno);
//		System.out.println(list.toString());
//		
//		HashMap<String, Object> map = new HashMap<>();
//		map.put("list", list);
		
		// 2nd - 더보기 처리
		/*
		 * 1. 화면에 더보기 버튼 생성
		 * 2. getList(글번호, criteria)를 매개변수로 받는다.
		 * 3. mybatis 인터페이스에 글번호와 criteria를 @Param("")으로 다중값 처리.
		 * 4. sql 변경
		 * 5. 전체 댓글 수를 화면에 전달
		 */
		
		Criteria cri = new Criteria(pageNum, 20); // 20개씩 데이터 조회
		
		ArrayList<FreeReplyVO> list = replyService.getList(bno, cri);
		
		int total = replyService.getTotal(bno);
		
		HashMap<String, Object> map = new HashMap<>();
		map.put("list", list); // 댓글 목록
		map.put("total", total); // 전체 게시글 수
		
		return map;
	}
	
	// 수정 요청
	@PostMapping(value = "update", produces = "application/json")
	public int update(@RequestBody FreeReplyVO vo) {

		int count = replyService.pwCheck(vo);
		
		if(count == 1) { // 비밀번호가 일치
			
			return replyService.update(vo);
			
		} else { // 비밀번호가 일치하지 않기 때문에 실패 반환
			
			return 0;
			
		}

	}
	
	// 삭제 요청
	@PostMapping(value = "delete", produces = "application/json")
	public int delete(@RequestBody FreeReplyVO vo) {
		
		int count = replyService.pwCheck(vo);
		
		if(count == 1) {
			
			return replyService.delete(vo);
			
		} else {
			
			return 0;
			
		}
	
	}
	
}
