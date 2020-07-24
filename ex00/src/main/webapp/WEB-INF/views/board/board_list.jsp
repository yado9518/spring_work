<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> <!-- JSTL fn 태그립 추가 -> JSTL함수를 사용할 수 있다. -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스프링 MVC 게시판 목록</title>
</head>
<body>
	<table border="1">
		<tr>
			<th colspan="5">스프링 MVC 게시판 목록</th>
		</tr>
		<tr>
			<th colspan="5" align="right">
				총 게시물 수: <b>${totalCount}</b> 개
			</th>
		</tr>
		<tr>
			<th>번호</th><th>제목</th><th>글쓴이</th><th>조회수</th><th>등록날짜</th>
		</tr>
		<c:if test="${!empty blist}">
		<c:forEach var="b" items="${blist}">
		<tr>
			<%-- board_cont?bno=번호값&page=쪽번호 형태의 주소창에 노출되는 get방식으로 &로 구분해서 bno,page 2개의 네임파라미터 이름에 번호, 쪽번호값을 각각 담아서 전달. --%>
			<th>${b.bno}</th><th><a href="/board/board_cont?bno=${b.bno}&page=${page}">${b.title}</a></th>
			<th>${b.writer}</th><th>${b.viewcnt}</th>
			<th>${fn:substring(b.regdate,0,10)}</th> <%-- jstl fn태그립을 사용한 0이상 10미만 사이의 년월일만 반환 --%>
		</tr>
		</c:forEach>
		</c:if>
		<c:if test="${empty blist}">
			<td colspan="5">게시물이 없습니다.</td>
		</c:if>
		<%-- 페이징 쪽번호 출력부분 --%>
		<tr>
			<th colspan="5">
				<c:if test="${page <= 1}">
					[이전]&nbsp; <%-- &nbsp;특수문자는 한칸의 빈공백을 띄움 --%>
				</c:if>
				<c:if test="${page > 1}">
					<%-- board_list?page=쪽번호 주소창에 노출되는 get방식으로 page네임 파라미터 이름에 쪽번호를 담아서 전달 --%>
					<a href="/board/board_list?page=${page-1}">[이전]</a>&nbsp; 
				</c:if>
				<%-- 쪽번호 --%>
				<c:forEach var="a" begin="${startpage}" end="${endpage}" step="1"> <%-- 시작페이지부터 끝페이지까지 1씩증가하면서 쪽번호가 출력 --%>
					<c:if test="${a == page}"> <%-- 현재 쪽번호가 선택된 경우 --%>
						${a}
					</c:if>
					<c:if test="${a != page}"> <%-- 현재 쪽번호가 선택안된 경우 --%>
						<a href="/board/board_list?page=${a}">[${a}]</a>
					</c:if>			
				</c:forEach>
				<c:if test="${page >= maxpage}"> <%-- 현재페이지가 총페이지 이상일때 --%>
					[다음]
				</c:if>
				<c:if test="${page < maxpage}">
					<a href="/board/board_list?page=${page+1}">[다음]</a> <%-- 다음페이지 이동 --%>
				</c:if>
			</th>
		</tr>
		<tr>
			<td colspan="5" align="right">
				<!-- 클릭이벤트 발생시 자바스크립트 내장객체 location에 의해서 글쓰기 매핑주소인 board_write로 이동 -->
				<input type="button" value="글쓰기" onclick="location='/board/board_write';">
			</td>
		</tr>
	</table>
	<script type="text/javascript">
		$msg = '${msg}'; //자바스크립트에서 EL(표현언어)+JSTL을 동시에 사용할 수 있다. $msg는 jQuery변수이고, ${msg}는 EL이다.
		if($msg == 'SUCCESS'){ //BoardController.java에서 저장한 msg키이름 값이 SUCCESS이다.
			alert('게시물 처리에 성공했습니다.')
		}
	</script>
</body>
</html>