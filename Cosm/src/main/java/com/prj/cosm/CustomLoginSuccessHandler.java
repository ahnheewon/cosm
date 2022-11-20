package com.prj.cosm;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.prj.cosm.user.emp.service.EmpService;
import com.prj.cosm.user.emp.service.EmpVO;

/*
 * 로그인 완료 후에 추가작업
 */
public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler {
	@Autowired
	EmpService service;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		EmpVO vo = new EmpVO();
		vo = service.empSelect(authentication.getName());
		request.getSession().setAttribute("usersId", vo.getUsersId());
		request.getSession().setAttribute("usersNo", vo.getUsersNo());
		request.getSession().setAttribute("usersAuthor", vo.getUsersAuthor());
		// 사용자
		response.sendRedirect(request.getContextPath() + "/");

	}
}
