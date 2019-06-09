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
              			<th>no.</th>
              			<th>course</th>
              			<th>teacher</th>
              			<th>manager</th>
              			<th>opendate</th>
              			<th>enddate</th>
              			<th>total</th>
              			<th>writer</th>
              		</tr>
	             	 <c:forEach var="n"  items="${list}" varStatus="vs">
	             	 	<c:if test="${vs.count%2==0}">
	              		<tr class="even">
	              		</c:if>
	              		<c:if test="${vs.count%2!=0}">
	              		<tr>
	              		</c:if>
	              			<td>${vs.count}</td>
	              			<td><a href="detail?id=${n.id}">${n.name}</a></td>
	              			<td>${n.teacher}</td>
	              			<td>${n.manager}</td>
	              			<td>
	              				<fmt:parseDate var="open" value="${n.openDate}" pattern="yyyy-MM-dd" /> 
								<fmt:formatDate value="${open}"  pattern="yyyy-MM-dd" />
	              			</td>
	              			<td>
	              				<fmt:parseDate var="end" value="${n.endDate}" pattern="yyyy-MM-dd" /> 
								<fmt:formatDate value="${end}"  pattern="yyyy-MM-dd" />
	              			</td>
	              			<td>${n.total}</td>
	              			<td>${n.writerId}</td>
	              		</tr>
	              	</c:forEach>
              	</table>
              	<div><a href="reg?id=${n.id}">등록</a></div>
            </main>

    </div>

    <!-- --footer block------------------------------------------------------------------ -->

    <footer id="footer">

    </footer>

</body>

</html>