<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유게시판</title>
<!-- <link rel="shortcut icon" href="img/favicon.ico"> -->
<!-- <link rel="stylesheet" type="text/css"
	href="../css/freeboard_detail.css"> -->
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link rel="stylesheet" href="../../layout/layout.css">
<link rel="stylesheet" href="../../css/manager/freeboard/detail.css">
<link rel="shortcut icon" type="image/png"
	href="../../layout/images/favicon.png" />
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
</head>


<body>
	<jsp:include page="../inc/header.jsp"></jsp:include>
	<div class="body-container">


		<jsp:include page="../inc/aside.jsp"></jsp:include>

		<!-- aside -->
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
				<h3>자유게시판 내용</h3>

				<table class="notice-table">
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
							<td><c:forEach var="file"
									items="${FreeboardFile}">
									<a href="/upload/${file.name}" download>${file.name}</a>
									<br>
								</c:forEach></td>
						</tr>
				</table>
				<div class="detail-btn-box">
					<form>
						<div>
							<button>
								<a href="list">list</a>
							</button>
						</div>
						<div>
							<button>
								<a href="edit?id=${notice.id}">edit</a>
							</button>
							<button>
								<a href="del?id=${notice.id}">delete</a>
							</button>
						</div>
					</form>
				</div>

			</div>

			<section>
				<h1></h1>
				<ul>
					<li><span>이전글</span><a href="detail?id=${prev.id}">${prev.title}</a></li>
					<li><span>다음글</span><a href="detail?id=${next.id}">${next.title}</a></li>
				</ul>
			</section>

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
		</main>

	</div>

	<!-- --- footer block----------------------------------------------------------------------------------->

	<script type="javascript">
window.onload = function(){

	console.log("...");
}
</script>

	<jsp:include page="../inc/footer.jsp"></jsp:include>

</body>
</html>