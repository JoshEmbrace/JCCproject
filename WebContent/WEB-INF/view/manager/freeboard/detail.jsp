<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유게시판</title>
<!-- <link rel="shortcut icon" href="img/favicon.ico"> -->
<link rel="stylesheet" type="text/css"
	href="../css/freeboard_detail.css">
</head>


<body>
<jsp:include page="../inc/header.jsp"></jsp:include>
	<div id="body">

		<aside></aside>
		<main>
		<section id="freeboard">
			<h3>자유게시판 내용</h3>

			<!-- 
			 0618 템플릿 적용
			<template class="freeboard-template">
			<tr>
				<td class="num"></td>
				<td class="title"><a href="detail?id="></a></td>
				<td class="writer"></td>
				<td class="date"></td>
				<td class="hit"></td>
				<td class="file"></td>
			</tr>
			</template>
			 0618 템플릿 적용 -->

			<table>
				<thead>
					<tr>
						<td>no.</td>
						<td>title</td>
						<td>content</td>
						<td>reg date</td>
						<td>hit</td>
						<td>file</td>
					</tr>
				</thead>
				<tbody>

					<tr>
						<th>제목</th>
						<td>${notice.title}</td>
					</tr>

					<tr>
						<th>내용</th>
						<td>${notice.content}</td>
					</tr>

					<tr>
						<th>작성일</th>
						<td>${notice.reg_date}</td>
					</tr>

					<tr>
						<th>조회수</th>
						<td>${notice.hit}</td>
					</tr>
					<tr>
						<th>첨부파일</th>
						<td><c:forEach var="file" items="${FreeboardFile}">
								<a href="/upload/${file.name}" download>${file.name}</a>
								<br>
							</c:forEach></td>
					</tr>

				</tbody>
			</table>
			
			<div>
				<a href="edit?id=${notice.id}">수정</a> <a href="del?id=${notice.id}">삭제</a>
			</div>
		</section>

		<section>
			<h1></h1>
			<ul>
				<li><span>이전글</span><a href="detail?id=${prev.id}">${prev.title}</a></li>
				<li><span>다음글</span><a href="detail?id=${next.id}">${next.title}</a></li>
			</ul>
		</section>

		<section>
			<h3>공지사항 검색</h3>
			<form>
				<select>
					<option>title</option>
					<option>content</option>
					<option>writer</option>
				</select> <input type="text"> <input type="submit" value="search">
			</form>
		</section>
		</main>

	</div>

<!-- --- footer block----------------------------------------------------------------------------------->
<<<<<<< HEAD
	<%-- <jsp:include page="../inc/footer.jsp"></jsp:include> --%>
<script type="javascript">
window.onload = function(){

	console.log("...");
}
</script>
=======
	<jsp:include page="../inc/footer.jsp"></jsp:include>
>>>>>>> refs/remotes/origin/master
</body>
</html>