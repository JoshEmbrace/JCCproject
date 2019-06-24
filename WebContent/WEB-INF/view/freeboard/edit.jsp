
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
<!-- <link rel="shortcut icon" href="img/favicon.ico"> -->

</head>

<body>
	<!-- --- header block----------------------------------------------------------------------------------->

<jsp:include page="../inc/header.jsp"></jsp:include>



	<!-- --- visual block----------------------------------------------------------------------------------->
	<div id="visual"></div>
	<!-- --- body block----------------------------------------------------------------------------------->
	<div id="body">
		<div class="content-box">

			<!-- aside -->

			<!-- aside -->

			<main>

			<section id="freeboard">
				<h1>공지사항</h1>


				<section>
					<form action="edit" method="post" enctype="multipart/form-data">
						<h1>자유게시판 수정</h1>
						<table>
							<tbody>
								<tr>
									<th>제목</th>
									<td><input name="title" value="${freeboard.title}"></td>
									<%--name은 key value는 값 --%>
								</tr>

								<tr>
									<th>내용</th>
									<td><textarea name="content">${freeboard.content}</textarea>
										<%-- <input name="title" value="${freeboard.content}"> --%></td>
								</tr>
								<tr>
									<th>파일</th>
									<td>
										<input type="file" name="file">
										 <c:forEach var="file"
											items="${files}">
									${file.name}
									<br>
										</c:forEach>
									</td>
								</tr>
							</tbody>
						</table>

						<div>
							<input type="hidden" name="id" value="${notice.id}"> <input
								type="submit" value="저장"> <a
								href="detail?id=${notice.id}">취소</a>
						</div>
					</form>
					<%-- <c:forEach var="file" items="${files}">
						${file.name}
						<br>
					</c:forEach> --%>
				</section>
			</section>
			</main>
			<!-- <div style="clear:left;">막내</div> -->
		</div>
	</div>

	<!-- --- footer block----------------------------------------------------------------------------------->
	<jsp:include page="../inc/footer.jsp"></jsp:include>

</body>

</html>