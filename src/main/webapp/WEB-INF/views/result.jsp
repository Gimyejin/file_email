<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:forEach var="dto" items="${list }">
		id : ${dto.id }<br>
		name : ${dto.name }<br>
		image name : ${dto.imgName }<hr>
		<img src="${contextPath }/download?file=${dto.imgName}" width="100px" height="100px">
		<a href="${contextPath }/download?file=${dto.imgName}">${dto.imgName }-클릭 시 다운</a>
		<hr>
	</c:forEach>
	<a href="${contextPath }/form">다시 업로드 이동</a>
</body>
</html>