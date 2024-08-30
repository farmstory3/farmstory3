package com.farmstroy.controller.article;

import java.io.IOException;
import java.util.List;

import com.farmstroy.DTO.article.articleDTO;
import com.farmstroy.DTO.comment.CommentDTO;
import com.farmstroy.Service.CommentService;
import com.farmstroy.Service.articleService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/article/view.do")
public class ViewController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2269741132052926330L;
	private articleService service = articleService.INSTANCE;
	private CommentService commentService = CommentService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String no = req.getParameter("no");
		String pg = req.getParameter("pg");
		String view = req.getParameter("view");
		req.setAttribute("view", view);
		String group = req.getParameter("group");
		String cate = req.getParameter("cate");
		String web = "/WEB-INF/";
		String url = web+group+"/"+cate+".jsp";
		System.out.println(url);
			
		// 데이터 조회
		articleDTO articleDto = service.selectArticle(no);
		
		// 댓글 조회
		List<CommentDTO> comments = commentService.selectComments(no);
		
		// 공유 참조
		req.setAttribute("articleDto", articleDto);
		req.setAttribute("pg", pg);
		req.setAttribute("comments", comments);
		
		// 조회수 증가 
		service.updateArticleHitCount(no);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher(url);
		dispatcher.forward(req, resp);
	
	}
	
}
