<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<title>회원가입</title>
</head>
<body>
    <jsp:useBean id="member" class="member.MemberInfo" scope="page" />
    <jsp:setProperty name="member" property="*" />
    <jsp:useBean id="data" class="member.DataManager" scope="page" />
    <%
        String rPath = request.getContextPath();
        if (!data.isMember(member.getId(), member.getPass())) {
            if (data.insertMember(member) != 0) {
                out.print("<h3>회원가입에 성공하였습니다.</h3>");
                out.print("<h3><a href=\""+rPath+"/index.jsp\">로그인 화면으로 돌아가기</a></h3>");
            } else {
                out.print("<h3>회원가입에 실패하였습니다. 잠시 후 다시 시도해 주세요.</h3>");
                out.print("<h3><a href=\""+rPath+"/index.jsp\">로그인 화면으로 돌아가기</a></h3>");
            }
        } else {
            out.print("<h3>이미 가입된 아이디입니다. 다시 작성해 주세요.</h3>");
            out.print("<h3><a href=\""+rPath+"/user/register_form.jsp\">회원 가입 화면으로 돌아가기</a></h3>");
        }
    %>
</body>
</html>