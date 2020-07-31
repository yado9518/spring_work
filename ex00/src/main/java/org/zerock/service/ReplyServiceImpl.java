package org.zerock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.dao.BoardDAO;
import org.zerock.dao.ReplyDAO;
import org.zerock.vo.ReplyVO;

@Service
public class ReplyServiceImpl implements ReplyService {

	@Autowired
	private ReplyDAO replyDao;
	
	@Autowired
	private BoardDAO boardDao;
	
	@Transactional //트랜잭션 적용
	@Override
	public void addReply(ReplyVO vo) {
	   this.replyDao.addReply(vo);
	   this.boardDao.updateReplyCnt(vo.getBno(), -1); //게시판 번호값을 구해서 댓글이 추가되면  댓글 카운트를 1증가
	} //댓글이 추가되면 카운트 증가 -> AOP를 통한 트랜잭션 적용대상

	@Override
	public List<ReplyVO> listReply(int bno) {
		return this.replyDao.listReply(bno);
	}

	@Override
	public void updateReply(ReplyVO vo) {
		this.replyDao.updateReply(vo);
	}

	@Transactional //트랜잭션 적용
	@Override
	public void remove(int rno) {
		int bno = this.replyDao.getBno(rno); //먼저 댓글번호에 해당하는 게시물 번호값을 구함
		this.replyDao.remove(rno);
		this.boardDao.updateReplyCnt(bno,-1); //댓글을 삭제하면 댓글개수가 1감소
	} //댓글이 삭제되면 댓글수를 -1로 카운터 -> AOP를 통한 트랜잭션 적용대상
	
}





