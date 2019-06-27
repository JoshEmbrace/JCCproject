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
	<link rel="shortcut icon" type="image/png" href="images/favicon.png" />
	<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
	<!-- humchim -->
	   <link rel="stylesheet" href="../css/member/join.css">

	<!--  <link rel="stylesheet" type="text/css" href="../css/style.css"> -->
	<script src="../js/member/join.js?ver=1"></script>
	<title>Sign up</title>
</head>

<body>
	<!-- --header block------------------------------------------------------------------ -->
	<!-- --body block------------------------------------------------------------------ -->
	
	<div class="main" align="center">
		<p class="su">Sign up</p>
		<section id="join">
			
			<form class="form1" align="center" method="post" action="join">
				<div>
				<input class="first" type="text" name="id" placeholder="ID" required autofocus>
				<!-- <input type="image" name="check-id" class="idchk" src="../../images/guest/check-button1.png"> -->
				<span class="check-id" value="not"></span>
			</div>
			<div>
				<input class="pass1" type="password" name="password" placeholder="Choose Password" required>
				<br>
				<span class="check-pwd" value="not"></span>
			</div>
			<div>
				<input class="pass2" type="password" name="password1"  placeholder="Retype Password" required>
				
				<span class="check-pwd1" value="not"></span>
			</div>
				<input class="first1" type="text"  name="name" placeholder="Full Name" required autofocus>
				<input class="mail" type="email" name="email_1" placeholder="Email Address" required>
				<input placeholder="Birthday" name="birthday" class="cal" type="text" onfocus="(this.type='date')" id="date" required>
				
				<div class="gen">
					<div>
					<span>Gender : </span>
					<input type="radio" name="gender" value="1"><span>Male</span>
					<input type="radio" name="gender" value="2"><span>Female</span>
					</div>
				</div><br>
				<input class="submit" type="submit" value="Sign up" align="center">
			</form>
				<!-- <table>
					<tr>
						<td id="title">아이디</td>
						<td><input type="text" name="id" maxlength="20"> <input type="button" name="check-id"
								value="중복확인">
							<span class="check-id" value="not"></span>
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
						<td>
							<input type="date" name="birthday">
						</td>
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
									placeholder="일" size="4"></td> -->
					<!-- </tr>

					<tr>
						<td id="title">이메일</td>
						<td><input type="text" name="email_1" maxlength="30">@
							<select name="email_2">
								<option value="naver.com">naver.com</option>
								<option value="daum.net">daum.net</option>
								<option value="gmail.com">gmail.com</option>
								<option value="nate.com">nate.com</option>
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
			</form> --> 

		</section>

		<!-- --footer block------------------------------------------------------------------ -->


	</div>
</body>

</html>