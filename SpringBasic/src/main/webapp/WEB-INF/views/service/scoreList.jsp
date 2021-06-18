<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3>점수 결과</h3>
	
	<c:forEach var="vo" items="${list }">
	
		이름:${vo.name } <br>
		국어:${vo.kor } <br>
		수학:${vo.math } <br>
		
		<button type="button" onclick="location.href='scoreDelete?num=${vo.bno}'">삭제</button> <br>
	
	</c:forEach>
	
	
	
	<a href="scoreRegist">점수 입력</a>


	<script>
	
		// 메시지 처리기능
		(function(){
			
			var msg1 = '<c:out value="${msg}" />';
			if(msg1 != '') {
				alert(msg1);	
			}
			
		})();
		
	
	</script>

</body>
</html>