package member.command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.service.ModifyInfoService;
import member.model.Member;
import member.service.InvalidPasswordException;
import member.service.MemberNotFoundException;
import member.service.User;
import mvc.command.CommandHandler;

public class ModifyInfoHandler implements CommandHandler {
	private static final String FORM_VIEW = "WEB-INF/views/member/modifyInfoForm.jsp";
	private ModifyInfoService mInfoService = new ModifyInfoService();
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) 
	throws Exception {
		if (req.getMethod().equalsIgnoreCase("GET")) {
			return processForm(req, res);
		} else if (req.getMethod().equalsIgnoreCase("POST")) {
			return processSubmit(req, res);
		} else {
			res.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}

	private String processForm(HttpServletRequest req, HttpServletResponse res) {
		User user = (User) req.getSession().getAttribute("authUser");
		String id = user.getId();
		Member member = mInfoService.myPage(id);
		System.out.println(this.getClass()+" >>> member >>> " + member);
		req.setAttribute("member", member);
		return FORM_VIEW;
	}


	private String processSubmit(HttpServletRequest req, HttpServletResponse res)
	throws Exception {
				
		Member member = new Member();	
		member.setMember_id(req.getParameter("id"));
		member.setName(req.getParameter("name"));
		member.setEmail(req.getParameter("email"));
		member.setPassword(req.getParameter("password"));
		
		if(member.matchPassword(req.getParameter("confirmPassword"))) {
			try {
				mInfoService.modifyInfo(member);
				return "/WEB-INF/views/member/modifyInfoSuccess.jsp";
			} catch (InvalidPasswordException e) {
				return FORM_VIEW;
			} catch (MemberNotFoundException e) {
				return null;
			}
		}
		
		return null;
	}

}
