package member.command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.service.JoinService;
import member.service.LoginFailException;
import member.service.LoginService;
import member.service.User;
import mvc.command.CommandHandler;

public class LoginHandler implements CommandHandler {

	private LoginService loginService = new LoginService();
	private static final String FORM_VIEW = "WEB-INF/views/member/loginForm.jsp";

	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) {
		//index.jsp에서 회원가입 눌렀을 때 (gEt 방식으로 들어옴)
		if (req.getMethod().equalsIgnoreCase("GET")) {
			//아래 있는 processForm 메소드 실행하고 결과 반환
			return processForm(req, res);
		//joinForm.jsp에서 가입 버튼 눌렀을 때(post 방식으로 들어옴)
		} else if (req.getMethod().equalsIgnoreCase("POST")) {
			//아래 있는 processSubmit 메소드 실행하고 결과 반환
			return processSubmit(req, res);
		} else {
			res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}
	
	//index.jsp에서 회원가입 눌렀을 때 joinForm.jsp의 경로를 반환
	private String processForm(HttpServletRequest req, HttpServletResponse res) {
		return FORM_VIEW;
	}

	private String processSubmit(HttpServletRequest req, HttpServletResponse res) {
		String id = trim(req.getParameter("id"));
		String password = trim(req.getParameter("password"));
		System.out.println("LoginService >>> " + id);
		Map<String, Boolean> errors = new HashMap<>();
		req.setAttribute("errors", errors);

		if (id == null || id.isEmpty())
			errors.put("id", Boolean.TRUE);
		if (password == null || password.isEmpty())
			errors.put("password", Boolean.TRUE);

		if (!errors.isEmpty()) {
			return FORM_VIEW;
		}

		try {
			User user = loginService.login(id, password);
			//로그인 성공 - 세션에 속성 authUser와 속성값 회원정보를 붙여준다.
			HttpSession session = req.getSession();
			session.setAttribute("authUser", user);
			System.out.println("user >>>> "+user);
			return "main.jsp";
		} catch (LoginFailException e) {
			errors.put("idOrPwNotMatch", Boolean.TRUE);
			return FORM_VIEW;
		}
	}

	private String trim(String str) {
		return str == null ? null : str.trim();
	}

		
}
