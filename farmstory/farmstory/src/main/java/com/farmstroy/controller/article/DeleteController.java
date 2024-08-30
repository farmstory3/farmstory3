package com.farmstroy.controller.article;

import java.io.IOException;
import java.io.PrintWriter;

import com.farmstroy.Service.articleService;
import com.google.gson.JsonObject;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/article/delete.do")
public class DeleteController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -644645010129807438L;
	private articleService service = articleService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String no = req.getParameter("no");
		String group = req.getParameter("group");
		String cate = req.getParameter("cate");
		
		// 댓글 삭제
		int result = service.deleteArticle(Integer.parseInt(no));
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/article/list.do?group=event&cate=info");
		dispatcher.forward(req, resp);
	}
}
