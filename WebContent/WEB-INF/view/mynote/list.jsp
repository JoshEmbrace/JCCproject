<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.text.*" %>
<%
	Date date = new Date();
	SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy.MM.dd");
	String todaydate = simpleDate.format(date);
%>
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
		<c:forEach var="n"  items="${list}">
			<section>
				<div>오늘날짜:${n.reg_date}</div>
				//수정,삭제버튼 넣고
				<button><a href="/mynote/del?id=${n.id}"></a>삭제</button>
				<textarea name="content" cols="40">
				${n.content}
				</textarea>
			</section>
		</c:forEach>
		
		<section>
			<form action="reg" method="post">
			
				<div><%= todaydate %></div>
				<textarea name="content" cols="40" rows="8">
				</textarea>
				//첨부파일
				//filename filepath 
				
				<input type="submit" value="등록">
			</form>
			</section>
	
		</main>
	</div>
	
	

	<!-- --footer block------------------------------------------------------------------ -->

	<footer id="footer"> </footer>

</body>

</html>