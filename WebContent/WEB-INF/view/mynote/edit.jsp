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
</head>


<body>
	<!-- --header block------------------------------------------------------------------ -->
	<header id="header"> </header>

	<!-- --body block------------------------------------------------------------------ -->


	<div id="body">
		<aside></aside>

		<main>
		<h1>mynote</h1>
		<section>
			<form action="/mynote/list" method="post">
				<%-- <div><%= todaydate %></div> --%>
				//수정,삭제버튼 넣고
				//클릭했을때 컨트롤러랑 연결
				<button><a href="/mynote/edit?id="${n.id}">수정</a></button>
				<textarea name="content" cols="40">
				${n.content}
				</textarea>
		</section>
		</main>
	</div>

	<!-- --footer block------------------------------------------------------------------ -->

	<footer id="footer"> </footer>

</body>

</html>