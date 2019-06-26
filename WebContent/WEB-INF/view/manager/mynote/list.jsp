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
<script src="../../js/student/mynote/list.js"></script>

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Document</title>
<link rel="stylesheet" type="text/css" href="../../css/manager/mynote/list.css">
<link rel="shortcut icon" type="image/png" href="../../images/manager/inc/favicon.png" />
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
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
				<h2>진행중인 모든 강좌의 공지사항 게시글을 확인합니다.</h2>
				<div class="content1">
					<header id="header">
						<h1>mynote</h1>
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
								<input type="hidden" name="writerid" value="2"> 
								<input class="com_button reg_button" type="submit" value="등록">
							</form>
						</section>
					</header>
					<p><th>첨부파일</th>
					<td><c:set var="files" value="mynoteFile${n.id}" /> <c:forEach
					var="f" items="${requestScope[files]}">
           			<a href="/temp/${f.name}" download>${f.name}</a><br>
					</c:forEach></p>
				</div>
				<div class="content1">
					<div id="body">
						<aside></aside>

						<main> <template class="mynote-template">
						<section class="list_section">
							<div class="reg_date"></div>
							<textarea class="content" name="content" cols="120"></textarea>

							<form action="edit" method="get">
								<input type="hidden" name="eid" value=""> 
								<input class="com_button ed_button" type="submit" value="수정">
							</form>

							<form action="del" method="post">
								<input type="hidden" name="did" value=""> 
								<input class="com_button ed_button" type="submit" value="삭제">
							</form>

							<%-- <button float="right"><a href="/mynote/edit?id=${n.id}">수정</a></button> --%>
							<%-- <button float="right"><a href="/mynote/del?id=${n.id}">삭제</a></button> --%>
						</section>
						</template>
					


						<section id="mynote" class="body">
							<c:forEach var="n" items="${list}">
								<section class="list_section">
									<div>${n.reg_date}</div>
									<textarea name="content" cols="120">${n.content}</textarea>

									<form action="edit" method="get">
										<input type="hidden" name="id" value="${n.id}">
										<input class="com_button ed_button" type="submit" value="수정">
										<!-- <input type="file" name="file"> -->
									</form>

									<form action="del" method="post">
										<input type="hidden" name="id" value="${n.id}"> 
										<input class="com_button ed_button" type="submit" value="삭제">
									</form>
									
									<tr>
										<th>첨부파일</th>
										<td><c:set var="files" value="mynoteFile${n.id}" /> <c:forEach
												var="f" items="${requestScope[files]}">
           								<a href="/temp/${f.name}" download>${f.name}</a><br>
											</c:forEach> <%-- <c:forEach var="m" items="mynoteFile">
                   	${m.id}
                   	<c:set var="files" value="${n.fileName}"/>
                   </c:forEach> --%> <%-- <c:forEach var="MynoteFile" items="${requestScope[files]}">
                      <c:forEach var="fff" items="${mynoteFile.filename}">
                         <a href="/temp/${MynoteFile.filename}" download>${MynoteFile.filename}</a>
                         </c:forEach> 
                      </c:forEach>
                         --%></td>
									</tr>
									<%-- <button float="right"><a href="/mynote/edit?id=${n.id}">수정</a></button> --%>
									<%-- <button float="right"><a href="/mynote/del?id=${n.id}">삭제</a></button> --%>
								</section>
							</c:forEach>

						</section>

						<section id="page-index">
							<h1 class="d-none">페이지정보</h1>
							<div>
								<span class="color-highlight font-bold">1</span> / 1 pages
							</div>
						</section>


						<div id="text-pager">
							<input type="text"> <input type="button" value="요청">
						</div>
						<!-- (진리값 혹은 진리값오게하는계산식) ? 참일경우 : 거짓일경우 --> <c:set var="page"
							value="${ (empty param.p) ? 1 : param.p}" /> <c:set var="start"
							value="${page-(page-1)%5}" /> <c:set var="end" value="" />

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
							<div id="history">
								<input type="hidden" value="2"> <input type="button"
									value="더보기">
							</div>
						</main>
					</div>
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




