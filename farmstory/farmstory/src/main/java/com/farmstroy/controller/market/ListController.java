package com.farmstroy.controller.market;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.farmstroy.DTO.product.ProductListDTO;
import com.farmstroy.Service.ProductService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/market/list.do")
public class ListController extends HttpServlet{


	private static final long serialVersionUID = 3798812811405024593L;
	
	private ProductService service = ProductService.INSTANCE;
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String type = req.getParameter("type");
		
		List<ProductListDTO> products = service.selectMarketProductList(type);
		List<String> types = service.SELECT_MARKETPRODUCTS_TYPE();
		
		int count = service.SELECT_MARKETPRODUCTS_COUNT();
		
		req.setAttribute("products", products);
		req.setAttribute("count", count);
		req.setAttribute("types", types);
		
		logger.debug("products" + products);
		logger.debug("count" + count);
		logger.debug("types" + types);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/market/list.jsp");
		dispatcher.forward(req, resp);
	}
	
	
	
}
