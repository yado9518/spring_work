package org.zerock.service;

import java.util.List;

import org.zerock.vo.BoardVO;

public interface BoardService {
	void insertBoard(BoardVO b); //public abstract가 생략된 추상메서드 게시물 저장
	int getTotalCount(); //총게시물 수
	List<BoardVO> getBoardList(BoardVO b); //게시물 목록
	//void updateHit(int bno);
	BoardVO getBoardList(int bno);
	BoardVO getBoardCont(int bno);
	void editBoard(BoardVO b);
	void delBoard(int bno);
}
