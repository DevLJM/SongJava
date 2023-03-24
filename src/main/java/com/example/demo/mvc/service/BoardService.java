package com.example.demo.mvc.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mvc.domain.Board;
import com.example.demo.mvc.parameter.BoardParameter;
import com.example.demo.mvc.repository.BoardRepository;

/**
 * 게시판 서비스
 * @author tr2user
 *
 */
@Service
public class BoardService {
	
	@Autowired
	private BoardRepository repository;
	
	/**
	 * 등록 리턴
	 * @return
	 */
	public List<Board> getList() {
		return repository.getList();
	}
	
	/**
	 * 상세정보 리턴
	 * @return
	 */
	public Board get(int boardSeq) {
		return repository.get(boardSeq);
	}
	

	/**
	 * 등록 처리
	 * @param board
	 */
	public void save(BoardParameter parameter) {
		// 조회하여 리턴된 정보
		Board board = repository.get(parameter.getBoardSeq());
		if(board == null) {
			repository.save(parameter);
		} else {
			repository.update(parameter);			
		}
	}
	
	/**
	 * 
	 * 단순 반복문을 이용한 등록 처리
	 */
	public void saveList1(List<BoardParameter> list) {
		for(BoardParameter parameter : list) {
			repository.save(parameter);
		}
	}
	
	/**
	 * 
	 * 100개씩 배열에 담아서 일괄 등록 처리
	 */
	public void saveList2(List<BoardParameter> boardList) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("boardList", boardList);
		repository.saveList(paramMap);
	}
	
	/**
	 * 삭제 처리
	 * @param board
	 */
	public void delete(int boardSeq) {
		repository.delete(boardSeq);
	}

}
