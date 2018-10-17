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
<title>회원탈퇴</title>
</head>
<body>
    <jsp:useBean id="data" class="member.DataManager" scope="page" />
    <%
        String id = (String) session.getAttribute("ID");
        String rPath = request.getContextPath();
        if (id != null) {
            if (data.removeMember(id) != 0) {
                out.print("<h3>회원정보 삭제하였습니다.</h3>");
                session.invalidate();
                out.print("<h3><a href=\""+rPath+"/index.jsp\">로그인 화면으로 돌아가기</a></h3>");
            } else {
                out.print("<h3>회원정보 삭제하지 못했습니다.</h3>");
                out.print("<h3><a href=\""+rPath+"/user/member_info.jsp\">회원정보 보기화면으로 돌아가기</a></h3>");
            }
        } else {
            out.print("<h3>로그인 필요합니다.</h3>");
            response.sendRedirect(request.getContextPath()+"/index.jsp");
        }
    %>
</body>
</html>