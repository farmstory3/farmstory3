package com.farmstroy.controller.article;

import java.io.IOException;
import java.util.List;

import com.farmstroy.DTO.article.articleDTO;
import com.farmstroy.DTO.article.fileDTO;
import com.farmstroy.Service.articleService;
import com.farmstroy.Service.fileService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/article/write.do")
public class WriteController extends HttpServlet{


	private static final long serialVersionUID = 4818082532605926530L;

	private articleService articleservice = articleService.INSTANCE;
	private fileService fileservice = fileService.INSTANCE;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String write = req.getParameter("write");
		req.setAttribute("write", write);
		String group = req.getParameter("group");
		String cate = req.getParameter("cate");
		String web = "/WEB-INF/";
		String url = web+group+"/"+cate+".jsp";
		System.out.println(url);
		RequestDispatcher dispatcher = req.getRequestDispatcher(url);
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String writer = req.getParameter("writer");
		String group = req.getParameter("group");
		String cate = req.getParameter("cate");
		String regip = req.getRemoteAddr();

		//파일 업로드
		List<fileDTO> files = fileservice.fileUpload(req);

		articleDTO dto = new articleDTO();
		dto.setTitle(title);
		dto.setGroup(group);
		dto.setCate(cate);
		dto.setContent(content);
		dto.setFile(files.size());
		dto.setWriter(writer);
		dto.setRegip(regip);

		//글 등록
		int no = articleservice.insertArticle(dto);

		//파일 등록
		for(fileDTO file : files) {
			file.setAno(no);
			fileservice.insertFile(file);
		}
		resp.sendRedirect("/farmstory/article/list.do?group="+group+"&cate="+cate);
	}

}
