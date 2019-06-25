<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en" style="font-size: 10px">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Document</title>
<link rel="stylesheet" href="../layout/layout.css">
<link rel="shortcut icon" type="image/png" href="images/favicon.png" />
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<script src="../js/member/mypage.js" ></script>
<!--  <link rel="stylesheet" type="text/css" href="../css/style.css"> -->

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
							chevron_right </i><span>회원정보</span></li>
				</ol>
				<section id="join">
					<form method="post">
						<table>
							<tr>
								<td id="title">아이디</td>
                                <td>
                                    ${sessionScope.user["user_id"]}
                                    <input type="hidden" name="id" value="${sessionScope.user['user_id']}">
                                </td>
							</tr>

							<tr>
								<td id="title">비밀번호</td>
								<td><input type="password" name="password" maxlength="15">
									<span class="check-pwd" value="not"></span>
								</td>
							</tr>

							<tr>
								<td id="title">비밀번호 확인</td>
								<td><input type="password" name="password1" maxlength="15">
								<span class="check-pwd1" value="not"></span>
								</td>
							</tr>

							<tr>
								<td id="title">이름</td>
								<td>${sessionScope.user["name"]}</td>
							</tr>

							<tr>
								<td id="title">성별</td>
								<td>${(sessionScope.user["gender"] == 1)?"남자":"여자"}</td>
							</tr>

							<tr>
								<td id="title">생일</td>
								<td>${sessionScope.user["birthday"]}</td>
							</tr>

							<tr>
								<td id="title">이메일</td>
								<td>${sessionScope.user["email"]}</td>
							</tr>

							<tr>
								<td id="title">휴대전화</td>
								<td>${sessionScope.user["hp"]}</td>
							</tr>
							<tr>
								<td id="title">주소</td>
								<td>주소</td>
							</tr>
						</table>
						<br> <input type="submit" value="수정" /> 
							<a href="../notice/list.jsp"><input type="button" value="취소"></a>
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
