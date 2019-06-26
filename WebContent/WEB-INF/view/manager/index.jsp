<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <link rel="shortcut icon" type="image/png" href="/semi-JCC/images/manager/inc/favicon.png" />
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
	<link rel="stylesheet" href="../css/manager/index.css">
	<script src="../js/manager/index.js"></script>
</head>


<body>
    <div id="container">
        <!-------------------------------- header -------------------------------->
        <jsp:include page="inc/header.jsp" />
        <!-------------------------------- header -------------------------------->
        <!-------------------------------- body -------------------------------->
        <!-------------------------------- body -nav------------------------------->
        <div class="body-container">
            <jsp:include page="inc/aside.jsp" />

            <main class="main">
                <div class="main-container">
                    <!------------------- 이안에다가 내용넣으면됨 --------------------->
                    <!------------------- 경로 --------------------->
                    <ol class="breadcrumb">
                        <li class="breadcrumb-home"><i class="material-icons md-18">home</i></li>
                        <li class="b-path"><i class="material-icons">
                                chevron_right
							</i><span>Index</span></li>						
					</ol>
					<div class="main-content-box">
						<h2>Manager Index 페이지</h2>
						<div class="content1">
							
						</div>
						<div class="content1">
							
						</div>
					</div>
                    
					
                    <!------------------- 여기까지 --------------------->
                </div>
            </main>
        </div>
        <!-------------------------------- body -------------------------------->
        <!-------------------------------- footer -------------------------------->
        <jsp:include page="inc/footer.jsp" />
        <!-------------------------------- footer -------------------------------->
    </div>

</body>

</html>