package org.zerock.controller;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.dao.MemberDAO;
import org.zerock.vo.Member7VO;

@RunWith(SpringJUnit4ClassRunner.class)
//root-context.xml파일 위치 경로지정 -> 스프링JDBC, mybatis설정, 모델DAOImpl, 서비스 설정파일(컨트롤러와 뷰페이지는 안들어감), AOP를 통한 트랜잭션 적용
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/*.xml") 
public class MemberDAOTest {
	
	@Inject //자동 의존성 주입
	private MemberDAO memberDao;
	
	@Test
	public void testInsert() throws Exception {
		Member7VO m = new Member7VO();
		m.setUserid("kkkkk"); //회원아이디 저장
		m.setUserpw("88888"); //비번 저장
		m.setUsername("홍길동"); //회원이름 저장
		m.setEmail("hong@naver.com"); //이메일 저장
		
		this.memberDao.insertMember(m);
	}
	
}
