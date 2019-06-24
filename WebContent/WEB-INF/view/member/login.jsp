<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en" style="font-size: 10px">

<head>
<link href="../css/style.css" type="text/css" rel="stylesheet">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Document</title>
<link rel="stylesheet" href="../layout/layout.css">
<link rel="shortcut icon" type="image/png" href="images/favicon.png" />
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">

<!--  <link rel="stylesheet" type="text/css" href="../css/style.css"> -->
<script src="../js/notice/list.js"></script>
</head>


<body>
	<div id="container">
		<!-- --header block------------------------------------------------------------------ -->
		<jsp:include page="../inc/header.jsp" />



		<!-- --body block------------------------------------------------------------------ -->


		<div class="body-container">
			<nav class="nav">
				<ul class="nav-container">
					<li><a href="#Mynote"><i class="material-icons md-36">description</i><span>My
								note</span></a></li>
					<li><a href="#Curriculum"><i class="material-icons md-36">date_range</i><span>Curriculum</span></a>
					</li>
					<li><a href="#Homework"><i class="material-icons md-36">dvr</i><span>Homework</span></a>
					</li>
					<li class="dropdown-menu"><a href="../notice/list"><i
							class="material-icons md-36">apps</i><span>Notice</span><i
							class="material-icons md-36">expand_more</i></a>
						<ul class="dropdown-container">
							<li><a href="">Notice</a></li>
							<li><a href="">Freeboard</a></li>
						</ul></li>
				</ul>
			</nav>
			<script>
                var dropdown = document.getElementsByClassName(".dropdown-menu");

                for (var i = 0; i < dropdown.length; i++) {
                    dropdown[i].addEventListener("click", function () {
                        this.classList.toggle("active");
                        var dropdownContent = this.nextElementSibling;
                        if (dropdownContent.style.display === "block") {
                            dropdownContent.style.display = "none";
                        } else {
                            dropdownContent.style.display = "block";
                        }
                    });
                }
            </script>
			<main>
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
					<form name="loginInfo" method="post" action="login">

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
						<br> <input type="submit" value="로그인" /> <input type="button"
							value="회원가입"/>
					</form>

				</section>
			</div>
			</main>
		</div>

		<!-- --footer block------------------------------------------------------------------ -->

		<jsp:include page="../inc/footer.jsp" />
	</div>
</body>

</html>

