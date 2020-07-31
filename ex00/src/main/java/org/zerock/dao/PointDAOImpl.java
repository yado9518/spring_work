package org.zerock.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PointDAOImpl implements PointDAO{
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public void updatePoint(String sender, int point) {
		Map<String, Object> pm = new HashMap<>(); //복수개의 값을 전달하기 위해서 컬렉션 Map의 키, 값 쌍으로 저장
		pm.put("sender", sender); //키, 값 쌍으로 저장. sender키이름에 보낸사람을 저장하고 이 키이름을 point.xml에서 참조한다.
		pm.put("point", point); //포인트 점수 10을 저장
		this.sqlSession.update("pointUp", pm); //pointUp은 point.xml에서 설정할 유일한 update 아이디명, update()메서드는 mybatis에서 레코드 수정메서드이다.
	}
	
}
