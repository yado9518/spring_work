package org.zerock.vo;

import lombok.Getter;
import lombok.Setter;

@Setter //setter() 메서드 제공
@Getter //getter() 메서드 제공
public class SampleVO {//데이터 저장빈 클래스
	
	private int mno;//변수명이 JSON데이터의 키이름이 된다.
	private String firstName;//성
	private String lastName;//이름
}
