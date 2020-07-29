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

select * from 
(select rowNum rNum,bno,writer,title,viewcnt,regdate from
(select * from tbl_board order by bno desc))
where rNum >= 1 and rNum <= 10;


--댓글 테이블 tbl_reply 생성
create table tbl_reply(
	rno number(38) primary key --댓글번호
	,bno int default 0 --게시판 번호값만 저장=>나중에 외래키 설정
	,replyer varchar2(30) not null --댓글 작성자
	,replytext varchar2(4000) not null --댓글내용
	,regdate date --등록날짜
	,updatedate date --수정날짜
);

select * from tbl_reply order by rno desc;

--bno컬럼 외래키 설정
alter table tbl_reply add constraint tbl_reply_bno_fk
foreign key(bno) references tbl_board(bno); --부모테이블 bno컬럼을 참조 부모테이블이 tbl_board의 게시판 번호값만 저장가능하다.

--rno_seq라는 시퀀스 생성
create sequence rno_seq
start with 1
increment by 1
nocache;

--rno_seq 시퀀스 번호값 확인
select rno_seq.nextval from dual;