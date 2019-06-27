
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
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link rel="stylesheet" href="../../layout/layout.css"> 
<link rel="shortcut icon" type="image/png"
	href="../../layout/images/favicon.png" />
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">

<!-- 훔쳐온거 link들 -->
<meta http-equiv="Content-Script-Type" content="text/javascript" />
<meta http-equiv="Content-Style-Type" content="text/css" />

<link rel="stylesheet" type="text/css" href="../../css/member/register/style.css">
<link rel="stylesheet" type="text/css" href="../../css/member/register/layout.css">
</head>

<body>
	<jsp:include page="../inc/header.jsp" />
	<!-------------------------------- header -------------------------------->
	<!-------------------------------- body -------------------------------->
	<!-------------------------------- body -nav------------------------------->
	<div class="body-container">
		<jsp:include page="../inc/aside.jsp"></jsp:include>


		<main class="main">
		<div class="main-container">
			<section id="freeboard">
				<div class="sub-cont-wrap">
					<p class="sub-title">자유 게시판</p>
					<form action="reg" method="post" enctype="multipart/form-data">
						<div class="subCon">
							<div class="bbs-write-wrap">
								<dl class="write-subject">
									<dt>제목</dt>

									<dd>
										<input type="text" name="title" class="bbs-subject" />
									</dd>
								</dl>
								<dl class="write-subject">
									<dt>작성자 아이디</dt>
									<dd>
										<input type="text" name="writer_id" class="bbs-subject" />
									</dd>
								</dl>
								<dl class="write-cont">
									<dt>내용</dt>
									<dd>
										<textarea name="content" id="" placeholder="내용을 작성해주세요."
											class="editor"></textarea>
										<!-- 수정 19.06.25 -->
									</dd>
								</dl>

								<dl>
									<dt>첨부파일</dt>
									<dd>
										<input type="file" name="file" class="bbs-attach" value="첨부파일" ></input>

									</dd>
								</dl>

							</div>
							<div>
							<input type="submit" value="저장"> <a href="list">취소</a>
						</div>
						</div>
					</form>
				</div>
			</section>


			<!------------------- 여기까지 --------------------->
		</div>
		</main>
	</div>

	<!-- --- footer block----------------------------------------------------------------------------------->
	<jsp:include page="../inc/footer.jsp"></jsp:include>


</body>

</html>