package com.farmstroy.controller.admin;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.farmstroy.DTO.article.pagegroupDTO;
import com.farmstroy.DTO.member.MemberDTO;
import com.farmstroy.Service.MemberService;
import com.farmstroy.Service.articleService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/admin/member.do")
public class AdminMemberController extends HttpServlet{
	private static final long serialVersionUID = -409203805936676515L;
	private MemberService memberService = MemberService.INSTANCE;
	private articleService service = articleService.INSTANCE;
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String pg = req.getParameter("pg");
		
		// 현재 페이지 번호 구하기
		int currentPageNum = service.getCurrentPage(pg);
		
		// 현재 페이지 그룹 구하기
		pagegroupDTO pageGroup = service.getCurrentPageGroup(currentPageNum);
		
		// 전체 게시물 갯수 구하기 
		int total = service.selectCountTotalMember();
		logger.debug("total: "+total);
		
		// 마지막 페이지 번호 
		int pageLastNum = service.getLastPageNum(total);
		
		// 페이지 시작 번호 구하기
		int start = service.getStartNum(currentPageNum);
		
		// 페이지 시작 번호 구하기(목록에서 순서번호로 활용)
		int pageStartNum = service.getPageStartNum(total, currentPageNum);
		
		//데이터 조회
		List<MemberDTO> members = memberService.selectMembersList(start);
		logger.debug(members.toString());
		
		//공유 참조
		req.setAttribute("members", members);
		req.setAttribute("currentPageNum", currentPageNum);
		req.setAttribute("pageLastNum", pageLastNum);
		req.setAttribute("pageStartNum", pageStartNum);
		req.setAttribute("pageGroup", pageGroup);
		
		logger.debug("members : "+ members);
		logger.debug("currentPageNum : "+ currentPageNum);
		logger.debug("pageLastNum : "+ pageLastNum);
		logger.debug("pageStartNum : "+ pageStartNum);
		logger.debug("pageGroup : "+ pageGroup);
	
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/adminprod/adminMember.jsp");
		dispatcher.forward(req, resp);
	}
		
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
}
