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
	<jsp:include page="../inc/header.jsp" />


	<!-- --body block------------------------------------------------------------------ -->
	<div class="body-container">
		<jsp:include page="../inc/aside.jsp" />

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
							<h4>첨부파일</h4>
							<c:forEach var="file" items="${files}">
							${file.name}<br>
							</c:forEach>
							
							<input type="file" name="file" class="file"> 
							<div class="button-box">
							<input type="submit" value="저장">
							</div>
							</form>
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
