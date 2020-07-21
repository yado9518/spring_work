package org.zerock.controller;

import java.sql.Connection;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/*.xml") //root-context경로
public class DataSourceTest {
	
	@Inject //자동의존성주입
	private DataSource ds; //ds멤버변수인 참조변수에 객체 주소를 주입해서 사용할 수 있게 의존성 주입
	
	@Test //JUnit 연습용 테스트 에노테이션
	public void testCon() throws Exception{
		try(Connection con = ds.getConnection()) {
			//커넥션 풀 관리 ds로 디비연결 con을 생성
			System.out.println(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
 