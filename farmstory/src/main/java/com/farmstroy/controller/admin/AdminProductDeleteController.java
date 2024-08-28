package com.farmstroy.controller.admin;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.farmstroy.DTO.product.ProductListDTO;
import com.farmstroy.Service.ProductService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/admin/deleteProduct.do")
public class AdminProductDeleteController extends HttpServlet {
	private ProductService productService = ProductService.INSTANCE;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String[] selectedProducts = req.getParameterValues("selectedProducts");
		List<String> productIdx = null;
        if (selectedProducts != null) {
        	productIdx = Arrays.asList(selectedProducts);
        } else {
            System.out.println("No products were selected.");
        }
		productService.deleteProduct(productIdx);
		
		List<ProductListDTO> productLists = productService.selectProductList();
		req.setAttribute("productLists", productLists);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/adminprod/adminproduct.jsp");
		dispatcher.forward(req, resp);
	}
}
