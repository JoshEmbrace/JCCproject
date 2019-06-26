<%@page import="com.jhtacybercampus.web.entity.MynoteFile"%>
<%@page import="com.jhtacybercampus.web.entity.MynoteView"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.util.*, java.text.*"%>

<!DOCTYPE html>
<html>
<script src="../../js/teacher/mynote/list.js"></script>

<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	<title>Document</title>
	<link rel="stylesheet" type="text/css" href="../../css/teacher/mynote/list.css?ver=1">
	<link rel="shortcut icon" type="image/png" href="../../images/teacher/inc/favicon.png" />
	<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
</head>


<body>
	<!-- --header block------------------------------------------------------------------ -->
	<jsp:include page="../inc/header.jsp" />

	<!-- --body block------------------------------------------------------------------ -->
	<div class="body-container">
		<jsp:include page="../inc/aside.jsp" />

		<main class="main">
			<div class="main-container">
				<ol class="breadcrumb">
					<li class="breadcrumb-home"><i class="material-icons md-18">home</i></li>
					<li class="b-path"><i class="material-icons"> chevron_right
						</i><span>공지사항</span></li>
				</ol>
				<div class="main-content-box">
					<h1>현재까지 등록된 MY NOTE</h1>
					<div class="content1">
						<header id="header">
							<h2>NEW mynote</h2>
							<section>
								<form action="reg" method="post" enctype="multipart/form-data">
									<!-- <form action="reg" method="post" enctype="application/x-www-form-urlencoded"> -->

									<div class="reg_date">
										<fmt:formatDate value="${today}" pattern="yyyy-MM-dd" />
										<jsp:useBean id="toDay" class="java.util.Date" />
										<c:out value="${today}" />
									</div>
									<textarea class="content" name="content" cols="120" rows="10"
										placeholder="&#13;&#10;안녕하세요 마이노트 등록 칸 입니다.&#13;&#10;기록하고 싶은 내용을 자유롭게 작성해주세요 ^0^&#13;&#10;"></textarea>

									<!--첨부파일 filename filepath  -->
									<input class="file" type="file" name="file">
									<div class="regbutton-form">
										<input type="hidden" name="writerid" value="2">
										<div class="regbutton">
											<input type="submit" value="등록">
										</div>
									</div>
								</form>
							</section>
						</header>
						<!-- <p>
							<td>
								<c:set var="files" value="mynoteFile${n.id}" />
								<c:forEach var="f" items="${requestScope[files]}">
									<a href="/temp/${f.name}" download>${f.name}</a><br>
								</c:forEach></td>
						</p> -->
					</div>


					<div class="content1">
						<div id="body">
							<aside></aside>

							<main> <template class="mynote-template">
									<section class="list_section">
										<div class="reg_date">
											<div><textarea class="content" name="content"></textarea></div>
											<div class="button-box">
												<div class="editbutton-form">
													<form action="edit" method="get">
														<input type="hidden" name="eid" value=""> <input type="submit"
															value="수정">
													</form>
												</div>
												<div class="delbutton-form">
													<form action="del" method="post">
														<input type="hidden" name="did" value=""> <input type="submit"
															value="삭제">
													</form>
												</div>
											</div>
									</section>
								</template>



								<section id="mynote" class="body">
									<c:forEach var="n" items="${list}">
										<section class="list_section">
											<div>${n.reg_date}</div>
											<textarea name="content">${n.content}</textarea>

											<div class="button-box">
												<form action="edit" method="get">

													<input type="hidden" name="id" value="${n.id}"> <input type="submit"
														value="수정">
													</span>
												</form>

												<form action="del" method="post">

													<input type="hidden" name="id" value="${n.id}"> <input type="submit"
														value="삭제">
													</span>
												</form>
											</div>

											<div class="uploadfile">
												<h4>첨부파일</h4>
												<div>
													<c:set var="files" value="mynoteFile${n.id}" />
													<c:forEach var="f" items="${requestScope[files]}">
														<a href="/temp/${f.name}" download>${f.name}</a>
													</c:forEach>
												</div>
											</div>
										</section>
									</c:forEach>
								</section>
						</div>
					</div>

					<div class="page-index-js">
						<section id="page-index" class="page-index">
							<h3 class="d-none">페이지정보</h3>
							<div id="text-pager" class="text-pager">
								<input type="text"> <input type="button" value="요청">
							</div>
							<!-- (진리값 혹은 진리값오게하는계산식) ? 참일경우 : 거짓일경우 -->
							<c:set var="page" value="${ (empty param.p) ? 1 : param.p}" />
							<c:set var="start" value="${page-(page-1)%5}" />
							<c:set var="end" value="" />
						</section>
						<div>
							<span class="color-highlight font-bold">1</span> / 1 pages
						</div>
					</div>


					<div class="paging">
						<section id="pager" class="pager">
							<h3 class="d-none">페이지</h3>
							<div>
								<div>이전</div>
								<ul class="paging-number">
									<c:forEach var="n" begin="${start}" end="${start+4}" varStatus="s">
										<%-- items="${list}" 
								<li class="current"><a href="list?p=${s.count}">${s.count}</a></li> --%>
										<li class="current"><a href="list?p=${n}">${n}</a></li>
									</c:forEach>
								</ul>

								<div>다음</div>
							</div>

					</div>


					<div id="more" class="more">
						<input type="hidden" value="2">
						<input type="button" value="더보기">
					</div>
		</main>
	</div>
	</div>
	</div>
	</main>
	</div>
	<!-- --footer block------------------------------------------------------------------ -->
	<footer class="footer">
		<div class="footer-container">
			<span>© Copyright JOSBC</span>
		</div>
	</footer>

	</div>

</body>

</html>