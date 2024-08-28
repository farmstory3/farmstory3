package com.farmstroy.controller.admin;

import java.io.IOException;
import java.util.List;

import com.farmstroy.DTO.member.MemberDTO;
import com.farmstroy.DTO.order.Order_ProdDTO;
import com.farmstroy.DTO.product.ProductDTO;
import com.farmstroy.Service.MemberService;
import com.farmstroy.Service.OrderService;
import com.farmstroy.Service.ProductService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/test/admin.do")
public class AdminMainController extends HttpServlet{
	
	private MemberService memberService = MemberService.INSTANCE;
	private ProductService productService = ProductService.INSTANCE;
	private OrderService orderService = OrderService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<MemberDTO> users = memberService.selectUsers();
		List<ProductDTO> products = productService.selectProducts();
		List<Order_ProdDTO> orders = orderService.selectOrders();
		
		req.setAttribute("users", users);
		req.setAttribute("products", products);
		req.setAttribute("orders", orders);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/adminprod/adminmain.jsp");
		dispatcher.forward(req, resp);
	}
	
}
