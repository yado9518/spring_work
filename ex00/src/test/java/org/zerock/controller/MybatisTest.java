package org.zerock.controller;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/*.xml")
public class MybatisTest {
	
	@Autowired //자동의존성 주입 -> DI(의존성 주입 -> 해당변수에 객체주소를 주입하는 과정
	private SqlSessionFactory sqlFactory;
	
	@Test
	public void testFactory() {
		System.out.println(sqlFactory);
	}
	
	@Test
	public void restSession() throws Exception{
		try(SqlSession sqlSession = sqlFactory.openSession()) {
			/*
			 * 1.SqlSession 자바7에서 추가된 AutoCloseable인터페이스를 구현상속 받아서 try()내에서 객체를 생성하면
			 * 명시적인 close() 하지않아도 자동으로 닫힌다.
			 * 2.SqlSession은 mybatis쿼리문 수행객체가 된다.
			 */
			System.out.println(sqlSession);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
