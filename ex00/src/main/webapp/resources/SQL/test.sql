create table tbl_board11(
	b_no number(38) constraint tbl_board11_b_no_pk primary key --게시판번호
    ,b_name varchar2(50) constraint tbl_board11_b_name_nn not null  --글쓴이
    ,b_title varchar2(50) --게시판제목
    ,b_pwd varchar2(50) --비번
    ,b_cont varchar2(2000) --게시판내용
    ,b_hit number(38) --조회수
    ,b_date date --등록날짜
);



create table tbl_reply11(
	r_no number(38)  --댓글 번호
	,r_name varchar2(50) constraint tbl_reply11_nn not null --댓글 작성자
	,r_cont varchar2(2000) --댓글 내용
	,r_date date --댓글등록날짜
	,b_no number(38) 
	,constraint tbl_reply11_b_no_fk foreign key(b_no) references tbl_board11(b_no) --게시판번호
);
