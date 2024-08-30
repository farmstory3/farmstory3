package com.farmstroy.controller.admin;

import java.io.IOException;

import com.farmstroy.DTO.member.MemberDTO;
import com.farmstroy.Service.MemberService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/admin/memberDetail.do")
public class AdminMemberDetailController extends HttpServlet{
	private static final long serialVersionUID = -9084324044836073631L;
	private MemberService service = MemberService.INSTANCE;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String uid = req.getParameter("uid");
		
		MemberDTO member = service.selectMemberDetail(uid);
		req.setAttribute("member", member);
		
		req.getRequestDispatcher("/WEB-INF/adminprod/adminMemberDetail.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
	
	
}
