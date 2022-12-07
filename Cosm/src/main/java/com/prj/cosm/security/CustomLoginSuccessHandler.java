
package com.prj.cosm.security;

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
		request.getSession().setAttribute("usersName", vo.getUsersName());
		request.getSession().setAttribute("usersNo", vo.getUsersNo());
		request.getSession().setAttribute("usersAuthor", vo.getUsersAuthor());
		System.out.println(vo.getUsersPassword());
		// 사용자
		if (vo.getUsersAuthor().equals("D0108") || vo.getUsersAuthor().equals("D0107")) {
			response.sendRedirect(request.getContextPath() + "equipment/main");
		}else if(vo.getUsersAuthor().equals("D0109")) {
			response.sendRedirect(request.getContextPath() + "orders/sMain");
		}else if(vo.getUsersAuthor().equals("D0103")) {
			response.sendRedirect(request.getContextPath() + "material/main");	
		}else if(vo.getUsersAuthor().equals("D0105")) {
			response.sendRedirect(request.getContextPath() + "produce/planList");	
		}else if(vo.getUsersAuthor().equals("D0102")) {
			response.sendRedirect(request.getContextPath() + "client/main");	
		}else if(vo.getUsersAuthor().equals("D0101")) {
			response.sendRedirect(request.getContextPath() + "userList");	
		}else {
			response.sendRedirect(request.getContextPath() + "main");
		}
	}
}

