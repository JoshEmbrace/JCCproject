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
<script src="../js/list.js?ver=1"></script>
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


<<<<<<< HEAD
			<!--  0618 템플릿 적용-->
			<template class="freeboard-template">
			<tr>
				<td class="num"></td>
				<td class="title"><a href=""></a></td>
				<td class="writer"></td>
				<td class="date"></td>
				<td class="hit"></td>
			</tr>
			</template>
			<!--  0618 템플릿 적용-->

			<div id="test-pager" style="float:right;">
				<input type="text"> <input type="button" value="요청">
			</div>


=======
		<!--  0618 템플릿 적용-->
			<template class="freeboard-template">
				<tr>
					<td class="num"></td>
					<td class="title"><a href="detail?id="></a></td>
					<td class="writer"></td>
					<td class="date"></td>
					<td class="hit"></td>
				</tr>
			</template>
				<!--  0618 템플릿 적용-->
			
>>>>>>> refs/remotes/origin/master
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
<<<<<<< HEAD
						<td class="title"><a id="abc" href="detail?id=${n.id}">${n.title}</a></td>
=======
						<td class="title"><a href="detail?id=${n.id}"> ${n.title}</td>
>>>>>>> refs/remotes/origin/master
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

		<!--  (진리값 혹은 진리값오게하는계산식) ? 참일경우 : 거짓일경우 --> <c:set var="page"
			value="${ (empty param.p) ? 1 : param.p}" /> <c:set var="start"
			value="${page-(page-1)%5}" /> <c:set var="end" value="" />

<<<<<<< HEAD
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
		</section>
=======
		<!--  (진리값 혹은 진리값오게하는계산식) ? 참일경우 : 거짓일경우 -->
					<c:set var="page" value="${ (empty param.p) ? 1 : param.p}" />
					<c:set var="start" value="${page-(page-1)%5}" />
					<c:set var="end" value="" />
					
		<section id="pager">
						<h1 class="d-none">페이지</h1>
						<div>
							<div>이전</div>

							<ul>
								<c:forEach var="n" begin="${start}" end="${start+4}"
									varStatus="s">
									<%-- items="${list}" 
							<li class="current"><a href="list?p=${s.count}">${s.count}</a></li> --%>
									<li class="current"><a href="list?p=${n}">${n}</a></li>
								</c:forEach>
							</ul>

							<div>다음</div>
						</div>
					</section>
>>>>>>> refs/remotes/origin/master

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