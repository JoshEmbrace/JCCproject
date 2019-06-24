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
    <link rel="shortcut icon" type="image/png" href="../../../images/inc/favicon.png" />
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
	<link rel="stylesheet" href="../css/course_list.css">
	<script src="../js/course/list.js"></script>
</head>

<body>
    <div id="container">
        <!-------------------------------- header -------------------------------->
        <header class="header">
            <div class="header-container">
                <div class="logo"><img src="../../../images/inc/logo.png" alt=""></div>
                <div class="usermenu">
                    <ul class="usermenu-container">
                        <li class="user-name">Yijin So</li>
                        <li class="user-image"><a href=""><i class="material-icons md-36">account_circle</i></a></li>
                        <li class="user-course"><a href=""><i class="material-icons md-36">class</i></a></li>
                        <li class="user-alert"><a href=""><i class="material-icons md-36">notifications</i></a></li>
                        <li class="user-log"><a href="">logout</a></li>
                    </ul>
                </div>
            </div>
        </header>
        <!-------------------------------- header -------------------------------->
        <!-------------------------------- body -------------------------------->
        <!-------------------------------- body -nav------------------------------->
        <div class="body-container">
            <nav class="nav">
                <ul class="nav-container">
                    <li>
                        <a href="../mynote/list"><i class="material-icons md-36">description</i><span>My note</span></a>
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
                            </i><span>Curriculum</span></li>
					</ol>
					
                    <div class="main-content-box">
                        <template class="main-template">
							<tr>
								<td class="num"></td>
								<td class="name"></td>
								<td class="teacher"></td>
								<td class="manager"></td>
								<td class="open"></td>
								<td class="end"></td>
								<td class="total"></td>
								<td class="writer"></td>
							</tr>
						</template>
						<table id="course_table">
							<colgroup>
								<col width="5%">
								<col width="*">
								<col width="10%">
								<col width="10%">
								<col width="15%">
								<col width="15%">
								<col width="5%">
								<col width="10%">
							</colgroup>
							<thead>
								<tr>
									<th>no.</th>
									<th>course</th>
									<th>teacher</th>
									<th>manager</th>
									<th>opendate</th>
									<th>enddate</th>
									<th>total</th>
									<th>writer</th>
								</tr>
							</thead>
					
							<tbody>
								<c:forEach var="n" items="${list}" varStatus="vs">
									<c:if test="${vs.count%2==0}">
										<tr class="even">
									</c:if>
									<c:if test="${vs.count%2!=0}">
										<tr>
									</c:if>
									<td class="num">${n.id}</td>
									<td class="name"><a href="detail?id=${n.id}">${n.name}</a></td>
									<td class="teacher">${n.teacher}</td>
									<td class="manager">${n.manager}</td>
									<td class="open">
										<fmt:parseDate var="open" value="${n.openDate}" pattern="yyyy-MM-dd" />
										<fmt:formatDate value="${open}" pattern="yyyy-MM-dd" />
									</td>
									<td class="end">
										<fmt:parseDate var="end" value="${n.endDate}" pattern="yyyy-MM-dd" />
										<fmt:formatDate value="${end}" pattern="yyyy-MM-dd" />
									</td>
									<td class="total">${n.total}</td>
									<td class="writer">${n.writerId}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					
						<div class="input">
							<input type="text" value="1">
							<input type="button" value="요청">
						</div>
					
						<div class="right">
							<a href="reg?id=${n.id}"><img src="../images/course/add-btn.png" width="30px" height="30px"></a>
						</div>
					
						<section id="pager">
							<h1 class="d-none">페이지</h1>
							
							<div class="box">
								<c:set var="page" value="${empty param.p? 1:param.p}" />
								<div>
									<a href="list?p=${(page<6)?page:page-5}">
										<img src="../images/course/left-btn.png" width="15px" height="15px">
									</a>
								</div>
								<ul>
									<c:set var="start" value="${page-(page-1)%5}" />
									<c:set var="last" value="" />
					
									<c:forEach begin="${start}" end="${start+4}" var="x">
										<c:choose>
											<c:when test="${empty param.p and x==1}">
												<li class="current">
											</c:when>
											<c:when test="${param.p == x}">
												<li class="current">
											</c:when>
											<c:otherwise>
												<li>
											</c:otherwise>
										</c:choose>
										
										<a href="list?p=${x}">${x}</a></li>
									</c:forEach>
								</ul>
								<div>
									<a href="list?p=${page+5}">
										<img src="../images/course/right-btn.png" width="15px" height="15px">
									</a>
								</div>
							</div>
						</section>
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