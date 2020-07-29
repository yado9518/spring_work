package org.zerock.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReplyVO { //tbl_reply테이블 컬럼명과 일치하는 변수명을 정의
	
	private int rno; //댓글번호
	private int bno;//게시판 번호
	private String replyer; //댓글작성자
	private String replytext; //댓글내용
	private String regdate;//댓글 등록날짜
	private String updatedate; //댓글 수정날짜
}




