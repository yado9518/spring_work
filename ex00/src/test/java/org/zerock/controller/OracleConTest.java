package org.zerock.controller;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

public class OracleConTest {
	
	//static final은 정적상수이다. 상수는 관례적으로 영문대문자로 한다. OracleDriver는 jdbc 드라이버 클래스명
	static final String DRIVER = "oracle.jdbc.OracleDriver";
	
	//오라클 접속주소, 1521은 포트번호, xe는 디비명
	private static final String URL = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	
	private static final String USER = "week";//오라클 접속 사용자
    private static final String PW = "week";//오라클 접속 사용자 비번
    
    @Test //JUnit 연습용 테스트 어노테이션
    public void testCon() throws Exception{
    	Class.forName(DRIVER); //jdbc 드라이버 클래스 로드
    	try(Connection con = DriverManager.getConnection(URL, USER, PW)) {
			/*
			 * java 7버전에서 추가된 문법으로 Connection은 AutoCloseable 인터페이스를 구현 상속받았기 때문에
			 * try()내에서 객체를 생성하면 finally문에서 명시적 코드로 close() 하지않아도 자동으로 닫힌다.
			 */
    		System.out.println(con); //con즉 디비 연결 객체주소를 이클립스 콘솔모드에 출력
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
}






