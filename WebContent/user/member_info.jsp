<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page session="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<t:genericpage>
    <jsp:attribute name="head">
        <title>member_info</title>
    </jsp:attribute>
    <jsp:attribute name="header">
        <!-- 페이지 머리말 -->
    </jsp:attribute>
    <jsp:attribute name="footer">
        <!-- 페이지 꼬리말 -->
    </jsp:attribute>
    <jsp:body>
        <h1>회원정보</h1>
        <form action="${pageContext.request.contextPath}/user/update.do" method="post">
            <input type="hidden" name="id" value="${sessionScope.member.id}"/>
            <table>
                <tr><th colspan=2>회원정보</th></tr>
                <tr><td>아이디</td><td>${sessionScope.member.id}</td></tr>
                <tr><td>비밀번호</td><td><input type="password" name="pass" value="${sessionScope.member.pass}"></td></tr>
                <tr><td>이름</td><td><input type="text" name="name" value="${sessionScope.member.name}"></td></tr>
                <tr><td>전화번호</td><td><input type="text" name="phone" value="${sessionScope.member.phone}"></td></tr>
                <tr><td>이메일</td><td><input type="text" name="email" value="${sessionScope.member.email} "></tr>
                <tr><td>가입날짜</td><td>${sessionScope.member.reg_date}</td></tr>
                <tr><td colspan=2><input type="submit" value="수정"></td></tr>
            </table>
        </form>
        <a href="${pageContext.request.contextPath}/user/delete.do?=${ID}">회원탈퇴</a>
    </jsp:body>
</t:genericpage>
