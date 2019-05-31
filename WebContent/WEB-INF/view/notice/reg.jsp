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
               <form method="post" action="reg" enctype="multipart/form-data">
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
               				<td><input name="title"></td>
               			</tr>
               			<tr>
               				<th>content</th>
               				<td><textarea name="content"></textarea></td>
               			</tr>
               			<tr>
               				<th>file</th>
               				<td><input type="file" name="file"></td>
               			</tr>
               			<tr>
               				<th>fix-top</th>
               				<td>
               					<input type="radio" name="fixtop">fix
               					<input type="radio" name="fixtop">non-fix
               				</td>
               			</tr>
               			<tr>
               				<th>hide</th>
               				<td>
               					<input type="radio">hide
               					<input type="radio">show 
               				</td>
               			</tr>
               		</tbody>
               	</table>
        
               	<div>
               		<input type="submit" value="post">
               		<a href="list">cancel</a>
               	</div>
               	</form>
               </section>
            </main>

    </div>

    <!-- --footer block------------------------------------------------------------------ -->

    <footer id="footer">

    </footer>

</body>

</html>
