<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html lang="en" style="font-size: 10px">

<head>
<title>자유게시판</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link rel="stylesheet" href="../main/layout.css">
<link rel="shortcut icon" type="image/png" href="../main/images/favicon.png" />
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<link rel="stylesheet" type="text/css" href="../css/freeboard_list.css">
<script src="../js/list.js"></script>
</head>

<body>
<<<<<<< HEAD
	<!-- --header block------------------------------------------------------------------ -->
	<header id="header"> </header>



	<!-- --body block------------------------------------------------------------------ -->


	<aside></aside>
	<div id="body">


		<main>
		<section class="list" id="freeboard">
			<h3>자유게시판</h3>

			<div id="test-pager" style="float: right;">
				<input type="text"> <input type="button" value="요청">
			</div>

			<template class="freeboard-template">
			<tr>
				<td class="num"></td>
				<td class="title"></td>
				<td class="writer"></td>
				<td class="date"></td>
				<td class="hit"></td>
			</tr>
			</template>


			<table>
				<colgroup>
					<col width="10%" />
					<col width="40%" />
					<col width="20%" />
					<col width="20%" />
					<col width="10%" />
				</colgroup>
				<thead>
					<tr>
						<td scope="col">번호</td>
						<td scope="col">제목</td>
						<td scope="col">작성자</td>
						<td scope="col">등록날짜</td>
						<td scope="col">조회수</td>
					</tr>
				</thead>

				<tbody>
					<c:forEach var="n" items="${list}">
						<tr>
							<td class="num">${n.id}</td>
							<td class="title"><a href="detail?id=${n.id}">${n.title}</a></td>
							<td class="writer">${n.writer_id}</td>
							<td class="date">${n.reg_date}</td>

						</tr>
					</c:forEach>
				</tbody>

			</table>
		</section>

		<div class="reg">
			<button class="reg_button">
				<a href="reg">글쓰기</a>
			</button>
		</div>

		<section>
			<c:set var="page" value="${(empty param.p)? 1:param.p}" />
			<c:set var="start" value="${page-((page-1)%5)}" />
			<c:set var="last" value="" />

			<section id="pager">
				<h1 class="d-none">페이지</h1>
				<div>
					<div>
						<a href="list?p=${(page<6)?1:(start-1)}">이전</a>
					</div>
					<ul>
						<c:forEach begin="${start}" end="${start+4}" varStatus="s" var="n">
							<li><a href="list?p=${n}">${n}</a></li>
						</c:forEach>
					</ul>
					<div>
						<a href="list?p=${start+5}">다음</a>
					</div>
				</div>
			</section>
		</section>
		
		<h3>검색</h3>
		<form>
			<select>
				<option>title</option>
				<option>content</option>
				<option>writer</option>
			</select> <input type="text" placeholder="Search..."> <input
				class="reg_input" type="submit" value="search">
		</form>

		</main>
=======
	<div id="container">
		<!-------------------------------- header -------------------------------->
		<header class="header">
			<div class="header-container">
				<div class="logo">
					<a href="../main/layout.html" ><img src="../main/images/logo.png" alt=""></a>
				</div>
				<div class="usermenu">
					<ul class="usermenu-container">
						<li class="user-name">Yijin So</li>
						<li class="user-image"><a href=""><i
								class="material-icons md-36">account_circle</i></a></li>
						<li class="user-course"><a href=""><i
								class="material-icons md-36">class</i></a></li>
						<li class="user-alert"><a href=""><i
								class="material-icons md-36">notifications</i></a></li>
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
					<li><a href="#Mynote"><i class="material-icons md-36">description</i><span>My
								note</span></a></li>
					<li><a href="#Curriculum"><i class="material-icons md-36">date_range</i><span>Curriculum</span></a>
					</li>
					<li><a href="#Homework"><i class="material-icons md-36">dvr</i><span>Homework</span></a>
					</li>
					<li class="dropdown-menu"><a href="#Notice"><i
							class="material-icons md-36">apps</i><span>Notice</span><i
							class="material-icons md-36">expand_more</i></a>
						<ul class="dropdown-container">
							<li><a href="">Notice</a></li>
							<li><a href="">Freeboard</a></li>
						</ul></li>
					<li><a href="../freeboard/list"><i
							class="material-icons md-36">dvr</i><span>Freeboard</span></a></li>
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

				<section class="list" id="freeboard">
					<h3>자유게시판</h3>

					<div id="test-pager" style="float: right;">
						<input type="text"> <input type="button" value="요청">
					</div>

					<template class="freeboard-template">
					<tr>
						<td class="num"></td>
						<td class="title"></td>
						<td class="writer"></td>
						<td class="date"></td>
						<td class="hit"></td>
					</tr>
					</template>


					<table>
						<colgroup>
							<col width="10%" />
							<col width="40%" />
							<col width="20%" />
							<col width="20%" />
							<col width="10%" />
						</colgroup>
						<thead>
							<tr>
								<td scope="col">번호</td>
								<td scope="col">제목</td>
								<td scope="col">작성자</td>
								<td scope="col">등록날짜</td>
								<td scope="col">조회수</td>
							</tr>
						</thead>

						<tbody>
							<c:forEach var="n" items="${list}">
								<tr>
									<td class="num">${n.id}</td>
									<td class="title"><a href="detail?id=${n.id}">${n.title}</a></td>
									<td class="writer">${n.writer_id}</td>
									<td class="date">${n.reg_date}</td>

								</tr>
							</c:forEach>
						</tbody>

					</table>
				</section>
				<div class="reg">
					<button class="reg_button">
						<a href="reg">글쓰기</a>
					</button>
				</div>

				<c:set var="page" value="${(empty param.p)? 1:param.p}" />
				<c:set var="start" value="${page-((page-1)%5)}" />
				<c:set var="last" value="" />

				<section id="pager">
					<h1 class="d-none">페이지</h1>
					<div>
						<div>
							<a href="list?p=${(page<6)?1:(start-1)}">이전</a>
						</div>
						<ul>
							<c:forEach begin="${start}" end="${start+4}" varStatus="s"
								var="n">
								<li><a href="list?p=${n}">${n}</a></li>
							</c:forEach>
						</ul>
						<div>
							<a href="list?p=${start+5}">다음</a>
						</div>
					</div>
				</section>

				<h3>검색</h3>
				<form>
					<select>
						<option>title</option>
						<option>content</option>
						<option>writer</option>
					</select> <input type="text" placeholder="Search..."> <input
						class="reg_input" type="submit" value="search">
				</form>
>>>>>>> refs/remotes/origin/master


				
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

<<<<<<< HEAD
	<!-- --footer block------------------------------------------------------------------ -->

	<!-- <footer id="footer"> </footer> -->


=======
>>>>>>> refs/remotes/origin/master
</body>

</html>