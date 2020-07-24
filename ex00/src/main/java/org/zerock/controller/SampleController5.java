package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zerock.vo.ProductVO;

@Controller
public class SampleController5 {
	
	@RequestMapping("/doJSON") //doJSON 매핑주소 등록
	public @ResponseBody ProductVO doJSON() {
		//@ResponseBody는 jsp파일을 만들지 않고도 웹브라우저에 키,값 쌍의 JSON데이터를 만들어서 쉽게 출력할 수 있다.
		ProductVO p = new ProductVO("노트북", 1500000);
		//리턴타입이 ProductVO빈 타입이면 json데이터의 키이름은 ProductVO클래스의 변수명이 된다.
		//브라우저 주소창에 실행할 때 doJSON.json으로 실행해야 제대로 된 JSON데이터를 확인가능하다.
		return p;
	}
}
