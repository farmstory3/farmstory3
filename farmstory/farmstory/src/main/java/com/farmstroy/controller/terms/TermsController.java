package com.farmstroy.controller.terms;

import java.io.IOException;

import com.farmstroy.DTO.terms.TermsDTO;
import com.farmstroy.Service.termsService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/member/terms.do")
public class TermsController extends HttpServlet{

	
	private static final long serialVersionUID = 4818082532605926530L;

	private termsService service = termsService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//데이터 수신
		TermsDTO terms = service.selectTerms();
		
		req.setAttribute("terms", terms);
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/member/terms.jsp");
		dispatcher.forward(req, resp);
	}
}
