<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body onload="document.f.username.focus();">
<h3>Login with Username and Password</h3>
<form name="f" action="/auth" method="POST">
    <table>
        <tbody>
        <tr>
            <td>User:</td>
            <td><input type="text" name="username"></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input type="password" name="password"></td>
        </tr>
        <tr>
            <td colspan="2"><input name="submit" type="submit" value="Login"></td>
        </tr>
        <input name="${_csrf.parameterName}" type="hidden" value="${_csrf.token}">
        </tbody>
    </table>
</form>
</body>
</html>