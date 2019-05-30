
<%@page import="java.util.Scanner"%>
<%@page import="java.io.FileInputStream"%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en" style="font-size: 10px">
<!-- web-inf 디렉토리에 넣으면 사용자가 view를 바로 호출할 수 없다 -->
<head>
<meta charset="UTF-8">
<title>Document</title>
<link rel="shortcut icon" href="img/favicon.ico">
<link href="../css/style2.css" type="text/css" rel="stylesheet">

</head>

<body>
	<!-- --- header block----------------------------------------------------------------------------------->
<jsp:include page="../inc/header.jsp"></jsp:include>
	


	<!-- --- visual block----------------------------------------------------------------------------------->
	<div id="visual">
		<div class="content-box" style="position: static">

			<!-- <div style="
            width:100px; height:100px; border:1px solid red;
        background: url(https://i.uncyclopedia.kr/pedia/7/7c/%EC%9E%91%EC%9D%80%ED%95%98%EB%A7%883.png);
        background-size: cover;
        background-attachment:fixed;">
        <span style="left:1000px; top:1000px; position:absolute;">왜저랩사진</span>
      <img src="https://i.uncyclopedia.kr/pedia/7/7c/%EC%9E%91%EC%9D%80%ED%95%98%EB%A7%883.png"> -->
			<!-- <span style="margin-left:-50px">웅이왜저랩사진</span> -->
			<!-- <img src="http://cdn.sketchpan.com/member/m/mssng486/mandala/1332657085387/0.png"> -->
			<!-- </div> -->
		</div>
	</div>
	<!-- --- body block----------------------------------------------------------------------------------->
	<div id="body">
		<div class="content-box">

<!-- aside -->

<jsp:include page="../inc/aside.jsp"></jsp:include>
	
		<!-- 	<aside>
				<h1 id="aside-title">고객센터</h1>

				<nav id="customer-menu">
					<h1>고객센터메뉴</h1>
					<ul id="customer-list" class="menu-list">
						<li><a href="">공지사항</a></li>
						<li><a href="">자주하는 질문</a></li>
						<li><a href="">수강문의</a></li>
						<li><a href="">이벤트</a></li>
					</ul>
				</nav>

				<nav id="coworker" class="menu-list">
					<h1>협력업체</h1>
					<ul>
						<li><a href="">노트펍스</a></li>
						<li><a href="">나무랩연구소</a></li>
						<li><a href="">한빛미디어</a></li>
					</ul>
				</nav>
			</aside> -->

<!-- aside -->

			<main>

			<section>
				<h1>공지사항</h1>

				<section id="breadcrumb">
					<h1 class="d-none">경로</h1>
					<ol>
						<li>home</li>
						<li>고객센터</li>
						<li>공지사항</li>
					</ol>
				</section>

				<section>
					<form action="edit" method="post">
						<h1>공지사항 내용</h1>
						<table>
							<tbody>

								<tr>
									<th>제목</th>
									<td><input  name ="title" value="${notice.title}"></td> <%--name은 key value는 값 --%>
								</tr>

								<tr>
									<th>작성일</th>
									<td>${notice.regDate}</td>
								</tr>

								<tr>
									<th>내용</th>
									<td><textarea name="content">${notice.content}</textarea></td>
								</tr>
							</tbody>
						</table>

						<div>
							<input type="hidden"  name="id"  value="${notice.id}">
							<input type="submit" value="저장">
							<%-- input type="button" value="취소" onclick="history.back(-1);"--%>
							<a href="detail?id=${notice.id}">취소</a>
						</div>
					</form>
				</section>                
			</main>
			<!-- <div style="clear:left;">막내</div> -->
		</div>
	</div>

	<!-- --- footer block----------------------------------------------------------------------------------->
	<jsp:include page="../inc/footer.jsp"></jsp:include>

</body>

</html>