package org.zerock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.dao.ReplyDAO;
import org.zerock.vo.ReplyVO;

@Service
public class ReplyServiceImpl implements ReplyService {

	@Autowired
	private ReplyDAO replyDao;

	@Override
	public void addReply(ReplyVO vo) {
	   this.replyDao.addReply(vo);
	}

	@Override
	public List<ReplyVO> listReply(int bno) {
		return this.replyDao.listReply(bno);
	}

	@Override
	public void updateReply(ReplyVO vo) {
		this.replyDao.updateReply(vo);
	}

	@Override
	public void remove(int rno) {
		this.replyDao.remove(rno);		
	}
	
}





