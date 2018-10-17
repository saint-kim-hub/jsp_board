<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="true"%>
<%
    request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<title>로그인</title>
</head>
<body>
    <jsp:useBean id="data" class="member.DataManager" scope="session" />
    <%
        String id = request.getParameter("id");
        String pass = request.getParameter("pass");
        String rPath = request.getContextPath();
        if (data.isMember(id, pass)) {
            session.setAttribute("ID", id);
            response.sendRedirect(rPath+"/user/member_info.jsp");
        } else {
            response.sendRedirect(rPath+"/index.jsp");
        }
    %>
</body>
</html>