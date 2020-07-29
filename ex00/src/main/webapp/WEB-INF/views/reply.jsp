<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비동기식(화면전환이 없다) 아작스 댓글</title>
<style type="text/css">
/* position 속성이 absolute 나  fixed 로 설정된 곳에서 요소가 겹쳐지는 순서를 제어할 수 있다. 값이 큰것이 앞에 나온다. */
#modDiv{width: 300px; height: 100px; background: gray; position: absolute; top: 50%; left: 50%; 
margin-top: -50px; margin-left: -50px; padding: 10px; z-index: 1000;}
</style>
</head>
<body>
<%-- 댓글 수정 화면 --%>
<div id="modDiv" style="display: none;"> <%-- display:none; css는 해당영역을 안보이게 함 --%>
	<div class="model-title"></div> <%-- 댓글번호 --%>
	<div>
		<textarea rows="3" cols="30" id="replytext"></textarea> <%-- 댓글내용 --%>
	</div>
	<div>
		<button type="button" id="replyModBtn">댓글수정</button>
		<button type="button" id="replyDelBtn">댓글삭제</button>
		<button type="button" id="closeBtn" onclick="modDivClose();">닫기</button>
	</div>
</div>

<%-- 댓글등록 화면 --%>
<h2>댓글등록 화면</h2>
<div>
	<div>
		<%-- type속성을 생략하면 한줄 입력박스를 만드는 text이다. --%>
		댓글 작성자:<input name="replyer" id="newReplyWriter">
	</div>
	<br>
	<div>
		댓글 내용:<textarea rows="5" cols="30" name="replytext" id="newReplyText"></textarea>
	</div>
	<br>
	<button type="button" id="replyAddBtn">댓글등록</button>
	<button type="button" id="replyDelBtn">댓글삭제</button>
	<%-- 닫기 버튼을 클릭했을때 onclick 이벤트핸들러(사건처리기)에 의해서 modDivClose()함수를 호출.
	이 함수명은 자바스크립트 function키워드로 정의한다. --%>
	<button type="button" id="closeBtn" onclick="modDivClose();">닫기</button>
	
</div>
<br><hr><br>

<%-- 댓글 목록 --%>
<ul id="replies"></ul>

