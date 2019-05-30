<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en" style="font-size: 10px">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Document</title>

<link rel="stylesheet" type="text/css" href="../css/style.css">
<style>
.planbook-title {
	padding: 10px 20px;
	font-weight: normal;
	font-size: 1.5em;
	background: #2d2d2d;
	color: #fff
}

.planbook-wrap {
	padding: 20px;
	border: 1px solid #ddd;
	background: #fff
}

/* planbook Form */
.planbook-form dl.planbook-t dt {
	position: absolute;
	width: 1px;
	height: 1px;
	padding: 0;
	margin: -1px;
	overflow: hidden;
	clip: rect(0, 0, 0, 0);
	border: 0;
}

.planbook-form dl.planbook-t dd {
	margin-bottom: 10px
}

.planbook-form dl.planbook-t dd input {
	width: 100%;
	padding: 10px 0;
	border: 1px solid #ddd;
	background: #f9f9f9;
	color: #999;
	text-indent: 10px;
}

.planbook-form dl.planbook-t dd input:focus, .planbook-form dl.planbook-t dd input:active
	{
	background: #fff;
	color: #111
}

.planbook-form dl.planbook-write {
	margin-top: 10px;
}

.planbook-form dl.planbook-write dt {
	position: absolute;
	width: 1px;
	height: 1px;
	padding: 0;
	margin: -1px;
	overflow: hidden;
	clip: rect(0, 0, 0, 0);
	border: 0;
}

.planbook-form table {
	width: 100%;
	margin-bottom: 10px;
	padding: 10px 0;
	height: 200px;
	border: 1px solid #ddd;
	background: #f9f9f9;
	color: #999;
	text-indent: 10px;
}

.planbook-form table td {
	margin-bottom: 10px;
	height: indent;
	border: 1px solid #ddd;
}
.planbook-form dl.planbook-write dd textarea {
	width: 100%;
	margin-bottom: 10px;
	padding: 10px 0;
	height: 200px;
	border: 1px solid #ddd;
	background: #f9f9f9;
	color: #999;
	text-indent: 10px;
}

.planbook-form dl.planbook-write dd textarea:focus, .planbook-form dl.planbook-write dd textarea:active
	{
	background: #fff;
	color: #111
}

.planbook-form button {
	display: block;
	width: 100%;
	margin: 10px 0 0 0;
	padding: 10px 0;
	border: 1px solid #ff7035;
	background: #ff8149;
	color: #fff;
	text-align: center;
}


.planbook-form .bbb {
	display: inline-block;
	width: 300px;
	margin: 10px 0 0 0;
	padding: 10px 0;
	border: 1px solid #ff7035;
	background: #ff8149;
	color: #fff;
	text-align: center;
}
</style>
</head>


<body>
	<!-- --header block------------------------------------------------------------------ -->
	<header id="header"> </header>

	<!-- --body block------------------------------------------------------------------ -->


	<div id="body">
		<aside></aside>

		<main>
		<h1>커리큘럼</h1>
		<section>
			<h1>기본정보</h1>
			<table border=1>
				<tr>
					<th>과정명</th>
					<td>자바자바자바자바</td>
					<th>훈련기간</th>
					<td>2019.01.01 ~ 2019.01.01</td>
				</tr>
				<tr>
					<th>선생님</th>
					<td>박용우</td>
					<th>전화번호</th>
					<td>010-1234-5678</td>
				</tr>
				<tr>
					<th>이메일</th>
					<td colspan="3">abcdefg@naver.com</td>
				</tr>
			</table>
		</section>

		<section>

			<h1 id="planbookBody" class="planbook-title">planbook</h1>
			<div class="planbook-wrap">
				<form method="post" action="reg">
				<div class="planbook-form">
					<fieldset>
						<legend class="sr-only">계획쓰기란</legend>
						<dl class="planbook-t">
							<dt>
								<label for="input_title">제목</label>
							</dt>
							<dd>
								<input type="text" name="title" placeholder="제목"
									title="제목 입력">
							</dd>
						</dl>
						<dl class="planbook-write">
							<dt>
								<label>내용</label>
							</dt>
							<dd>
								<textarea name="content"
									placeholder="단위 기간당 강의하실 계획을 입력해주세요(하루, 한주 혹은 그 이상의 기간)"
									title="내용 이력"></textarea>
							</dd>
						</dl>
						<%-- <div><input type="hidden" value="${list[0].id}" name="id"></div> --%>
						<button type="submit" class="reply-btn">
							<i class="fa fa-send"></i>내용 저장
						</button>
					</fieldset>
				</div>
				</form>
			</div>

			<c:forEach var="curri" items="${list}">
				<div class="planbook-wrap">

					<div class="planbook-form">
						<table class="planbook-write">
							<tr>
								<td>${curri.title}</td>
								<td>${curri.reg_date}</td>
							</tr>
							<tr>
								<td colspan="2">${curri.content}</td>
							</tr>
						</table>
						<div class="aaa">
							<a href="edit?id=${curri.id}"><div class="bbb">수정</div></a>
							<a href="del?id=${curri.id}"><div class="bbb">삭제</div></a>
						</div>
					</div>
				</div>
			</c:forEach>

		</section>

		</main>

	</div>

	<!-- --footer block------------------------------------------------------------------ -->

	<footer id="footer"> </footer>

</body>

</html>