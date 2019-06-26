<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Document</title>
<link rel="stylesheet" href="../../layout/layout.css">
<link rel="shortcut icon" type="image/png"
	href="../../images/favicon.png" />
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">

</head>


<body>
	<!-- --header block------------------------------------------------------------------ -->
	<jsp:include page="../inc/header.jsp" />



	<!-- --body block------------------------------------------------------------------ -->


	<div class="body-container">
		<jsp:include page="../inc/aside.jsp" />
		<main>
		<div class="main-container">
			<ol class="breadcrumb">
				<li class="breadcrumb-home"><i class="material-icons md-18">home</i></li>
				<li class="b-path"><i class="material-icons"> chevron_right
				</i><span>공지사항</span></li>
			</ol>
			<section>
				<form method="post" action="edit" enctype="multipart/form-data">
					<h1>공지사항 내용2</h1>
					<table>
						<tbody>
							<tr>
								<th>writer</th>
								<td>${notice.writerId}</td>
								<th>posted-time</th>
								<td>${notice.regDate}</td>
							</tr>
							<tr>
								<th>hit</th>
								<td>${notice.hit}</td>
							</tr>
							<tr>
								<th>title</th>
								<td><input value="${notice.title}" name="title"></td>
							</tr>
							<tr>
								<th>content</th>
								<td><textarea name="content">${notice.content}</textarea></td>
							</tr>
							<c:forEach var="f" items="${noticeFile}">
								<tr>
									<th>file</th>
									<td><input type="file" name="file">${f.name}</td>
								</tr>

							</c:forEach>
							<tr>
								<th>fix-top</th>
								<td><input type="radio" name="fixtop">fix <input
									type="radio" name="fixtop">non-fix</td>
							</tr>
							<tr>
								<th>hide</th>
								<td><input type="radio">hide <input type="radio">show
								</td>
							</tr>
						</tbody>
					</table>

					<div>
						<input type="hidden" name="id" value="${notice.id}"> <input
							type="submit" value="post"> <a
							href="detail?id=${notice.id}">cancel</a>
					</div>
				</form>
			</section>
		</div>
		</main>

	</div>

	<!-- --footer block------------------------------------------------------------------ -->

	<jsp:include page="../inc/footer.jsp" />

</body>

</html>
