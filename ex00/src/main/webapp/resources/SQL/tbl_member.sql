--tbl_member 테이블 생성
create table tbl_member(
	userid varchar2(20) primary key --회원아이디
	,userpw varchar2(50) not null --비번
	,username varchar2(50) not null --이름
	,email varchar2(50) --email
	,regdate date --가입날짜
	,updatedate date --수정날짜
);

select * from tbl_member;

--스프링 MVC 게시판 테이블 -> tbl_board생성
create table tbl_board(
	bno int primary key --게시판 번호, int 타입은 number(38)타입과 같다.
	,writer varchar2(20) not null --작성자
	,title varchar2(200) not null --제목
	,content varchar2(4000) --내용
	,viewcnt int default 0 --조회수, default 0 제약조건으로 지정하면 굳이 해당 컬럼에 레코드를 저장하지 않아도 기본값 0이 저장됨.
	,regdate date --등록날짜
);

select * from tbl_board order by bno desc;

create sequence bno_seq
start with 1
increment by 1
nocache;

select bno_seq.nextval from dual;
