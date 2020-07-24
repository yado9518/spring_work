package org.zerock.vo;

import lombok.Data;

@Data
public class BoardVO {
	private int bno;
	private String writer;
	private String title;
	private String content;
	private int viewcnt;
	private String regdate;
	
	//페이징(쪽나누기:paging) 관련변수
	private int startrow; //시작행 번호
	private int endrow; //끝행 번호
	
}
