package org.zerock.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.zerock.vo.ReplyVO;

@Repository
public class ReplyDAOImpl implements ReplyDAO {

	@Autowired
	private SqlSession sqlSession;

	@Override
	public void addReply(ReplyVO vo) {
		this.sqlSession.insert("r_in",vo);
		//r_in은 reply.xml에서 설정할 유일한 insert 아이디명		
	} //댓글저장

	@Override
	public List<ReplyVO> listReply(int bno) {
		return this.sqlSession.selectList("r_list",bno);
		//mybatis에서  selectList()는 하나이상의 레코드를 검색해서 컬렉션 List로 반환		
		//r_list는 reply.xml에서 설정할 유일 아이디명		
	} //댓글목록

	@Override
	public void updateReply(ReplyVO vo) {
		this.sqlSession.update("r_edit",vo);		
	}

	@Override
	public void remove(int rno) {
		//mybatis에서 delete()는 레코드 삭제, r_del은 reply.xml에서 설정할 delete아이디명
		this.sqlSession.delete("r_del",rno);	
	} //댓글삭제

	@Override
	public int getBno(int rno) {
		return this.sqlSession.selectOne("r_bno",rno); //mybatis에서 selectOne()메서드는 단 한개의 레코드만 검색, r_bno는 reply.xml에서 설정할 유일한 select 아이디명
	} //댓글번호에 해당하는 게시판 번호값 알아내기
	
}





