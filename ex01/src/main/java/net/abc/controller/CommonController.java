package net.abc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CommonController {
	
	@GetMapping("/accessError") //accessError매핑주소 등록
	public void accessDenied(Model m) { //리턴 타입이 없는 void형이면 매핑주소 accessError가 뷰페이지 파일명이 된다.
		System.out.println("access Denied");
		m.addAttribute("msg","Access Denied"); //msg 키이름에 Access Denied 문자열을 저장함. 해당 뷰페이지에서 msg키이름을 EL로 참조해서 값을 가져온다.
	}
}
