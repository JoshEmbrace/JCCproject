<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <header class="header">
            <div class="header-container">
                <div class="logo"><a href="/semi-JCC/manager/index"><img src="/semi-JCC/images/manager/inc/logo.png" alt=""></a></div>
                <div class="usermenu">
                    <ul class="usermenu-container">        
                    <c:choose>
                    	<c:when test="${not empty sessionScope.user['name']}">
                    		<li class="user-name">${sessionScope.user['name']}</li>
                    	</c:when>
                    	<c:otherwise>
                    		<li class="user-name">guest</li>
                    	</c:otherwise>
                    </c:choose>

                        <li class="user-image"><a href="/semi-JCC/member/mypage"><i class="material-icons md-36">account_circle</i></a></li>
                        <li class="user-course"><a href=""><i class="material-icons md-36">class</i></a></li>
                        <li class="user-alert"><a href=""><i class="material-icons md-36">notifications</i></a></li>
                    <c:choose>
                    	<c:when test="${not empty sessionScope.user['name']}">
                    		<li class="user-log"><a href="/semi-JCC/member/logout">logout</a></li>
                    	</c:when>
                    	<c:otherwise>
                    		<li class="user-log"><a href="/semi-JCC/member/login">login</a></li>
                    	</c:otherwise>
                    </c:choose>
                        
                    </ul>
                </div>
            </div>
        </header>

