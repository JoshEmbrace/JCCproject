<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*, java.text.*" %>
<%
	Date date = new Date();
	SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy.MM.dd");
	String todaydate = simpleDate.format(date);
%>
<!DOCTYPE html>
<html lang="en" style="font-size: 10px">
<script src="../js/Mynote.js"></script>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Document</title>

<link rel="stylesheet" type="text/css" href="../css/mynote_list.css">
</head>


<body>
	<!-- --header block------------------------------------------------------------------ -->

<!-- //id는 고유한 이름 한 개, class는 동시에 여러개 적용 가능, 같은 이름 여러개 가능 -->
	<header id="header"> 
		<h1>mynote</h1>
		<section>
		<form action="reg" method="post" enctype="multipart/form-data">
		<!-- <form action="reg" method="post" enctype="application/x-www-form-urlencoded"> -->
			
				<div><%= todaydate %></div>
				<textarea name="content" cols="40" rows="8"></textarea>
				 
		<!--첨부파일 filename filepath  -->		
				<input type="file" name="file">
				<input type="hidden" name="id" value="241">
				<input class="com_button reg_button" type="submit" value="등록">
			</form>
		</section>
		</header>
	<!-- --body block------------------------------------------------------------------ -->


	<div id="body">
		<aside></aside>

		<main>
		<c:forEach var="n"  items="${list}">
			<section class="list_section" id="mynote">
				<div>${n.reg_date}</div>
				<%-- <a href="/mynote/edit?id=${n.id}" data-role="button">수정</a> --%>
				<textarea name="content" cols="40">${n.content}</textarea>
				
				
				
				<form action ="edit" method="get">
				<input type="hidden" name="id" value="${n.id}">
				<input class="com_button ed_button" type="submit" value="수정">
				<!-- <input type="file" name="file"> -->
				</form>
				
				<form action ="del" method="post">
				<input type="hidden" name="id" value="${n.id}">
				<input class="com_button ed_button" type="submit" value="삭제">
				</form>
				
				<%-- <button float="right"><a href="/mynote/edit?id=${n.id}">수정</a></button> --%>
				<%-- <button float="right"><a href="/mynote/del?id=${n.id}">삭제</a></button> --%>
			</section>
		</c:forEach>
			<section id="page-index">
					<h1 class="d-none">페이지정보</h1>
					<div>
						<span class="color-highlight font-bold">1</span> / 1 pages
					</div>
				</section>
				
				
				<div id="text-pager">
					<input type="text">
					<input type="button" value="요청">
				</div>
				<!-- (진리값 혹은 진리값오게하는계산식) ? 참일경우 : 거짓일경우 -->
				<c:set var="page" value="${ (empty param.p) ? 1 : param.p}"/>
				<c:set var="start" value="${page-(page-1)%5}"/>
				<c:set var="end" value=""/>
				
				<section id="pager">
					<h1 class="d-none">페이지</h1>
					<div>
						<div>이전</div>

						<ul>
							<c:forEach var="n" begin="${start}" end="${start+4}" varStatus="s">
							<%-- items="${list}" 
							<li class="current"><a href="list?p=${s.count}">${s.count}</a></li> --%>
							<li class="current"><a href="list?p=${n}">${n}</a></li>
							</c:forEach>
						</ul>
						
						<div>다음</div>
					</div>
		
		
		
		
		</main>
	</div>
	
	

	<!-- --footer block------------------------------------------------------------------ -->

	<footer id="footer"> </footer>

</body>

</html>