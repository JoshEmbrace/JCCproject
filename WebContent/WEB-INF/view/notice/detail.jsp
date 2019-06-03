<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en" style="font-size: 10px">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>

   <!--  <link rel="stylesheet" type="text/css" href="../css/style.css"> -->
</head>


<body>
    <!-- --header block------------------------------------------------------------------ -->
    <header id="header">

    </header>



    <!-- --body block------------------------------------------------------------------ -->


    <div id="body">

            <aside>
                
            </aside>
            <main>
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
               			<tr>
               				<th>file</th>
               				<td>${notice.file_name}</td>
               			</tr>
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
               			<button><a href="list">list</a></button>
               			<button><a href="edit?id=${notice.id}">edit</a></button>
               			<button><a href="del?id=${notice.id}">delete</a></button>
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
            </main>

    </div>

    <!-- --footer block------------------------------------------------------------------ -->

    <footer id="footer">

    </footer>

</body>

</html>
