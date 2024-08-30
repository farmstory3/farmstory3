package com.farmstroy.controller.member;

import java.io.IOException;

import com.farmstroy.DTO.member.MemberDTO;
import com.farmstroy.Service.MemberService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/member/register.do")
public class RegisterController extends HttpServlet{
	
	private MemberService service = MemberService.INSTANCE;
	/**
	 * 
	 */
	private static final long serialVersionUID = -2889089871125140038L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/member/register.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 데이터 수신
				String uid = req.getParameter("uid");
				String pass = req.getParameter("pass1");
				String name = req.getParameter("name");
				String nick = req.getParameter("nick");
				String email = req.getParameter("email");
				String hp = req.getParameter("hp");
				String zip = req.getParameter("zip");
				String addr1 = req.getParameter("addr1");
				String addr2 = req.getParameter("addr2");
				String regip = req.getRemoteAddr();
				
				// DTO 생성
				MemberDTO userDto = new MemberDTO();
				userDto.setUid(uid);
				userDto.setPass(pass);
				userDto.setName(name);
				userDto.setNick(nick);
				userDto.setEmail(email);
				userDto.setHp(hp);
				userDto.setZip(zip);
				userDto.setAddr1(addr1);
				userDto.setAddr2(addr2);
				userDto.setRegip(regip);

				// 데이터 저장
				service.insertMember(userDto);

				// 리다이렉트
				resp.sendRedirect("/farmstory/member/login.do");
	}
}
