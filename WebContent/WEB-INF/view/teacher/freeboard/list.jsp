<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>

<head>
<title>자유게시판</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link rel="stylesheet" href="../../css/teacher/freeboard/list.css">
<link rel="shortcut icon" type="image/png" href="../../images/teacher/inc/favicon.png" />
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<!-- <link rel="stylesheet" type="text/css" href="../../css/freeboard_list.css"> -->
<script src="../../js/teacher/freeboard/list.js"></script>
</head>

<body>
	<div id="container">
		<!-------------------------------- header -------------------------------->
		<jsp:include page="../inc/header.jsp" />
		<!-------------------------------- header -------------------------------->
		<!-------------------------------- body -------------------------------->
		<!-------------------------------- body -nav------------------------------->
		<div class="body-container">
			<jsp:include page="../inc/aside.jsp" />

			<main class="main">
			<div class="main-container">
				<!------------------- 이안에다가 내용넣으면됨 --------------------->

				<section class="list" id="freeboard">
					<h3>자유게시판</h3>

					<div id="test-pager" style="float: right;">
						<input type="text"> <input type="button" value="요청">
					</div>

					<template class="freeboard-template">
					<tr>
						<td class="num"></td>
						<td class="title"></td>
						<td class="writer"></td>
						<td class="date"></td>
						<td class="hit"></td>
					</tr>
					</template>


					<table>
						<colgroup>
							<col width="10%" />
							<col width="40%" />
							<col width="20%" />
							<col width="20%" />
							<col width="10%" />
						</colgroup>
						<thead>
							<tr>
								<td scope="col">번호</td>
								<td scope="col">제목</td>
								<td scope="col">작성자</td>
								<td scope="col">등록날짜</td>
								<td scope="col">조회수</td>
							</tr>
						</thead>

						<tbody>
							<c:forEach var="n" items="${list}">
								<tr>
									<td class="num">${n.id}</td>
									<td class="title"><a href="detail?id=${n.id}">${n.title}</a></td>
									<td class="writer">${n.writer_id}</td>
									<td class="date">${n.reg_date}</td>

								</tr>
							</c:forEach>
						</tbody>

					</table>
				</section>
				<div class="reg">
					<button class="reg_button">
						<a href="reg">글쓰기</a>
					</button>
				</div>

				<c:set var="page" value="${(empty param.p)? 1:param.p}" />
				<c:set var="start" value="${page-((page-1)%5)}" />
				<c:set var="last" value="" />

				<section id="pager">
					<div class="big-div">
						<div>
							<a href="list?p=${(page<6)?1:(start-1)}"><img src="https://cdn2.iconfinder.com/data/icons/font-awesome/1792/caret-left-128.png" style="width: 30px; max-width: 22px;"/></a>
						</div>
						<ul>
							<c:forEach begin="${start}" end="${start+4}" varStatus="s"
								var="n">
								<li><a href="list?p=${n}">${n}</a></li>
							</c:forEach>
						</ul>
						<div>
							<a href="list?p=${start+5}"><img src="https://cdn2.iconfinder.com/data/icons/font-awesome/1792/caret-right-128.png" style="width: 30px; max-width: 22px;"/></a>
						</div>
					</div>
				</section>

				<form>
					<select>
						<option>title</option>
						<option>content</option>
						<option>writer</option>
					</select> <input type="text" placeholder="Search..."> <input
						class="reg_input" type="submit" value="search">
				</form>
				
				<!------------------- 여기까지 --------------------->
			</div>
			</main>
		</div>
		<!-------------------------------- body -------------------------------->
		<!-------------------------------- footer -------------------------------->
		<jsp:include page="../inc/footer.jsp" />
		<!-------------------------------- footer -------------------------------->
	</div>

</body>

</html>