<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	<title>Document</title>
	<link rel="shortcut icon" type="image/png" href="../images/manager/inc/favicon.png" />
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
	<link rel="stylesheet" href="../css/member/login.css">

	<!--  <link rel="stylesheet" type="text/css" href="../css/style.css"> -->

</head>

<body>
	<div id="container">
		<!-------------------------------- header -------------------------------->
		<jsp:include page="inc/header.jsp" />
		<!-------------------------------- header -------------------------------->
		<!-------------------------------- body -------------------------------->
		<!-------------------------------- body -nav------------------------------->
		<div class="body-container">

			<main class="main">
				<div class="main-container">
					<ol class="breadcrumb">
						<li class="breadcrumb-home"><i class="material-icons md-18">home</i></li>
						<li class="b-path"><i class="material-icons">
								chevron_right </i><span>로그인</span></li>
					</ol>
					<section id="login">
						<h1>로그인 폼</h1>
						<c:if test="${param.error==1}">
							<div style="color: red">아이디 또는 비밀번호가 유효하지 않습니다.</div>
						</c:if>
						<form name="loginInfo" method="post">

							<table>
								<tr>
									<td bgcolor="skyblue">아이디</td>
									<td><input type="text" name="user_id" maxlength="50"></td>
								</tr>
								<tr>
									<td bgcolor="skyblue">비밀번호</td>
									<td><input type="password" name="user_pwd" maxlength="50"></td>
								</tr>
							</table>
							<br> <input type="submit" value="로그인" /> <input type="button" value="회원가입" />
						</form>
					</section>
					<!------------------- 여기까지 --------------------->
				</div>
			</main>

		</div>
		<!-------------------------------- body -------------------------------->
		<!-------------------------------- footer -------------------------------->
		<jsp:include page="inc/footer.jsp" />
		<!-------------------------------- footer -------------------------------->
	</div>

</body>


</html>