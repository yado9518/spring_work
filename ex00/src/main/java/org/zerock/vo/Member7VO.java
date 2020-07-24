package org.zerock.vo;

import java.util.Date;

import lombok.Data;

@Data
public class Member7VO { //tbl_member테이블 컬럼명과 일치되는 변수명을 가진 데이터 저장빈 클래스
	private String userid;
	private String userpw;
	private String username;
	private String email;
	private Date regdate;
	private Date updatedate;
}
