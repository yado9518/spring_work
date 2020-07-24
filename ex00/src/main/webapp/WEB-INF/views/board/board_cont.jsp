<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스프링 MVC 게시판 내용보기</title>
</head>
<body>
<table border="1">
	<tr>
		<th colspan="2">스프링 MVC 게시판 내용</th>
	</tr>
	<tr>
		<th>제목</th>
		<!-- b.title은 자바코드로 b.getTitle()과 같다. -->
		<td>${b.title}</td>
	</tr>
	<tr>
		<th>내용</th>
		<td>${b.content}</td>
	</tr>
	<tr>
		<th>조회수</th>
		<td>${b.viewcnt}</td>
	</tr>
	<tr>
		<th colspan="2">
			<%-- board_edit?bno=번호&page=쪽번호 주소창에 노출되는 get방식으로 bno와 page 네임파라미터이름에 각각 번호와 쪽번호를 담아서 전달한다. --%>
			<input type="button" value="수정" onclick="location='/board/board_edit?bno=${b.bno}&page=${page}';">
			<input type="button" value="삭제" onclick="location='/board/board_del?bno=${b.bno}&page=${page}';">
			<%-- board_list?page=쪽번호를 get으로 전달한 이유는 책갈피 기능때문이다. 책갈피란 내 본 페이지 쪽번호로 바로 이동하는 기능이다. --%>
			<input type="button" value="목록" onclick="location='/board/board_list?page=${page}';">
		</th>
	</tr>
</table>
</body>
</html>