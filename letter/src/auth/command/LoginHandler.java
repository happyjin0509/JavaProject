package auth.command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import auth.service.LoginFailException;
import auth.service.LoginService;
import auth.service.User;
import mvc.command.CommandHandler;

public class LoginHandler implements CommandHandler {

	private LoginService loginService = new LoginService();

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) 
	throws Exception {
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
			return "index.jsp";
		}

		try {
			User user = loginService.login(id, password);
			//로그인 성공 - 세션에 속성 authUser와 속성값 회원정보를 붙여준다.
			req.getSession().setAttribute("authUser", user);
			System.out.println("user"+user);
			return "main.jsp";
		} catch (LoginFailException e) {
			errors.put("idOrPwNotMatch", Boolean.TRUE);
			return "index.jsp";
		}
	}

	private String trim(String str) {
		return str == null ? null : str.trim();
	}

		
}
