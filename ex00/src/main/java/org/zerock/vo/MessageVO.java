package org.zerock.vo;

import lombok.Data;

@Data
public class MessageVO {
	private int mid;
	private String targetid; //외래키로 설정되어서 tbl_user테이블의 회원아이디
	private String sender;
	private String message;
	private String senddate;
}
