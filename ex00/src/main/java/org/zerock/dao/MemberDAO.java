package org.zerock.dao;

import org.zerock.vo.Member7VO;

public interface MemberDAO {
	/*
	 * 인터페이스에 오는 추상메서드 특징
	 * 1.추상메서드는 {}가 없고, 실행문장이 없고, 호출 할 수가 없다.
	 * 2.public abstract가 생략됨. 이추상메서드는 인터페이스를 구현 상속한 자손클래스에서 반드시 오버라이딩을 해야한다.
	 */
	void insertMember(Member7VO m); //회원저장 추상메서드
	
}
