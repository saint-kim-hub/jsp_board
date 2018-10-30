<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<a href="${pageContext.request.contextPath}">홈</a>
<c:if test="${not empty ID }">
    <a href="${pageContext.request.contextPath}/user/member_info.do">${ID }님</a>
    <a href="${pageContext.request.contextPath}/user/logout.do">로그아웃</a>
</c:if>
<c:if test="${empty ID }">
    <a href="${pageContext.request.contextPath}/user/register_form.do">회원가입</a>
</c:if>
<div>머릿말</div>