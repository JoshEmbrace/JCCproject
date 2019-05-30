<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en" style="font-size: 10px">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>

    <link rel="stylesheet" type="text/css" href="../css/style.css">
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
              	<form method="post" action="reg">
	              	<table>
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
		              			<td>
		              				<select name="teacher">
		              					<option selected>미정
		              				<c:forEach var="name" items="${teacher}">
		              					<option>${name}
		              				</c:forEach>
		              				</select>
		              			</td>
		              			<!-- <td><input type="text" name="teacher"></td> -->
		              			<th>Manager</th>
		              			<td>
		              				<select name="manager">
		              					<option selected>미정
		              				<c:forEach var="name" items="${manager}">
		              					<option>${name}
		              				</c:forEach>
		              				</select>
		              			</td>
		              			<!-- <td><input type="text" name="manager"></td> -->
		              		</tr>
		              		
		              		<tr>
		              			<th>Student</th>
		              			<td colspan="3"></td>
		              		</tr>
	              	</table>
              		<div><input type="submit" value="확인"></div>
	              	<div><a href="list">취소</div>
				</form>
            </main>

    </div>

    <!-- --footer block------------------------------------------------------------------ -->

    <footer id="footer">

    </footer>

</body>

</html>