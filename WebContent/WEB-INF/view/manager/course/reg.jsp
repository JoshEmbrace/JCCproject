<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <link rel="shortcut icon" type="image/png" href="../../images/inc/favicon.png" />
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
	<link rel="stylesheet" href="../../css/manager/course/reg.css?ver=1">
	<script src="../../js/manager/course/reg.js?ver=1"></script>
</head>


<body>
	<div id="container">
		<!-------------------------------- header -------------------------------->
		<jsp:include page="../inc/header.jsp" />
		<!-------------------------------- header -------------------------------->
		<!-------------------------------- body -------------------------------->
		<!-------------------------------- body -nav------------------------------->
		<div class="body-container">
			
			<jsp:include page="../inc/aside.jsp" />

			<main class="main">
				<div class="main-container">
					<!------------------- 이안에다가 내용넣으면됨 --------------------->
					<!------------------- 경로 --------------------->
					<ol class="breadcrumb">
						<li class="breadcrumb-home"><i class="material-icons md-18">home</i></li>
						<li class="b-path"><i class="material-icons">
								chevron_right
							</i><span>Course</span></li>
						<li class="b-path"><i class="material-icons">
								chevron_right
							</i><span>등록</span></li>
					</ol>
					<div class="main-content-box">
						<h2>Course 등록</h2>
						<form method="post" action="reg">
							<div class="content1">
								<table id="course_table">
									<colgroup>
										<col width="15%">
										<col width="25%">
										<col width="15%">
										<col width="25%">
									</colgroup>
									<tr>
										<th>Course</th>
										<td><input type="text" name="name"></td>
										<th>Total</th>
										<td><input type="text" name="total"></td>
									</tr>

									<tr>
										<th>Start date</th>
										<td><input type="date" name="openDate"></td>
										<th>End date</th>
										<td><input type="date" name="endDate"></td>
									</tr>

									<tr>
										<th>Teacher</th>
										<td><select name="teacher">
												<c:forEach var="teacher" items="${teachers}">
													<option value="${teacher.id}">${teacher.name}
												</c:forEach>
											</select></td>
										<!-- <td><input type="text" name="teacher"></td> -->
										<th>Manager</th>
										<td><select name="manager">
												<c:forEach var="manager" items="${managers}">
													<option value="${manager.id}">${manager.name}
												</c:forEach>
											</select></td>
										<!-- <td><input type="text" name="manager"></td> -->
									</tr>

									<tr>
										<th>Student</th>
										<td colspan="3"></td>
									</tr>
								</table>
							</div>
							<div class="content1">
								<div>
									<input type="submit" value="확인">
								</div>
								<div>
									<a href="list">취소</a>
								</div>
							</div>
						</form>
					</div>


					<!------------------- 여기까지 --------------------->
				</div>
			</main>
		</div>
		<!-------------------------------- body -------------------------------->
		<!-------------------------------- footer -------------------------------->
		<footer class="footer">
			<div class="footer-container">
				<span>© Copyright JOSBC</span>
			</div>
		</footer>
		<!-------------------------------- footer -------------------------------->
	</div>

</body>

</html>