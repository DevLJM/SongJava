package com.example.demo.mvc.parameter;

import java.util.List;

import com.example.demo.mvc.domain.BoardType;

import lombok.Data;

/**
 * 게시물 검색 파라미터
 * @author tr2user
 *
 */
@Data
public class BoardSearchParameter {
	private String keyword;
	private List<BoardType> boardTypes;
	
	public BoardSearchParameter() {
		
	}
}
