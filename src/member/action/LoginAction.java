package member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.controller.CommandAction;
import member.MemberDao;

public class LoginAction implements CommandAction {

    @Override
    public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

        MemberDao data = new MemberDao();

        String id = request.getParameter("id");
        String pass = request.getParameter("pass");
        String rPath = request.getContextPath();
        String text = null;

        if (data.isMember(id, pass)) {
            HttpSession session = request.getSession();
            session.setAttribute("ID", id);
            response.sendRedirect(rPath+"/user/member_info.do");
            
            return null;
        } else {
            text = "입력내용을 다시 확인하여 주세요.";
            request.setAttribute("message", text);
            // response.sendRedirect(rPath+"/home.do");
            
            return "/index.jsp";
        }
    }
}
