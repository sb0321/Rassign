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
	<label>����</label>
	<p>${board.title}</p>
	<label>�ۼ���</label>
	<p>${board.memberID}</p>
	<label>���� ���� ��¥</label>
	<p>${board.createdDate}</p>
	<label>���� ������Ʈ ��¥</label>
	<p>${board.updatedDate}</p>
	<br><br>
	<label>����</label>
	<textarea rows="5" cols="33" readonly="readonly">${board.content}</textarea>
	
</body>
</html>