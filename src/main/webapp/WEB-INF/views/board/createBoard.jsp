<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>���� ���� �ۼ�</title>
</head>
<body>
	<form id="board-form" enctype="multipart/form-data">
		<label>����</label>
		<input type="text" id="title">
		<br>
		<label>���� ���ε�</label>
		<input type="file" multiple="multiple" id="files" name="uploadFile">
		<br>
		<p>����</p>
		<hr>
		<textarea rows="5" cols="33" id="content"></textarea>
		
		<button id="submit">����</button>
	</form>
</body>

<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script src="/static/js/board.js"></script>
</html>