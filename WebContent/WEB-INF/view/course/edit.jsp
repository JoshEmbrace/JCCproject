<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en" style="font-size: 20px">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>

    <link rel="stylesheet" type="text/css" href="../css/course.css">
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
              	<form method="post" action="edit">
	              	<table>
		              		<tr>
		              			<th>Course</th>
		              			<td><input type="text" value="${course.name}" name="name"></td>
		              			<th>Total</th>
		              			<td>${course.total}</td>
		              		</tr>
		              		
		              		<tr>
		              			<th>Start date</th>
		              			<td><input type="date" value="${course.openDate}" name="openDate"></td>
		              			<th>End date</th>
		              			<td><input type="date" value="${course.endDate}" name="endDate"></td>
		              		</tr>
		              		
		              		<tr>
		              			<th>Teacher</th>
		              			<td>
		              				<select name="teacher">
		              				<c:forEach var="teacher" items="${teachers}">
		              					<option value="${teacher.id}">${teacher.name}
		              				</c:forEach>
		              				</select>
		              			</td>
		              			<%-- <td><input type="text" value="${course.teacher}" name="teacher"></td> --%>
		              			<th>Manager</th>
		              			<td>
		              				<select name="manager">
		              				<c:forEach var="manager" items="${managers}">
		              					<option value="${manager.id}">${manager.name}
		              				</c:forEach>
		              				</select>
		              			</td>
		              			<%-- <td><input type="text" value="${course.manager}" name="manager"></td> --%>
		              		</tr>
		              		
		              		<tr>
		              			<th>Student</th>
		              			<td colspan="3"></td>
		              		</tr>
	              	</table>
              		<div><input type="hidden" value="${course.id}" name="id"></div>
              		<div><input type="submit" value="확인"></div>
	              	<div><a href="detail?id=${course.id}">취소</div>
				</form>
            </main>

    </div>

    <!-- --footer block------------------------------------------------------------------ -->

    <footer id="footer">

    </footer>

</body>

</html>