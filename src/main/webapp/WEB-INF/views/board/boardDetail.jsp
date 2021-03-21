<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<label>제목</label>
	<p>${board.title}</p>
	<label>작성자</label>
	<p>${board.memberID}</p>
	<label>최조 생성 날짜</label>
	<p>${board.createdDate}</p>
	<label>최종 업데이트 날짜</label>
	<p>${board.updatedDate}</p>
	<label>첨부 파일</label>
	<div>
		<c:forEach var="file" items="${board.files}">
			<a href="/download?fileID=${file.fileID}">${file.originalName}</a>
		</c:forEach>
	</div>
	<br><br>
	<label>내용</label>
	<textarea rows="5" cols="33" readonly="readonly">${board.content}</textarea>
	
</body>
</html>