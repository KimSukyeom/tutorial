<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>ShuShu 회원등록</h1>
	<form action="${pageContext.request.contextPath }/shushuAdd" method="post">
		<div style="color :red;">${error }</div>
		<table>
			<tr>
				<td>아이디 : </td>
				<td>
					<input type="text" name="id" placeholder="ex)kissin20">
				</td>
			</tr>
			<tr>
				<td>이름 : </td>
				<td>
					<input type="text" name="name" placeholder="ex)김수겸">
				</td>
			</tr>
			<tr>
				<td>생년월일 : </td>
				<td>
					<input type="date" name="dob">
				</td>
			</tr>
			<tr>
				<td>이메일 : </td>
				<td>
					<input type="email" name="email" placeholder="ex)kissin10@naver.com">
				</td>
			</tr>
			<tr>
				<td>
					<input type="submit" value="등록"> 
				</td>
			</tr>
		</table>
	</form>
</body>
</html>