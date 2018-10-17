<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<title>메인페이지</title>
</head>
<body>
    <form action="user/login.jsp" method="post">
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
                <td colspan=2><input type="submit" value="로그인" /></td>
            </tr>
        </table>
        <a href="<%=request.getContextPath()%>/user/register_form.jsp">회원가입</a>
    </form>
</body>
</html>