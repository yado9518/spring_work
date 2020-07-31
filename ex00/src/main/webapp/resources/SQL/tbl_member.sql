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


--트랜잭션을 적용을 위한 tbl_user테이블 생성(설계)
create table tbl_user(
	uid2 varchar2(20) primary key --회원아이디
	,upw varchar2(20) not null --비번
	,uname varchar2(50) not null --회원이름
	,upoint number(38) default 0 --메시지가 보내지면 포인트 점수 10점 증가 업(트랜잭션 적용대상이 되는 컬럼 레코드)
);

insert into tbl_user(uid2,upw,uname) values('user00','user00','홍길동');
insert into tbl_user(uid2,upw,uname) values('user01','user01','이순신');

select * from tbl_user;

--메시지가 저장되는 tbl_message 테이블 생성
create table tbl_message(
	mid number(38) primary key
	,targetid varchar2(20) not null --외래키로 추가설정 -> 부모테이블 tbl_user의 uid2 컬럼 아이디값만 가져와 저장됨.
	,sender varchar2(20) not null --메시지를 보낸사람
	,message varchar2(1000) not null --보낸 메시지
	,senddate date --메시지를 보낸 날짜
);

--targetid 컬럼 외래키 제약조건 설정
alter table tbl_message add constraint fk_usertarget
foreign key(targetid) references tbl_user(uid2);

--mid_no_seq 시퀸스 생성
create sequence mid_no_seq
start with 1
increment by 1
nocache;

--mid_no_seq 시퀸스 번호값 발생
select mid_no_seq.nextval from dual;

select * from tbl_message;
select * from tbl_user;
delete from tbl_message;
update tbl_user set upoint=0 where uid2='user01';


--tbl_board 게시판 테이블에 댓글 개수를 카운트한 댓글 개수를 저장할 컬럼 replycnt추가
alter table tbl_board
add(replycnt number(38) default 0);

select * from tbl_board order by bno desc;
select * from tbl_reply order by rno desc;

--tbl_reply와 tbl_board테이블의 댓글 개수를 일치하게 변경
update tbl_board set replycnt=(select count(rno)
from tbl_reply where bno=tbl_board.bno) where bno>0;

