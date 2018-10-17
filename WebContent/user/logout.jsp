<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="true"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<title>로그아웃</title>
</head>
<body>
    <%
        String id = (String) session.getAttribute("ID");
        if (id != null)
            session.invalidate();
        response.sendRedirect(request.getContextPath()+"/index.jsp");
    %>
</body>
</html>