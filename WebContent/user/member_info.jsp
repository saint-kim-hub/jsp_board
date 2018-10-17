<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="true"%>
<%@ page import="member.MemberInfo"%>
<%
    request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<title>회원정보</title>
</head>
<body>
    <jsp:useBean id="data" class="member.DataManager" scope="page" />
    <%
        String id = (String) session.getAttribute("ID");
        String rPath = request.getContextPath();
        if (id != null) {
            MemberInfo member = data.getMember(id);
            out.print("<form action=\""+rPath+"/user/update.jsp\" method=\"post\">");
            out.print("<table>");
            out.print("<tr><th colspan=2>회원정보</th></tr>");
            out.print("<tr><td>아이디</td><td><input type=\"text\" name=\"id\" value=\"" + member.getId()
                    + "\"></td></tr>");
            out.print("<tr><td>비밀번호</td><td><input type=\"password\" name=\"pass\" value=\"" + member.getPass()
                    + "\"></td></tr>");
            out.print("<tr><td>이름</td><td><input type=\"text\" name=\"name\" value=\"" + member.getName()
                    + "\"></td></tr>");
            out.print("<tr><td>전화번호</td><td><input type=\"text\" name=\"phone\" value=\"" + member.getPhone()
                    + "\"></td></tr>");
            out.print("<tr><td>이메일</td><td><input type=\"text\" name=\"email\" value=\"" + member.getEmail()
                    + "\"></tr>");
            out.print("<tr><td>가입날짜</td><td>" + member.getReg_date() + "</td></tr>");
            out.print("<tr><td solspan=2><input type=\"submit\" value=\"수정\"></td></tr>");
            out.print("</table>");
            out.print("</form>");
        } else {
            response.sendRedirect(rPath+"/index.jsp");
        }
    %>
    <a href="<%=request.getContextPath()%>/user/logout.jsp">로그아웃</a>
    <br />
    <a href="<%=request.getContextPath()%>/user/delete.jsp?=<%=id%>">회원탈퇴</a>
    <br />
</body>
</html>