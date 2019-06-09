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
              	<table>
              		<tr>
              			<th>Course</th>
              			<td>${course.name}</td>
              			<th>Total</th>
              			<td>${course.total}</td>
              		</tr>
              		
              		<tr>
              			<th>Start date</th>
              			<td>
              				<fmt:parseDate var="open" value="${course.openDate}" pattern="yyyy-MM-dd" /> 
							<fmt:formatDate value="${open}"  pattern="yyyy-MM-dd" />
	              		</td>
              			<th>End date</th>
              			<td>
              				<fmt:parseDate var="end" value="${course.endDate}" pattern="yyyy-MM-dd" /> 
							<fmt:formatDate value="${end}"  pattern="yyyy-MM-dd" />
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
              			<td colspan="3"></td>
              		</tr>

              	</table>
              	<div><a href="list">List</a></div>
              	<div><a href="edit?id=${course.id}">수정</a></div>
              	<div><a href="del?id=${course.id}">삭제</div>
            </main>

    </div>

    <!-- --footer block------------------------------------------------------------------ -->

    <footer id="footer">

    </footer>

</body>

</html>