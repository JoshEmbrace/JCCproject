<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/css/guest/index.css" rel="stylesheet" type="text/css">
<script src="/js/guest/index.js"></script>
</head>
<body>
    <div id="login-form">
    <form action="member/login" method="POST">
        <div>
            <div class="user_id">
                <span>아이디 : </span>
                <input type="text" name="user_id">
            </div>
            <div class="user_pwd">
                <span>비밀번호 : </span>
                <input type="password" name="user_pwd">
            </div>
        </div>
        <div class="button">
            <div><input type="submit" value="로그인"></div>
            <div class="signup-btn">회원가입</div>
        </div>
    </form>
    </div>
</body>
</html>