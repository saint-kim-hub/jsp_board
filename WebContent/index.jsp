<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:genericpage>
    <jsp:attribute name="head">
        <title>index.jsp</title>
    </jsp:attribute>
    <jsp:attribute name="header">
        <!-- 머릿말 추가 -->
    </jsp:attribute>
    <jsp:attribute name="footer">
        <!-- 꼬릿말 추가 -->
    </jsp:attribute>
    <jsp:body>
        <h1>홈</h1>
        <c:if test="${not empty requestScope.message}">
            <div>${requestScope.message }</div>
        </c:if>
        <c:if test="${not empty ID }">
            로그인 되었습니다.
        </c:if>
        <c:if test="${empty ID }">
            <form action="${pageContext.request.contextPath}/user/login.do" method="post">
                <table>
                	<tr>
                		<td>아이디</td>
                		<td><input type="text" name="id" /></td>
                	</tr>
                	<tr>
                		<td>비밀번호</td>
                		<td><input type="password" name="pass" /></td>
                	</tr>
                	<tr>
                		<td colspan="2"><input type="submit" value="로그인" /></td>
                	</tr>
                </table>
            </form>
        </c:if>
    </jsp:body>
</t:genericpage>
