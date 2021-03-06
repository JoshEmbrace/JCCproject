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
	<link rel="stylesheet" href="../../css/manager/notice/list.css?ver=1">
	<link rel="shortcut icon" type="image/png" href="../../images/manager/inc/favicon.png" />
	<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

	<!--  <link rel="stylesheet" type="text/css" href="../css/style.css"> -->
	<script src="../../js/manager/notice/list.js?ver=1"></script>
</head>


<body>
	<div id="container">
		<!-- --header block------------------------------------------------------------------ -->
		<jsp:include page="../inc/header.jsp" />



		<!-- --body block------------------------------------------------------------------ -->


		<div class="body-container">
			<jsp:include page="../inc/aside.jsp" />
			<main class="main">
				<div class="main-container">
					<ol class="breadcrumb">
						<li class="breadcrumb-home"><i class="material-icons md-18">home</i></li>
						<li class="b-path"><i class="material-icons">
								chevron_right
							</i><span>공지사항</span></li>
					</ol>
					<div class="main-content-box">
						<div class="content1">
							<section id="notice">
								<h3 class="d-none">공지사항 목록</h3>
								<template class="notice-template">
									<tr>
										<td class="num"></td>
										<td class="title"><a href="detail?id=${n.id}"></a></td>
										<td class="writer"></td>
										<td class="date"></td>
										<td class="hit"></td>
									</tr>
								</template>
								<table class="notice-table">
									<thead>
										<tr>
											<td class="num">no.</td>
											<td class="title">title</td>
											<td class="writer">writer</td>
											<td class="date">date</td>
											<td class="hit">hit</td>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="n" items="${list}">
											<tr>
												<td class="num">${n.id}</td>
												<td class="title"><a href="detail?id=${n.id}">${n.title}</a></td>
												<td class="writer">${n.writerId}</td>
												<td class="date">${n.regDate}</td>
												<td class="hit">${n.hit}</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</section>
							<div class="paging-box">
								<div id="test-paper">
									<input type="text">
									<input type="button" value="요청">
								</div>
								<div>
									<c:set var="page" value="${(empty param.p)? 1:param.p}" />

									<c:set var="start" value="${page-((page-1)%5)}" />
									<c:set var="last" value="" />

									<section id="pager">
										<h1 class="d-none">페이지</h1>
										<div class="big-div">
											<div><a href="list?p=${(page<6)?1:(start-1)}"><img
														src="https://cdn2.iconfinder.com/data/icons/font-awesome/1792/caret-left-128.png"
														style="width: 30px; max-width: 22px;" /></a></div>
											<ul>
												<c:forEach begin="${ start}" end="${ start+4}" varStatus="s" var="n">
													<li><a href="list?p=${n}">${n}</a></li>
												</c:forEach>
											</ul>
											<div><a href="list?p=${start+5}"><img
														src="https://cdn2.iconfinder.com/data/icons/font-awesome/1792/caret-right-128.png"
														style="width: 30px; max-width: 22px;" /></a></div>
										</div>
									</section>
								</div>
								<div class="reg-btn">
									<form>
										<button><a href="reg">new</a></button>
									</form>
								</div>
							</div>

							<section class="search-notice">
								<h4>공지사항 검색</h4>
								<form>
									<div class="search-ele">
										<div>
											<select>
												<option>title</option>
												<option>content</option>
												<option>writer</option>
											</select>
										</div>
										<div class="search-btn">
											<input type="text">
											<input type="submit" value="search">
										</div>
									</div>
								</form>
							</section>
						</div>
					</div>
				</div>
			</main>
		</div>

		<!-- --footer block------------------------------------------------------------------ -->

		<jsp:include page="../inc/footer.jsp" />
	</div>
</body>

</html>