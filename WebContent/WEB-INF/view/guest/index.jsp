<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="shortcut icon" type="image/png" href="/semi-JCC/images/guest/favicon.png" />
	<link href="/semi-JCC/css/guest/index.css" rel="stylesheet" type="text/css">
	<script src="/js/guest/index.js?ver=1"></script>
</head>
<body>
    <div id="wrap">
        <div id="login-container">
            <div id="image-area">
            </div>
            <div id="login-form">
                    <form action="login" method="POST">
                        <div class="input-box">
                            <div class="user_id">
                                <div>아이디</div>
                                <div><input type="text" name="user_id"></div>
                            </div>
                            <div class="user_pwd">
                                <div>비밀번호</div>
                                <div><input type="password" name="user_pwd"></div>
                            </div>
                        </div>
                        <div class="button">
                            <div><input type="submit" value="로그인"></div>
                        </div>
                        <div class="line"></div>
                        <div class="btn-list">
                            <a href="member/join"><div class="signup-btn">회원가입</div></a>
                            <div class="f-id-pwd">
                                <a href="#"><div class="f-id-btn">아이디찾기</div></a>
                                <a href="#"><div class="f-pwd-btn">비밀번호찾기</div></a>
                            </div>
                        </div>
                    </form>
                    
            </div>
        </div>
        <div id="footer">
            <span>Copyright ⓒ JOSBC Corp. All Rights Reserved.</span>
        </div>
    </div>
</body>
</html>