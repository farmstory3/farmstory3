package com.farmstroy.controller.admin;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.farmstroy.DTO.member.MemberDTO;
import com.farmstroy.Service.MemberService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/admin/login.do")
public class AdminLoginController extends HttpServlet{
	private static final long serialVersionUID = -940010039882324579L;
	private MemberService service = MemberService.INSTANCE;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String success = req.getParameter("success");
		
		req.setAttribute("success", success);
		
		HttpSession session = req.getSession();
		MemberDTO sessUser = (MemberDTO) session.getAttribute("sessUser");
		
		if(sessUser != null) {
			//로그인 상태이면 게시판 목록 이동
			resp.sendRedirect("/farmstory");
		}else {
			//로그인 상태가 아니면
			RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/adminprod/adminlogin.jsp");
			dispatcher.forward(req, resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uid = req.getParameter("uid");
		String pass = req.getParameter("pass");
		logger.debug("uid : " + uid + ", pass : "+ pass);
		
		MemberDTO user = service.selectMember(uid, pass);
		
		if(user != null && user.getRole().equals("0")) {
			//회원이 맞을 경우 -> 세션처리 후 리다이렉트
			HttpSession session = req.getSession();
			session.setAttribute("sessUser", user);
			
			resp.sendRedirect("/farmstory/admin/main.do");
			
		}else {
			//회원이 아닐 경우
			resp.sendRedirect("/farmstory/member/login.do?success=103");
		}
	}
}