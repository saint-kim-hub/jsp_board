package member.action;

import java.util.Enumeration;
import javax.servlet.http.HttpServletRequest;
import member.MemberInfo;

public class CommonAction {
    // 요청 파라미터를 멤버객체에 담는다.
    public MemberInfo mappingReqMember(HttpServletRequest request) throws Throwable {

        MemberInfo member = new MemberInfo();
        Enumeration<String> parameterNames = request.getParameterNames();

        while (parameterNames.hasMoreElements()) {
            String paramName = (String)parameterNames.nextElement();
            switch(paramName) {
            case "id":
                member.setId(request.getParameter("id"));
                break;
            case "pass":
                member.setPass(request.getParameter("pass"));
                break;
            case "name":
                member.setName(request.getParameter("name"));
                break;
            case "phone":
                member.setPhone(request.getParameter("phone"));
                break;
            case "email":
                member.setEmail(request.getParameter("email"));
                break;
            }
        }

        return member;
    }
}
