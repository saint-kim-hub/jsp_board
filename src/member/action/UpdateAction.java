package member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.MemberDao;
import member.MemberInfo;
import member.controller.CommandAction;

public class UpdateAction implements CommandAction {

    @Override
    public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        request.setCharacterEncoding("utf-8"); /* request 객체에 form을 통해 넘겨 받은 데이터에 맞는 인코딩을 지정해 한글이 깨지는 것을 방지 */     

        CommonAction utils = new CommonAction();
        MemberInfo member = utils.mappingReqMember(request);
        
        MemberDao data = new MemberDao();
        String text = "";

        HttpSession session = request.getSession();
        String id = (String) session.getAttribute("ID");

        if (id != null) {
            if (data.updateMember(member) != 0) {
                text = "회원정보 수정에 성공하였습니다.";
            } else {
                text = "회원정보 수정에 실패하였습니다.";
            }
        } else {
            response.sendRedirect(request.getContextPath()+"/home.do");
            return null;
        }

        request.setAttribute("message", text);

        return "update.jsp";
    }
}
