package org.zerock.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.zerock.vo.Member7VO;

@Repository //스프링에서 모델DAOImpl을 인식하게하는 어노테이션
public class MemberDAOImpl implements MemberDAO {
	
	@Autowired //자동의존성 주입 -> DI
	private SqlSession sqlSession; //mybatis쿼리문 수행객체
	
	@Override
	public void insertMember(Member7VO m) {
		/*
		 * 1.this.은 생략가능하고 sqlSession은 mybatis쿼리문 실행객체이다.
		 * 2.insert()메서드는 mybatis에서 레코드 저장메서드이다. m_in은 member.xml에서 설정한 insert 유일아이디명이다.
		 * m객체가 member.xml에 설정된 parameterType과 연결된다. 
		 */
		this.sqlSession.insert("m_in", m);
	}

}
