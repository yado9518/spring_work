package org.zerock.controller;

import java.io.File;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {
	
	@GetMapping("uploadForm") //get으로 접근하는 매핑주소 처리.
	public String uploadFrom() {
		return "uploadForm"; //뷰페이지 경로 -> /WEB-INF/views/uploadForm.jsp
	}
	
	@PostMapping("uploadFormAction") //uploadFormAction 매핑주소등록 post로 접근하는 매핑주소 처리
	public void uploadFormAction(MultipartFile[] uploadFile) {
		/*
		 * 스프링 API에서 MultipartFile 타입을 제공해서 업로드 되는 파일 데이터를 쉽게 처리, 다중 업로드 파일은 배열로 받는다.
		 * <input type="file" name="uploadFile"> 네임파라미터 이름을 매개변수명으로 지정해서 처리한다.
		 */
		
		String uploadFolder = "C:\\upload"; //업로드 서버 경로
		
		for(MultipartFile multipartFile : uploadFile) {
			System.out.println("------------------------------");
			System.out.println("Upload file name : " + multipartFile.getOriginalFilename());
			System.out.println("Upload file size : " + multipartFile.getSize());
			
			//파일과 폴더를 다루는 File클래스 생성자 인자값으로 업로드 서버경로와 첨부된 원본파일명을 가지고 File클래스 객체 생성
			File saveFile = new File(uploadFolder, multipartFile.getOriginalFilename());
			
			try {
				multipartFile.transferTo(saveFile); //업로드 된 원래 파일명으로 c드라이브 upload폴더에 업로드 함.
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} //자바 5버전이후부터 배열이나 컬렉션의 복수개의 데이터를 쉽게 처리하기 위해서 향상된 확장 for반복문을 사용한다.		
	}
	
}
