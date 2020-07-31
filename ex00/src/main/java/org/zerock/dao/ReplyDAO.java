package org.zerock.dao;

import java.util.List;

import org.zerock.vo.ReplyVO;

public interface ReplyDAO {

	void addReply(ReplyVO vo);
	List<ReplyVO> listReply(int bno);
	void updateReply(ReplyVO vo);
	void remove(int rno);
	int getBno(int rno);
}
