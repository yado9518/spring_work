package org.zerock.page;

import lombok.Data;

@Data
public class PageDTO {
	
	private int startPage; //시작페이지
	private int endPage; //끝페이지
	private boolean prev, next; //이전,다음
	private int page; //현재 페이지
	private int total; //전체 페이지수
	
	public PageDTO(int total) {
		this.total = total;
		
		this.endPage = (int)(Math.ceil(this.page/10)) * 10;
		this.startPage = this.endPage - 9;
		
		int readEnd = (int)(Math.ceil(this.total*1.0) / 10);
	}
	
	
	
	
	
}
