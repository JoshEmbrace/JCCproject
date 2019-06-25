<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <link rel="shortcut icon" type="image/png" href="../../images/inc/favicon.png" />
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
	<link rel="stylesheet" href="../../css/manager/course/list.css">
	<script src="../../js/manager/course/list.js"></script>
</head>


<body>
    <div id="container">
        <!-------------------------------- header -------------------------------->
        <jsp:include page="../inc/header.jsp" />
        <!-------------------------------- header -------------------------------->
        <!-------------------------------- body -------------------------------->
        <!-------------------------------- body -nav------------------------------->
        <div class="body-container">
            <nav class="nav">
                <ul class="nav-container">
                    <li>
                        <a href="#Mynote"><i class="material-icons md-36">description</i><span>My note</span></a>
                    </li>
                    <li>
                        <a href="#Curriculum"><i class="material-icons md-36">date_range</i><span>Curriculum</span></a>
                    </li>
                    <li>
                        <a href="#Homework"><i class="material-icons md-36">dvr</i><span>Homework</span></a>
                    </li>
                    <li class="dropdown-menu">
                        <a href="#Notice"><i class="material-icons md-36">apps</i><span>Notice</span><i
                                class="material-icons md-36">expand_more</i></a>
                        <ul class="dropdown-container">
                            <li><a href="">Notice</a></li>
                            <li><a href="">Freeboard</a></li>
                        </ul>
                    </li>
                </ul>
            </nav>
            <script>
                var dropdown = document.getElementsByClassName(".dropdown-menu");

                for (var i = 0; i < dropdown.length; i++) {
                    dropdown[i].addEventListener("click", function () {
                        this.classList.toggle("active");
                        var dropdownContent = this.nextElementSibling;
                        if (dropdownContent.style.display === "block") {
                            dropdownContent.style.display = "none";
                        } else {
                            dropdownContent.style.display = "block";
                        }
                    });
                }
            </script>

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
                            </i><span>상세</span></li>
					</ol>
					<div class="main-content-box">
						<h2>Course 상세</h2>
						<div class="content1">
							<table>
								<tr>
									<th>Course</th>
									<td>${course.name}</td>
									<th>Total</th>
									<td>${count}/ ${course.total}</td>
								</tr>
				
								<tr>
									<th>Start date</th>
									<td>
										<fmt:parseDate var="open" value="${course.openDate}" pattern="yyyy-MM-dd" />
										<fmt:formatDate value="${open}" pattern="yyyy-MM-dd" />
									</td>
									<th>End date</th>
									<td>
										<fmt:parseDate var="end" value="${course.endDate}" pattern="yyyy-MM-dd" />
										<fmt:formatDate value="${end}" pattern="yyyy-MM-dd" />
									</td>
								</tr>
				
								<tr>
									<th>Teacher</th>
									<td>${course.teacher}</td>
									<th>Manager</th>
									<td>${course.manager}</td>
								</tr>
				
								<tr>
									<th>Student</th>
									<td colspan="3">
										<c:forEach var="student" items="${students}">
											${student.member_name}<br>
										</c:forEach>
									</td>
								</tr>
				
							</table>
						</div>
						<div class="content1">
							<div>
								<a href="list">List</a>
							</div>
							<div>
								<a href="edit?id=${course.id}">수정</a>
							</div>
							<div>
								<a href="del?id=${course.id}">삭제</a>
							</div>
						</div>
					</div>
                    
					
                    <!------------------- 여기까지 --------------------->
                </div>
            </main>
        </div>
        <!-------------------------------- body -------------------------------->
        <!-------------------------------- footer -------------------------------->
        <jsp:include page="../inc/footer.jsp" />
        <!-------------------------------- footer -------------------------------->
    </div>

</body>

</html>