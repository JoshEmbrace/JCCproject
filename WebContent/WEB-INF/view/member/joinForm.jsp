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
							chevron_right </i><span>회원가입</span></li>
				</ol>
				<section id="join">
					<form method="post" action="join">
						<table>
							<tr>
								<td id="title">아이디</td>
								<td><input type="text" name="id" maxlength="20"> <input
									type="button" value="중복확인"></td>
							</tr>

							<tr>
								<td id="title">비밀번호</td>
								<td><input type="password" name="password" maxlength="15">
								</td>
							</tr>

							<tr>
								<td id="title">비밀번호 확인</td>
								<td><input type="password" name="password" maxlength="15">
								</td>
							</tr>

							<tr>
								<td id="title">이름</td>
								<td><input type="text" name="name" maxlength="40">
								</td>
							</tr>

							<tr>
								<td id="title">성별</td>
								<td><input type="radio" name="gender" value="1" checked>남
									<input type="radio" name="gender" value="2" checked>여</td>
							</tr>

							<tr>
								<td id="title">생일</td>
								<td><input type="text" name="birth_yy" maxlength="4"
									placeholder="년(4자)" size="6"> <select name="birth_mm">
										<option value="">월</option>
										<option value="01">1</option>
										<option value="02">2</option>
										<option value="03">3</option>
										<option value="04">4</option>
										<option value="05">5</option>
										<option value="06">6</option>
										<option value="07">7</option>
										<option value="08">8</option>
										<option value="09">9</option>
										<option value="10">10</option>
										<option value="11">11</option>
										<option value="12">12</option>
								</select> <input type="text" name="birth_dd" maxlength="2"
									placeholder="일" size="4"></td>
							</tr>

							<tr>
								<td id="title">이메일</td>
								<td><input type="text" name="email_1" maxlength="30">@
									<select name="email_2">
										<option>naver.com</option>
										<option>daum.net</option>
										<option>gmail.com</option>
										<option>nate.com</option>
								</select></td>
							</tr>

							<tr>
								<td id="title">휴대전화</td>
								<td><input type="text" name="phone" /></td>
							</tr>
							<tr>
								<td id="title">주소</td>
								<td><input type="text" size="50" name="address" /></td>
							</tr>
						</table>
						<br> <input type="submit" value="가입" /> 
							<a href=""><input type="button" value="취소"></a>
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
