package org.zerock.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.zerock.vo.BoardVO;

@Repository //스프링에 Model DAOImpl이라는 것을 알려준다.
public class BoardDAOImpl implements BoardDAO {
	
	@Autowired //자동의존성 DI 설정
	private SqlSession sqlSession; //mybatis 쿼리문 수행객체 생성

	@Override
	public void insertBoard(BoardVO b) {
		this.sqlSession.insert("b_in", b);
	}

	@Override
	public int getTotalCount() {
		//mybatis에서 selectOne()메서드는 단 한개의 레코드만 반환, b_count는 board.xml에서 설정할 유일한 select 아이디명
		return this.sqlSession.selectOne("b_count");
	} //총 레코드 개수 = 총 게시물 수

	@Override
	public List<BoardVO> getBoardList(BoardVO b) {
		//mybatis에서 selectList()메서드는 하나이상의 레코드를 검색해서 컬렉션 List로 반환한다. blist는 board.xml에서 설정한 select 아이디명이다.
		return this.sqlSession.selectList("blist",b); 
	}

	@Override
	public void updateHit(int bno) {
		//update()는 mybatis에서 레코드 수정메서드이다. b_hit는 board.xml에서 설정할 유일한 update 아이디명이다.
		this.sqlSession.update("b_hit",bno);
	}

	@Override
	public BoardVO getBoardCont(int bno) {
		//mybatis에서 selectOne()메서드는 단 한개의 레코드값만 반환하고, b_cont는 board.xml에서 설정할 유일한 select 아이디명이다.
		return this.sqlSession.selectOne("b_cont",bno);
	}

	@Override
	public void editBoard(BoardVO b) {
		this.sqlSession.update("b_edit",b);
	}

	@Override
	public void delBoard(int bno) {
		/*
		 * 1.mybtis에서 delete()는 레코드 삭제, b_del은 board.xml에서 설정할 유일한 delete 아이디명이 된다.
		 * 2.mybatis 쿼리문 수행메서드 종류
		 * 	가.insert(): 레코드 저장
		 * 	나.delete(): 레코드 삭제
		 * 	다.update(): 레코드 수정
		 * 	라.selectList(): 하나이상의 레코드를 검색해서 컬렉션 List로 반환
		 * 	마.selectOne(): 단 한개의 레코드만 반환
		 */
		this.sqlSession.delete("b_del",bno);	
	}
	/*
	 * get방식인 경우
	 * 	1.자바스크립트 location객체에 의해서 이동하는 경우
	 * 	2.하이퍼링크로 이동하는 경우
	 * 	3.서블릿의 response.sendRedirect()로 이동하는 경우
	 * 	4.폼태그의 method="get"인 경우나 생략하는 경우
	 * 	5.아작스 get방식인 경우
	 * 	6.스프링의 redirect로 이동하는 경우
	 * 
	 * post인 경우
	 * 	1.폼태그의 method=post인 경우
	 * 	2.아작스 post방식인 경우
	 */

	@Override
	public void updateReplyCnt(int bno, int count) {
		Map<String, Object> pm = new HashMap<String, Object>(); //뒷부분 <>제네릭 타입을 생략할 수 있는 것은 자바 7이후부터 가능하다. 키, 값 쌍으로 저장하는 컬렉션 맵
		pm.put("bno", bno); //bno키이름에 번호값 저장
		pm.put("count",count);
		this.sqlSession.update("r_cnt",pm); //r_cnt는 board.xml에 설정할 유일한 update 아이디명
	} //댓글 카운터 증가
	
}
