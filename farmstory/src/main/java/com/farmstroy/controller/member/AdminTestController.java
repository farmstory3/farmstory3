package com.farmstroy.controller.member;

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

@SuppressWarnings("serial")
@WebServlet("/test/admin.do")
public class AdminTestController extends HttpServlet{
	
	private MemberService service = MemberService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<MemberDTO> users = service.selectUsers();
		users.forEach(v->{
			System.out.println(v.getEmail());
		});
		req.setAttribute("users", users);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/adminprod/adminmain.jsp");
		dispatcher.forward(req, resp);
	}
	
}
