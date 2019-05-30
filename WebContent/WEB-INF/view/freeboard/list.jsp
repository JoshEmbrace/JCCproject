<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html lang="en" style="font-size: 10px">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>list jsp here</title>

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
                  <h3>공지사항 목록</h3>
                  <table>
                     <thead>
                        <tr>
                           <td>no.</td>
                           <td>title</td>
                           <td>writer</td>
                           <td>date</td>
                           <td>hit</td>
                        </tr>
                     </thead>
                     <tbody>
                     <c:forEach var="n" items="${list}">
                        <tr>
                  
                           <td>${n.id}</td>
                           <td><a href="detail?id=${n.id}">${n.title}</td>
                           <td>${n.writer_id}</td>
                           <td>${n.reg_date}</td>
                           <td>${n.hit}</td>
                        </tr>
                     </c:forEach>
                     </tbody>
                  </table>
               </section>
               
        <!--        <div>
                  <form>
                     <button><a href="reg">new</a></button>
                  </form>
               </div>
                -->
               <section>
                  <h3>공지사항 검색</h3>
                  <form>
                     <select>
                        <option>title</option>
                        <option>content</option>
                        <option>writer</option>
                     </select>
                        <input type="text">
                        <input type="submit" value="search">
                  </form>
               </section>
            </main>

    </div>

    <!-- --footer block------------------------------------------------------------------ -->

    <footer id="footer">

    </footer>

</body>

</html>