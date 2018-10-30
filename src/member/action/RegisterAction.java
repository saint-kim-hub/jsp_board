package member.action;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.MemberDao;
import member.MemberInfo;
import member.controller.CommandAction;

public class RegisterAction implements CommandAction {

    @Override
    public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        request.setCharacterEncoding("utf-8"); /* request 객체에 form을 통해 넘겨 받은 데이터에 맞는 인코딩을 지정해 한글이 깨지는 것을 방지 */

        CommonAction utils = new CommonAction();
        MemberInfo member = utils.mappingReqMember(request);
        
        MemberDao data = new MemberDao();
        String text = null;

        if (!data.isMember(member.getId(),member.getPass())) {
            if (data.insertMember(member) != 0) {
                // 1.열려있는 세션을 가져온다.
                HttpSession session = request.getSession(false);
                // 2.새로운 세션을 만들기 전에 이전의 세션의 모든 데이터를 무효화한다.
                if(session != null) {
                    session.invalidate();
                }
                // 3.새로운 세션을 만든다.
                session = request.getSession(true);
                session.setAttribute("ID", member.getId());
                text = "회원가입에 성공하였습니다.";
            } else {
                text = "회원가입에 실패하였습니다. 잠시 후 다시 시도해 주세요.";
            }
        } else {
            text = "이미 가입된 아이디입니다. 다시 작성해 주세요.";
        }

        request.setAttribute("message", text);

        return "register.jsp";
    }
}
