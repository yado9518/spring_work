package org.zerock.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.vo.SampleVO;

@RestController //스프링 4.0 이후부터  @RestController를 사용하면 jsp
//뷰페이지를 만들지 않고도 ,Rest방식의 데이터 처리를 위한 문자열,json등의 데이터를
//만들수 있다.
public class SampleController6 {

	@RequestMapping("/hello")
	public String hello() {
		return "Rest Begin";//문자열 객체를 반환
	}
	
	@RequestMapping("/sendVO") //sendVO매핑주소 등록,브라우저 주소창에서
	//json데이터를 확인할려면 매핑주소 sendVO.json이라는 JSON확장자를 사용해야 한
	//다.
	public SampleVO sendVO() {
		//리턴타입이 SampleVO이면 변수명이 JSON의 키이름이 된다.
		SampleVO vo=new SampleVO();
		vo.setFirstName("홍");
		vo.setLastName("길동");
		vo.setMno(10);
		
		return vo;
	}//sendVO()
	
	@RequestMapping("/sendList")
	public List<SampleVO> sendList(){//컬렉션 키,값쌍의 json데이터가 반환
		List<SampleVO> list=new ArrayList<>();
		
		for(int i=1;i<=5;i++) {
			SampleVO vo=new SampleVO();
			vo.setMno(i);
			vo.setFirstName("이");
			vo.setLastName("순신");
			
			list.add(vo);//컬렉션에 추가
		}//for
		return list;
	}//sendList()
	
	//키,값 쌍의 Map타입 JSON
	@RequestMapping("/sendMap")
	public Map<Integer,SampleVO> sendMap(){
		Map<Integer,SampleVO> map=new HashMap<>();
		
		for(int i=1;i<=3;i++) {
			SampleVO vo=new SampleVO();
			
			vo.setMno(i);
			vo.setFirstName("신");
			vo.setLastName("사임당님");
			
			map.put(i,vo);//맵 컬렉션에 키,값 추가
		}//for
		return map;
	}//sendMap()
	
	@RequestMapping("/sendError") //sendError라는 매핑주소 등록
	public ResponseEntity<Void> sendError(){
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
/* @RestController는 별도의 jsp뷰페이지를 만들지 않고도 REST 서비스를 실행하기 때
 * 문에 결과 데이터에 대한 예외적인 에러 상황이 발생할 수 있다. 스프링에서 제공하는 Resp
 * onseEntity 타입은 개발자가 문제가 되는 나쁜상태 404,500같은 HTTP 나쁜상태코드
 * 를 데이터와 함께 브라우저로 전송할 수 있기 때문에 좀더 세밀한 제어가 필요한 경우 사용된
 * 다. 여기서는 400나쁜 상태코드 BAD_REQUEST가 브라우저로 전송된다. 	
 * 정상적인 경우는 200상태코드가 반환. 	
 */
	}//sendError()
	
	//정상적인 JSON데이터와 404(해당 파일을 못찾을때)  나쁜상태코드를 함께 반환
	@RequestMapping("/sendErrorNot")
	public ResponseEntity<List<SampleVO>> sendErrorNot(){
		List<SampleVO> list=new ArrayList<>();
/*ResponseEntity타입 스프링 API는 REST 서비스에서 JSP파일을 만들지 않고도 서버
 * 프로그램을 개발할 때 좀더 쉽게 에러를 제어해서 사용하기 위한 용도로 활용된다. 		
 */
		for(int i=1;i<=2;i++) {
			SampleVO vo=new SampleVO();
			vo.setMno(i);
			vo.setFirstName("홍");
			vo.setLastName("길동");
			
			list.add(vo);//컬렉션에 추가
		}//for
		return new ResponseEntity<List<SampleVO>>(list,
				HttpStatus.NOT_FOUND);//정상적인 컬렉션 json데이터와
		//404나쁜상태코드가 반환. 404에러는 실행결과 웹브라우저 구글 크롬에서 F12
//개발자 도구를 열고 콘솔에서 확인가능하다.		
	}//sendErrorNot()
}

