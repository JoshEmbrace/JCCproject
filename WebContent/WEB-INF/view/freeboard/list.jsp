<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html lang="en" style="font-size: 10px">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>자유게시판</title>
<link rel="stylesheet" type="text/css" href="../css/freeboard_list.css">
</head>


<body>
	<!-- --header block------------------------------------------------------------------ -->
	<header id="header"> </header>



	<!-- --body block------------------------------------------------------------------ -->


	<aside></aside>
	<div id="body">


		<main>
		<section class="list">
			<h3>자유게시판</h3>
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

							<td class="center">${n.id}</td>
							<td><a href="detail?id=${n.id}">${n.title}</td>
							<td class="center">${n.writer_id}</td>
							<td class="center">${n.reg_date}</td>
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
			<h3>검색</h3>
			<form>
				<select>
					<option>title</option>
					<option>content</option>
					<option>writer</option>
				</select> <input type="text" placeholder="Search..."> <input class="reg_input" type="submit" value="search">
			</form>
		</section>
		</main>

	</div>

	<!-- --footer block------------------------------------------------------------------ -->

	<footer id="footer"> </footer>

</body>

</html>