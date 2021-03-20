<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
 <div class="">
     <button type="button" id="create-board-btn">공지사항 올리기</button>
     <button type="button" id="back">메인화면으로 돌아가기</button>
 </div>
 <br>
<body>
<table>
    <thead>
        <th>제목</th>
        <th>작성자</th>
        <th>등록 시간</th>
    </thead>
    <tbody>
    	<c:forEach var="board" items="${boardList}">
	        <tr>
	            <td><a href="/board/${board.boardID}">${board.title}</a></td>
	            <td>${board.memberID}</td>
	            <td>${board.updatedDate}</td>
	        </tr>
        </c:forEach>
    </tbody>
</table>

</body>

<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script src="static/js/board.js"></script>
</html>