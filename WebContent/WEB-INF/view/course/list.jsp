<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en" style="font-size: 20px">

<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	<title>Document</title>

	<link rel="stylesheet" type="text/css" href="../css/course_list.css">
	<script src="../js/course/list.js"></script>
</head>


<body>
	<!-- --header block------------------------------------------------------------------ -->
	<header id="header"> </header>



	<!-- --body block------------------------------------------------------------------ -->


	<div id="body">

		<aside></aside>

		<main>
			<template class="main-template">
				<tr>
					<td class="num"></td>
					<td class="name"><a href="detail?id=${n.id}"></a></td>
					<td class="teacher"></td>
					<td class="manager"></td>
					<td class="open"></td>
					<td class="end"></td>
					<td class="total"></td>
					<td class="writer"></td>
				</tr>
			</template>
			<table id="course_table">
				<colgroup>
					<col width="5%">
					<col width="*">
					<col width="10%">
					<col width="10%">
					<col width="15%">
					<col width="15%">
					<col width="5%">
					<col width="10%">
				</colgroup>
				<thead>
					<tr>
						<th>no.</th>
						<th>course</th>
						<th>teacher</th>
						<th>manager</th>
						<th>opendate</th>
						<th>enddate</th>
						<th>total</th>
						<th>writer</th>
					</tr>
				</thead>

				<tbody>
					<c:forEach var="n" items="${list}" varStatus="vs">
						<c:if test="${vs.count%2==0}">
							<tr class="even">
						</c:if>
						<c:if test="${vs.count%2!=0}">
							<tr>
						</c:if>
						<td class="num">${n.id}</td>
						<td class="name"><a href="detail?id=${n.id}">${n.name}</a></td>
						<td class="teacher">${n.teacher}</td>
						<td class="manager">${n.manager}</td>
						<td class="open">
							<fmt:parseDate var="open" value="${n.openDate}" pattern="yyyy-MM-dd" />
							<fmt:formatDate value="${open}" pattern="yyyy-MM-dd" />
						</td>
						<td class="end">
							<fmt:parseDate var="end" value="${n.endDate}" pattern="yyyy-MM-dd" />
							<fmt:formatDate value="${end}" pattern="yyyy-MM-dd" />
						</td>
						<td class="total">${n.total}</td>
						<td class="writer">${n.writerId}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>

			<div class="input">
				<input type="text" value="1">
				<input type="button" value="요청">
			</div>

			<div class="right">
				<a href="reg?id=${n.id}"><img src="../images/course/add-btn.png" width="30px" height="30px"></a>
			</div>

			<section id="pager">
				<h1 class="d-none">페이지</h1>
				
				<div class="box">
					<c:set var="page" value="${empty param.p? 1:param.p}" />
					<div>
						<a href="list?p=${(page<6)?page:page-5}">
							<img src="../images/course/left-btn.png" width="15px" height="15px">
						</a>
					</div>
					<ul>
						<c:set var="start" value="${page-(page-1)%5}" />
						<c:set var="last" value="" />

						<c:forEach begin="${start}" end="${start+4}" var="x">
							<c:if test="${empty param.p and x==1}">
								<li class="current">
							</c:if>
							<c:if test="${param.p == x}">
								<li class="current">
							</c:if>
							<a href="list?p=${x}">${x}</a></li>
						</c:forEach>
					</ul>
					<div>
						<a href="list?p=${page+5}">
							<img src="../images/course/right-btn.png" width="15px" height="15px">
						</a>
					</div>
				</div>
			</section>
		</main>
	</div>

	<!-- --footer block------------------------------------------------------------------ -->

	<footer id="footer"> </footer>

</body>

</html>