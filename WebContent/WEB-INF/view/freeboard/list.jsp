<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html lang="en" style="font-size: 10px">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>자유게시판</title>
<script src="../js2/freeboard/list.js"></script>
<link rel="stylesheet" type="text/css" href="../css/freeboard_list.css">
</head>


<body>
	<!-- --header block------------------------------------------------------------------ -->
	<header id="header"> </header>



	<!-- --body block------------------------------------------------------------------ -->


	<aside></aside>
	<div id="body">


		<main>
		<section class="list" id="freeboard">
			<h3>자유게시판</h3>
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
					<c:forEach var="n" varStatus="status" items="${list}">
						<c:if test="${status.count%2 ==0}">
							<tr class="even">
						</c:if>
						<c:if test="${status.count%2 !=0}">
							<tr>
						</c:if>

						<td class="num">${n.id}</td>
						<td class="title"><a href="detail?id=${n.id}">
								${n.title}</td>
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

		<!--  페이지 --------------------------------------------------->
		<section id="page-index">
			<h1 style="font-size: 2rem" class="d-none">페이지 정보</h1>
			<div>
				<span class="color-highlight font-bold">1</span> / 1 pages
			</div>
		</section>

		<div id="test-pager">
			<input type="text"> <input type="button" value="요청">
		</div>

		<section id="pager">
			<h1 class="d-none">페이지</h1>
			<div>
				<c:set var="page" value="${empty param.p? 1:param.p}" />
				<div>
					<a href="list1?p=${(page<6)?page:page-5}">이전</a>
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
						<a href="list1?p=${x}">${x}</a>
						</li>
					</c:forEach>


				</ul>
				<div>
					<a href="list1?p=${page+5}">다음</a>
				</div>
			</div>
		</section>


		<section>
			<h3>검색</h3>
			<form>
				<select>
					<option>title</option>
					<option>content</option>
					<option>writer</option>
				</select> <input type="text" placeholder="Search..."> <input
					class="reg_input" type="submit" value="search">
			</form>
		</section>
		</main>

	</div>

	<!-- --footer block------------------------------------------------------------------ -->

	<footer id="footer"> </footer>

</body>

</html>