<%-- jQuery 라이브러리 읽어옴 --%>
<script src="/resources/js/jquery.js"></script>
<script type="text/javascript">
	
	var bno = 14; //게시판 번호
	getAllList();
	
	function getAllList(){
		$.getJSON("/replies/all/" + bno, function(data){
			/*
				$.getJSON(매핑주소경로, 아작스로 읽어오는 것이 성공시 호출되는 콜백함수. 읽어온자료는 data매개변수에 저장됨.) 
				-> get방식으로 JSON데이터를 비동기식 아작스로 읽어들이는 jQuert ajax함수이다.
			*/
			var str = ""; //var 변수정의 자바스크립트 예약어로 str변수를 정의
			$(data).each(function(){
				//this.rno는 댓글번호, this.replytext는 댓글내용, +=복합 대입연산자로 복수개의 목록을 누적해서 문자를 연결한다.
				str += "<li data-rno='" + this.rno + "'class='replyLi'>" + this.rno + ": <span class='com' style='color:blue; font-weight:bold;'>"
				+ this.replytext + "</span><button>댓글수정</button></li><br>"
			});
			$('#replies').html(str); //ul 아이디영역에 jQuery html() 함수로 읽어온 문자와 태그를 함께 변경적용			
	}); //댓글 목록함수 호출
} //댓글 목록함수
	
	//댓글 삭제완료
	$('#replyDelBtn').on('click',function(){
		var rno = $('.model-title').html(); //html()함수는 해당영역 태그와 문자를 구함 -> 댓글번호
		
		$.ajax({
			type : "delete", //삭제 메서드 방식
			url : '/replies/' + rno, //매핑주소 경로
			headers : {
				"Content-Type" : "application/json",
				"X-HTTP-Method-Override" : 'DELETE'
			},
			dataType : 'text', //자료형
			success : function(result) { //받아오는 것이 성공시 호출되는 콜백함수 -> 받아온 문자열은 result매개변수에 저장
				if(result=='SUCCESS'){
					alert('댓글이 삭제되었습니다!');
					location.reload(); //자바스크립트 내장객체 location하위의 reload()메서드로 새로고침 -> 단축키로 F5
					getAllList(); //댓글 목록함수 호출
				}
			}
		});
	});
	
	//댓글 수정완료
	$('#replyModBtn').on('click',function(){
		var rno = $('.model-title').html(); //댓글번호
		var replytext = $('#replytext').val(); //수정할 댓글내용
		
		$.ajax({ //비동기식 jQuery 아작스 함수
			type : 'put', //전체자료를 수정할때 사용하는 메서드 방식
			url : '/replies/'+rno, //매핑주소 경로
			headers : {
				"Content-Type":"application/json",
				"X-HTTP-Method-Override":"PUT"
			},
			data : JSON.stringify({replytext:replytext}), //json데이터 키 : 값  -> 수정할 댓글내용
			dataType : "text", //자료형
			success : function(result) { //받아오는 것이 성공시 호출되는 콜백함수. 받아온 문자열은 result매개변수에 저장
				if(result=='SUCCESS') {
					alert('댓글이 수정되었습니다!');
					$('#modDiv').hide('slow'); //댓글수정화면 닫기
					getAllList(); //수정후 댓글 목록함수를 호출해서 확인
				}
				}
		});
	});
	
	//댓글 수정 화면 div닫기
	function modDivClose() {
		$('#modDiv').hide('slow'); //jQuery hide()함수로 해당 수정화면을 천천히 사라지게 한다.
	} //modDivClose()
	
	//댓글 수정화면
	$('#replies').on('click','.replyLi button',function(){ //댓글 목록에서 댓글수정 버튼을 클릭했을 때 실행
		var reply = $(this).parent(); //parent() 부모요소를 선택 -> li태그
		var rno = reply.attr('data-rno'); //data-rno속성값인 댓글번호를 구함
		var replytext = reply.children('.com').text(); //li태그 자식요소인 span태그의 클래스 선택자 com의 문자만 가져옴 -> 댓글내용만 가져옴
		
		$('.model-title').html(rno); //해당영역에 댓글번호와 태그를 함께 변경적용
		$('#replytext').val(replytext); //textarea영역에 댓글내용을 출력
		$('#modDiv').show('slow'); //댓글수정화면을 천천히 보이게 함.
	});

	//댓글등록 버튼을 클릭했을 때 실행
	$('#replyAddBtn').on("click",function(){
		var replyer = $('#newReplyWriter').val(); //댓글작성자
		var replytext = $('#newReplyText').val(); //댓글내용
		
		$.ajax({ //jQuery 비동기식 아작스 함수
			type : 'post', //메서드 보내는 방식이 post
			url : '/replies', //매핑주소
			headers : {
				"Content-Type" : "application/json",
				"X-HTTP-Method-Override" : "POST",
			}, //HTTP 헤더에 추가되는 컨텐트 타입형식이 json이고, 메서드 방식이 POST
			dataType : 'text', //자료형식이 문자열
			data : JSON.stringify({ //보내는 데이터가 JSON문자열, 좌측변수 bno, replyer, replytext가 JSON의 키이름이고, 이것이 ReplyVO빈클래스의 변수명이 된다.
				bno : bno, //오른쪽에 있는 게시판 번호값이 좌측변수 bno에 할당
				replyer : replyer, //댓글 작성자
				replytext : replytext, //댓글내용
			}), //보내는 데이터가 JSON문자열 -> JSON데이터
			success : function(result){ //비동기식으로 가져오는 것이 성공시 호출되는 콜백함수, 가져온 문자열은 result매개변수에 저장
				if(result == 'SUCCESS'){
					alert('댓글이 등록되었습니다!');
					getAllList(); //댓글목록함수를 호출
				}
			}
		});
	});
</script>
</body>
</html>