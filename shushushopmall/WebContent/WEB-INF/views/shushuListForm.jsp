<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>ShuShu 회원리스트</h1>
	<table>
		<tr>
			<th>아이디</th>
			<th>이름</th>
			<th>생년월일</th>
			<th>이메일</th>
		</tr>
		
		<c:forEach items="${list }" var="list">
		<tr>
			<td>
				${list.id }
			</td>
			<td>
				${list.name }
			</td>
			<td>
				${list.dob }
			</td>
			<td>
				${list.email }
			</td>
		</tr>
		</c:forEach>
	</table>
	
	
</body>
</html>