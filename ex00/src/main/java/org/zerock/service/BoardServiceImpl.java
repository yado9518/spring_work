package org.zerock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

	@Override
	public void updateHit(int bno) {
		this.boardDao.updateHit(bno);
	}

	@Override
	public BoardVO getBoardList(int bno) {
		return this.boardDao.getBoardCont(bno);
	}

	@Override
	public BoardVO getBoardCont(int bno) {
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
	
}
