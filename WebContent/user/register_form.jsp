<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<t:genericpage>
    <jsp:attribute name="head">
        <title>register_form</title>
    </jsp:attribute>
    <jsp:attribute name="header">
        <!-- 머리말 추가 -->
    </jsp:attribute>
    <jsp:attribute name="footer">
        <!-- 꼬리말 추가 -->
        <script src="${pageContext.request.contextPath}/static/js/user.js"></script>
    </jsp:attribute>
    <jsp:body>
        <h1>회원가입</h1>
        <form action="${pageContext.request.contextPath}/user/register.do"
                method="post">
            <table>
                <tr>
                    <td>아이디</td>
                    <td><input type="text" name="id"/></td>
                </tr>
                <tr>
                    <td>비밀번호</td>
                    <td><input type="password" name="pass" /></td>
                </tr>
                <tr>
                    <td>이름</td>
                    <td><input type="text" name="name" /></td>
                </tr>
                <tr>
                    <td>전화번호</td>
                    <td><input type="text" name="phone" /></td>
                </tr>
                <tr>
                    <td>이메일</td>
                    <td><input type="text" name="email" /></td>
                </tr>
                <tr>
                    <td colspan=2><input type="submit" value="가입" /></td>
                </tr>
            </table>
        </form>
    </jsp:body>
</t:genericpage>
