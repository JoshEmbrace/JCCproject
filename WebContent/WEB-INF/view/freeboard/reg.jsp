
<%@page import="java.util.Scanner"%>
<%@page import="java.io.FileInputStream"%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en" style="font-size: 10px">
<!-- web-inf 디렉토리에 넣으면 사용자가 view를 바로 호출할 수 없다 -->
<head>
<meta charset="UTF-8">
<title>Document</title>
<link rel="shortcut icon" href="img/favicon.ico">
<link rel="stylesheet" type="text/css" href="/css/freeboard.css">
</head>

<body>
   <jsp:include page="../inc/header.jsp"></jsp:include>
   <!-- --- header block----------------------------------------------------------------------------------->


   <!-- --- visual block----------------------------------------------------------------------------------->
   <div id="visual"></div>
   <!-- --- body block----------------------------------------------------------------------------------->
   <div id="body">
      <div class="content-box">

         <!-- aside -->


         <!-- aside -->


         <main>

         <section>
            <h1>자유게시판 글쓰기</h1>

            <section>
               <form action="reg" method="post" enctype="multipart/form-data">
                  <h1>내용</h1>
                  <table>
                     <tbody>
<!-- 
                        <tr>
                           <th>아이디</th>
                           <td><input name="id"></td>
                        </tr>

 -->
                        <tr>
                           <th>제목</th>
                           <td><input name="title"></td>
                        </tr>

                        <tr>
                           <th>내용</th>
                           <td><textarea name="content"></textarea></td>
                        </tr>

                        <tr>
                           <th>작성자 아이디</th>
                           <td><input name="writer_id"></input></td>
                        </tr>
                        
                        <tr>
                           <th>첨부파일</th>
                           <td><input type="file" name="file"></td>
                        </tr>

                     </tbody>
                  </table>

                  <div>
                     <input type="submit" value="저장"> <a href="list">취소</a>
                  </div>


               </form>
            </section>
         </main>
         <!-- <div style="clear:left;">막내</div> -->
      </div>
   </div>

   <!-- --- footer block----------------------------------------------------------------------------------->
   <!-- --- footer block----------------------------------------------------------------------------------->
   <jsp:include page="../inc/footer.jsp"></jsp:include>

</body>

</html>