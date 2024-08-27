package com.farmstory.controller.admin;

import java.io.IOException;
import java.util.List;

import com.farmstroy.DTO.member.MemberDTO;
import com.farmstroy.Service.MemberService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/adminprod/adminMember.do")
public class AdminUserController extends HttpServlet{
	private static final long serialVersionUID = -409203805936676515L;
	private MemberService service = MemberService.INSTANCE;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<MemberDTO> users = service.selectUsers();
		req.setAttribute("users", users);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/adminprod/adminMember.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
}
