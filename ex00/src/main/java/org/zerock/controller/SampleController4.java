package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SampleController4 {
	
	@RequestMapping("/doE") //doE 매핑주소 등록
	public String doE(RedirectAttributes rttr) {
		/*
		 * 백엔드 서버에서 다른 매핑주소로 이동할 때 msg키이름에 seven값을 담아서 전달한다. 서버상에서 실행되기 때문에 웹브라우저
		 * 주소창에 노출되지 않는다. 보안상 좋다.
		 */
		rttr.addFlashAttribute("msg","seven");
		return "redirect:/doF"; //브라우저 주소창에서 /doE매핑주소가 실행되면 다른 매핑주소 /doF로 이동해서 주소창매핑주소가 /doE에서 /doF로 변경됨.
	}
	
	@GetMapping("/doF") // /doF매핑주소 등록, @GetMapping은 get방식인 경우만 실행
	public void doF(@ModelAttribute("msg") String msg) { 
		//리턴타입이 없는 void형이면 매핑주소 doF가 jsp파일명이 된다. msg파라미터로 전달된 값을 @ModelAttribute("msg")에 가져와서 매개변수 msg에 저장한다.
		System.out.println("msg파라미터로 전달된 값: " + msg);
	}
	
}
