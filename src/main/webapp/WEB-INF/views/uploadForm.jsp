<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>uploadForm</title>
</head>
<body>
	<h1>파일 업로드</h1>
	<form action="${contextPath }/upload" method="post"
		enctype="multipart/form-data">
		<!-- 파일 업로드때는 무조건 post, enctype은 무조건 multipart/form-data이어야함 -->
		<!-- multipart/form-data쓰면 multipart로 받아야ㅑ함 -->
		<input type="text" name="id" placeholder="id"><br>
		<input type="text" name="name" placeholder="name"><br>
		<input type="file" name="file"><br>
		<input type="submit" name="업로드"><br>
	</form>
	<hr>
	<a href="${contextPath }/views">파일보기</a>
</body>
</html>