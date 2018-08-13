<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>메인화면</title>
</head>
<body>
	<h1>ShuShu 쇼핑몰</h1>
	<ul>
		<li>
			<!-- 회원 등록하는 페이지 -->
			<a href="${pageContext.request.contextPath }/shushuAdd">회원등록</a>
		</li>
		<li>
			<!-- 회원 등록한 회원 리스트 조회 -->
			<a href="${pageContext.request.contextPath }/shushuList">회원리스트</a>
		</li>
		<li>
			<!-- 회원 등록을 한 회원리스트를 통해 회원수정 바로 여기 페이지로 볼 경우 수정할 리스트 조회가 보이지 않음.. -->
			<a href="${pageContext.request.contextPath }/shushuUpdate">회원수정</a>
		</li>
	</ul>
	
</body>
</html>