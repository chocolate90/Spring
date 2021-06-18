package com.simple.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.simple.command.ScoreVO;
import com.simple.dao.ScoreDAO;
import com.simple.mapper.ScoreMapper;

@Service("scoreService")
public class ScoreServiceImpl implements ScoreService {
	
//	@Autowired
//	@Qualifier("yyy")
//	private ScoreDAO scoreDAO;
	
	@Autowired
	private ScoreMapper scoreMapper;

	public void regist(ScoreVO vo) {
		
//		scoreDAO.regist(vo);
		
		// 1st 
		//scoreMapper.regist(vo);
		
		// 2nd - map
		HashMap<String, String> map = new HashMap<>();
		map.put("name", vo.getName());
		map.put("kor", vo.getKor());
		map.put("math", vo.getMath());
		
		scoreMapper.regist(map);
		
		
	}

	@Override
	public ArrayList<ScoreVO> getList() {
		
//		ArrayList<ScoreVO> list = scoreDAO.getList();
		
//		return scoreDAO.getList();
		
		return scoreMapper.getList();
	}

	@Override
	public void delete(int num) {
		
//		scoreDAO.delete(num);
		
		scoreMapper.delete(num);
	}
}
