<%@page import="java.util.Scanner"%>
<%@page import="java.io.FileInputStream"%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<html>
<!-- web-inf 디렉토리에 넣으면 사용자가 view를 바로 호출할 수 없다 -->

<head>
	<meta charset="UTF-8">
	<title>자유게시판</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	<link rel="stylesheet" href="/semi-JCC/css/manager/freeboard/edit.css">
	<link rel="shortcut icon" type="image/png" href="../../layout/images/favicon.png" />
	<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

</head>

<body>
	<div id="container">
		<!-- --header block------------------------------------------------------------------ -->
		<jsp:include page="../inc/header.jsp" />



		<!-- --body block------------------------------------------------------------------ -->


		<div class="body-container">
			<jsp:include page="../inc/aside.jsp" />
			<main>
				<div class="main-container">
					<!------------------- 이안에다가 내용넣으면됨 --------------------->
					<!------------------- 경로 --------------------->
					<ol class="breadcrumb">
						<li class="breadcrumb-home"><i class="material-icons md-18">home</i></li>
						<li class="b-path"><i class="material-icons"> chevron_right
							</i><span>자유게시판</span></li>
					</ol>

					<div class="main-content-box">
						<div class="content1">

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
														<c:forEach var="file" items="${files}">
															${file.name}
															<br>
														</c:forEach>
													</td>
												</tr>
											</tbody>
										</table>

										<div>
											<input type="hidden" name="id" value="${freeboard.id}"> <input type="submit"
												value="저장"> <a href="detail?id=${freeboard.id}">취소</a>
										</div>
									</form>
									<%-- <c:forEach var="file" items="${files}">
						${file.name}
						<br>
					</c:forEach> --%>
								</section>
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