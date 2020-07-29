/*
 * 시퀸스 특징
 * 1.시퀸스는 번호 발생기이다. 중복번호가 없고, null이 발생되지 않는다.
 * 2.시퀸스를 사용할 테이블 컬럼은 반드시 기본키 제약조건과 정수 타입으로 선언해야 한다.
 * 
 * 시퀸스 생성문법
 * 1.시퀸스 생성: create sequence 시퀸스명
 * 2.시퀸스 생성시 부가옵션
 * 		가. increment by 1 : 1씩 증가
 * 		나. start with 1 : 1부터 시작
 * 		다. nocache : 시퀸스를 임시 메모리 사용하지 않겠다는 뜻
 */

--dept_seq라는 시퀸스 생성
create sequence dept_seq
start with 1
increment by 1
nocache;

--생성된 시퀸스 이름, 증가값을 확인
select sequence_name, increment_by from user_sequences;

--생성된 시퀸스 다음번호값 확인
select dept_seq.nextval from dual;

--생성된 시퀸스명을 확인
select sequence_name from user_sequences;

--del_seq시퀸스 생성
create sequence del_seq;

--del_seq시퀸스 삭제
drop sequence del_seq;