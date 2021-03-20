<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta>
        <title>회원가입</title>
    </head>
    <body>
        <form method="post" id="register-form">
        <label for="name">아이디</label>
        <input type="text" name="name" value="" id="name">
        <button type="button" name="duplicate-check" id="duchk-btn">중복 체크</button>

        <label for="name">비밀번호</label>
        <input type="password" name="password" value="" id="password">
        
        <label for="nickname">닉네임</label>
        <input type="text" name="nickname" id="nickname">

        <button type="button" id="reg-btn" disabled>회원가입</button>
        </form>
    </body>

    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script src="static/js/register.js"></script>
</html>