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
<title>회원정보 수정</title>
</head>
<body>
    <jsp:useBean id="member" class="member.MemberInfo" scope="page" />
    <jsp:setProperty property="*" name="member" />
    <jsp:useBean id="data" class="member.DataManager" scope="page" />
    <%
        String id = (String) session.getAttribute("ID");
        String rPath = request.getContextPath();
        if (id != null) {
            if (data.updateMember(member) != 0) {
                out.print("<h3>회원정보 수정에 성공하였습니다.</h3>");
                out.print("<h3><a href=\""+rPath+"/user/member_info.jsp\">회원정보 보기 화면으로 돌아가기</a></h3>");
            } else {
                out.print("<h3>회원정보 수정에 실패하였습니다.</h3>");
                out.print("<h3><a href=\""+rPath+"/user/login.jsp\">로그인 화면으로 돌아가기</a></h3>");
            }
        } else {
            response.sendRedirect(rPath+"/index.jsp");
        }
    %>
    
</body>
</html>