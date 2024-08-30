package com.farmstroy.controller.admin;

import java.io.IOException;
import java.util.List;

import com.farmstroy.DTO.order.Order_ProdDTO;
import com.farmstroy.Service.OrderService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/admin/order.do")
public class AdminOrderController extends HttpServlet{
	private OrderService orderService = OrderService.INSTANCE;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<Order_ProdDTO> orders = orderService.selectOrders();
		req.setAttribute("orders", orders);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/adminprod/adminorder.jsp");
		dispatcher.forward(req, resp);
	}
}
