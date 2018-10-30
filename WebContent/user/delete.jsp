<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page session="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:genericpage>
    <jsp:attribute name="head">
        <title>delete</title>
    </jsp:attribute>
    <jsp:attribute name="header">
        <!-- 페이지 머리말 -->
    </jsp:attribute>
    <jsp:attribute name="footer">
        <!-- 페이지 꼬리말 -->
    </jsp:attribute>
    <jsp:body>
        <h1>탈퇴</h1>
        <c:if test="${not empty requestScope.message}">
            <div>${requestScope.message }</div>
        </c:if>
        <c:if test="${not empty ID }">
            <a href="${pageContext.request.contextPath}/user/member_info.do">회원정보 보기화면으로 돌아가기</a>
        </c:if>
        <c:if test="${empty ID }">
            <a href="${pageContext.request.contextPath}/home.do">로그인 화면으로 돌아가기</a>
        </c:if>
    </jsp:body>
</t:genericpage>
    