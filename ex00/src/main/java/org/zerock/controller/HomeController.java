package org.zerock.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	//GET방식으로 접근하는 매핑주소를 처리. /는 루트매핑주소 루트매핑주소는 http://localhst:8002/controller/
	@RequestMapping(value = "/", method = RequestMethod.GET)
	//Locale 특정 지리적, 국가적 또는 문화적 시간대를 지역에 따라 나타내게 함.
	public String home(Locale locale, Model model) {
		//이클립스 콘솔모드에 출력
		logger.info("Welcome home! The client locale is {}.", locale);
		Date date = new Date(); //날짜 객체를 생성
		//날짜 포맷객체 생성, 정적메서드 인자값으로 날짜스타일, 시간스타일, 해당국가 날짜/시간대 로케일
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		//날짜 객체를 문자열로 반환
		String formattedDate = dateFormat.format(date);
		//serverTime 키이름에 날짜 문자열 값을 저장
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
		//아작스 댓글뷰페이지
		@RequestMapping("/test") //test매핑주소 등록
		public ModelAndView test() {
			ModelAndView m = new ModelAndView();
			m.setViewName("reply"); //뷰페이지 경로 -> /WEB-INF/views/reply.jsp
			return m;
		}
	
}
