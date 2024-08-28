package com.farmstory.controller.article;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.farmstory.DTO.article.articleDTO;
import com.farmstory.DTO.article.groupDTO;
import com.farmstory.DTO.article.pagegroupDTO;
import com.farmstroy.Service.articleService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/article/list.do")
public class ListController extends HttpServlet{


	private static final long serialVersionUID = 4818082532605926530L;

	private articleService service = articleService.INSTANCE;
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String pg = req.getParameter("pg");
		String group = req.getParameter("group");
		String cate = req.getParameter("cate");
		
		// 그룹 DTO생성
		groupDTO groupdto = new groupDTO(group, cate);
		
		// 현재 페이지 번호 구하기
		int currentPageNum = service.getCurrentPage(pg);
		
		// 현재 페이지 그룹 구하기
		pagegroupDTO pageGroup = service.getCurrentPageGroup(currentPageNum);
		
		// 전체 게시물 갯수 구하기 
		int total = service.selectCountTotal(groupdto);
		logger.debug("total: "+total);
		
		// 마지막 페이지 번호 
		int pageLastNum = service.getLastPageNum(total);
		
		// 페이지 시작 번호 구하기
		int start = service.getStartNum(currentPageNum);
		
		// 페이지 시작 번호 구하기(목록에서 순서번호로 활용)
		int pageStartNum = service.getPageStartNum(total, currentPageNum);
		
		//데이터 조회
		List<articleDTO> articles = service.selectArticles(groupdto, start);
		logger.debug(articles.toString());
		
		//공유 참조
		req.setAttribute("articles", articles);
		req.setAttribute("currentPageNum", currentPageNum);
		req.setAttribute("pageLastNum", pageLastNum);
		req.setAttribute("pageStartNum", pageStartNum);
		req.setAttribute("pageGroup", pageGroup);
		req.setAttribute("group",group);
		
		logger.debug("articles : "+ articles);
		logger.debug("currentPageNum : "+ currentPageNum);
		logger.debug("pageLastNum : "+ pageLastNum);
		logger.debug("pageStartNum : "+ pageStartNum);
		logger.debug("pageGroup : "+ pageGroup);
		
		if(group.equals("croptalk") && cate.equals("story")) {
			RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/croptalk/story.jsp");
			dispatcher.forward(req, resp);
		} else if(group.equals("croptalk") && cate.equals("grow")) {
			RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/croptalk/grow.jsp");
			dispatcher.forward(req, resp);
		} else if(group.equals("croptalk") && cate.equals("school")) {
			RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/croptalk/school.jsp");
			dispatcher.forward(req, resp);
		} else if(group.equals("event")&& cate.equals("info")) {
			RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/event/info.jsp");
			dispatcher.forward(req, resp);
		} else if(group.equals("community")&& cate.equals("notice")) {
			RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/community/notice.jsp");
			dispatcher.forward(req, resp);
		} else if(group.equals("community")&& cate.equals("chef")) {
			RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/community/chef.jsp");
			dispatcher.forward(req, resp);
		} else if(group.equals("community")&& cate.equals("faq")) {
			RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/community/faq.jsp");
			dispatcher.forward(req, resp);
		} else if(group.equals("community")&& cate.equals("menu")) {
			RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/community/menu.jsp");
			dispatcher.forward(req, resp);
		} else if(group.equals("community")&& cate.equals("qna")) {
			RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/community/qna.jsp");
			dispatcher.forward(req, resp);
		}
	}
}

