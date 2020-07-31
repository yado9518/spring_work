package org.zerock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.dao.BoardDAO;
import org.zerock.vo.BoardVO;

@Service //@Service를 추가해서 스프링에 서비스 영역이라는 것을 알려준다.
public class BoardServiceImpl implements BoardService {
	
	@Autowired //자동의존성 주입(DI)
	private BoardDAO boardDao;

	@Override
	public void insertBoard(BoardVO b) {
		this.boardDao.insertBoard(b);
	}

	@Override
	public int getTotalCount() {
		return this.boardDao.getTotalCount();
	}

	@Override
	public List<BoardVO> getBoardList(BoardVO b) {
		return this.boardDao.getBoardList(b);
	}
	
	/*
	@Override
	public void updateHit(int bno) {
		this.boardDao.updateHit(bno);
	}
	*/
	
	@Transactional(isolation = Isolation.READ_COMMITTED) //트랜잭션 격리(트랜잭션이 처리되는 중간에 외부간섭을 없앰)
	@Override
	public BoardVO getBoardCont(int bno) {
		this.boardDao.updateHit(bno); //내용보기일때 조회수 증가 -> AOP를 통한 트랜잭션 적용대상
		return this.boardDao.getBoardCont(bno);
	}

	@Override
	public void editBoard(BoardVO b) {
		this.boardDao.editBoard(b);
	}

	@Override
	public void delBoard(int bno) {
		this.boardDao.delBoard(bno);
	}

	@Override
	public BoardVO getBoardList(int bno) {
		return this.boardDao.getBoardCont(bno);
	}
	
}
