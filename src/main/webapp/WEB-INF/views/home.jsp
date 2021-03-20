<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
	    <meta charset="UTF-8">
	    <title>공지사항 등록</title>
	</head>
	<body>
	    <c:if test="${empty member}">
		    <div class="">
		        <button type="button" id="login-btn">로그인</button>
		        <button type="button" id="register-btn">회원가입</button>
		    </div>
	    </c:if>
	    <c:if test="${member}">
	        <p>{{user.username}}님 환영합니다.</p>
	        <button type="button" id="folder-btn">내 폴더로 가기</button>
	        <button type="button" id="logout-btn">로그아웃</button>
	    </c:if>
	</body>
	
	<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
	<script src="static/js/hello.js"></script>
</html>