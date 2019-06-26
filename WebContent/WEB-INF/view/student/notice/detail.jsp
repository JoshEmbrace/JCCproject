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

<!--  <link rel="stylesheet" type="text/css" href="../css/style.css"> -->
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
				<h1>공지사항 내용</h1>
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
							<td>${notice.title}</td>
						</tr>
						<tr>
							<th>content</th>
							<td>${notice.content}</td>
						</tr>
						<c:forEach var="f" items="${noticeFile}">
							<tr>
								<th>file</th>
								<td><a href="../upload/${f.name}" download>${f.name}</a></td>
							</tr>
						</c:forEach>
						<tr>
							<th>fix-top</th>
							<td>O</td>
						</tr>
						<tr>
							<th>hide</th>
							<td>X</td>
						</tr>
					</tbody>
				</table>

				<div>
					<form>
						<button>
							<a href="list">list</a>
						</button>
					</form>
				</div>
			</section>

			<section>
				<h1></h1>
				<ul>
					<li><span>prev: </span><a href="detail?id=${prev.id}">${prev.title}</a></li>
					<li><span>next: </span><a href="detail?id=${next.id}">${next.title}</a></li>
				</ul>
			</section>
		</div>
		</main>

	</div>

	<!-- --footer block------------------------------------------------------------------ -->

	 <jsp:include page="../inc/footer.jsp" />

</body>

</html>
