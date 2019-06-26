<%@page import="com.jhtacybercampus.web.entity.MynoteFile"%>
<%@page import="com.jhtacybercampus.web.entity.MynoteView"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<!-- <html lang="en" style="font-size: 10px"> -->
<script src="../../js/teacher/mynote/Mynote.js"></script>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Document</title>
<link rel="stylesheet" type="text/css" href="../../css/mynote_edit.css">
<link rel="shortcut icon" type="image/png" href="images/favicon.png" />
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
</head>
<body>
	<!-- --header block------------------------------------------------------------------ -->
	<header class="header">
		<div class="header-container">
			<div class="logo">
				<img src="images/logo.png" alt="">
			</div>
			<div class="usermenu">
				<ul class="usermenu-container">
					<li class="user-name">Yijin So</li>
					<li class="user-image"><a href=""><i
							class="material-icons md-36">account_circle</i></a></li>
					<li class="user-course"><a href=""><i
							class="material-icons md-36">class</i></a></li>
					<li class="user-alert"><a href=""><i
							class="material-icons md-36">notifications</i></a></li>
					<li class="user-log"><a href="">logout</a></li>
				</ul>
			</div>
		</div>
	</header>


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
				<li class="dropdown-menu"><a href="#Notice"><i
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
				dropdown[i].addEventListener("click", function() {
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

		<main class="main">
		<div class="main-container">
			<ol class="breadcrumb">
				<li class="breadcrumb-home"><i class="material-icons md-18">home</i></li>
				<li class="b-path"><i class="material-icons"> chevron_right
				</i><span>공지사항</span></li>
			</ol>
			<div class="main-content-box">
				<h1>MY NOTE 수정 중...</h1>
				<div class="content1">
					<header id="header">
					<h2>EDIT mynote</h2>
						<section class="edit-section">
							<form action="edit" method="post" enctype="multipart/form-data">
								<%-- <div><%= todaydate %></div> --%>

								<input type="hidden" name="id" value="${mynote.id}">
								<textarea name="content" cols="40">${mynote.content}</textarea>
							</form>
							<h4>첨부파일</h4>
							<c:forEach var="file" items="${files}">
							${file.name}<br>
							</c:forEach>
							
							<input type="file" name="file" class="file"> 
							<div class="button-box">
							<input type="submit" value="저장">
							</div>
						</section>

					</header>

	</div>

	</div>
<!-- --footer block------------------------------------------------------------------ -->
<footer class="footer">
		<div class="footer-container">
			<span>© Copyright JOSBC</span>
		</div>
	</footer>


</body>

</html>
