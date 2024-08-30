package com.farmstroy.filter;

import java.io.IOException;

import com.farmstroy.DTO.member.MemberDTO;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebFilter(urlPatterns = {"/admin/main.do","/admin/product.do","/admin/prodcreateview.do","/admin/order.do","/admin/member.do"})
public class LoginCheckForAdminFilter implements Filter{
	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2) throws IOException, ServletException {
		
		// 로그인 여부 확인
		HttpServletRequest req = (HttpServletRequest) arg0;
		HttpSession session = req.getSession();
		MemberDTO sessUser = (MemberDTO) session.getAttribute("sessUser");
		
		if(sessUser == null) {
			//로그인 상태가 아니면 로그인으로 이동
			HttpServletResponse resp = (HttpServletResponse) arg1;
			resp.sendRedirect("/farmstory/admin/login.do?success=102");
		}else {
			//로그인 상태이면 다음 필터로 이동 (Controller 요청)
			arg2.doFilter(arg0, arg1);
		}
		
	}
}
