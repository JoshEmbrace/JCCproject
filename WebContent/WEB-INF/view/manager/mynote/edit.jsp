<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Document</title>

<link rel="stylesheet" type="text/css" href="../../css/mynote_edit.css">
</head>


<body>
	<!-- --header block------------------------------------------------------------------ -->
	<header id="header"> 
		<h1>mynote</h1>
		<section>
			<form action="edit" method="post" enctype="multipart/form-data">
				<%-- <div><%= todaydate %></div> --%>
			
				<input type="hidden" name="id" value="${mynote.id}">
				<textarea name="content" cols="40">${mynote.content}</textarea>
				<input type="file" name="file">
				<input class = "com_button" type="submit" value="저장">
				</form>
		<c:forEach var="file" items="${files}">
			${file.name}<br>
		</c:forEach>
		</section>
		
		</header>
	<!-- --body block------------------------------------------------------------------ -->



	<!-- --footer block------------------------------------------------------------------ -->

	<footer id="footer"> </footer>

</body>

</html>