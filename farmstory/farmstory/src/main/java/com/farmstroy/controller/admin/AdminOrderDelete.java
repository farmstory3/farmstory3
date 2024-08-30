package com.farmstroy.controller.admin;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.farmstroy.Service.OrderService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/admin/deleteOrder.do")
public class AdminOrderDelete extends HttpServlet{
	private OrderService orderService = OrderService.INSTANCE;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String[] selectedProducts = req.getParameterValues("selectedProducts");
		List<String> productIdx = null;
        if (selectedProducts != null) {
        	productIdx = Arrays.asList(selectedProducts);
        } else {
            System.out.println("No products were selected.");
        }
        
        int r = orderService.deleteProduct(productIdx);
        req.setAttribute("r", r);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/adminprod/adminorder.jsp");
		dispatcher.forward(req, resp);
	}
}
