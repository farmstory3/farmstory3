package com.farmstroy.controller.market;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import com.farmstroy.DTO.cart.CartDTO;
import com.farmstroy.DTO.member.MemberDTO;
import com.farmstroy.DTO.product.ProductDTO;
import com.farmstroy.Service.CartService;
import com.farmstroy.Service.ProductService;
import com.mysql.cj.Session;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/market/cart.do")
public class CartController extends HttpServlet {
	private CartService cartService = CartService.INSTANCE;
	private ProductService prodService = ProductService.INSTANCE;
	
	private static final long serialVersionUID = 6377194638700892149L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		MemberDTO member = (MemberDTO)(session.getAttribute("sessUser"));
		String uid = member.getUid();
		List<CartDTO> cart_items = cartService.selectCartItems(uid);
		
		CartDTO cart_items_sum = cartService.selectCartItemsSum(uid);
		req.setAttribute("cart_items_sum", cart_items_sum);
		
		req.setAttribute("cart_items", cart_items);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/market/cart.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		MemberDTO member = (MemberDTO)(session.getAttribute("sessUser"));
		String uid = member.getUid();
		String prod_name = req.getParameter("prod_name");
		String prod_idx = req.getParameter("prod_idx");
		String deliveryFeeStr = req.getParameter("deliveryFee");
		BigDecimal deliveryFee = new BigDecimal(deliveryFeeStr.substring(0,deliveryFeeStr.length()-1));
		BigDecimal price = new BigDecimal(req.getParameter("price").substring(0,req.getParameter("price").length()-1));
		BigDecimal sum = new BigDecimal(req.getParameter("sum").substring(0,req.getParameter("sum").length()-1));
		int sumInt = Integer.parseInt(req.getParameter("sum").substring(0,req.getParameter("sum").length()-1));
		int quantity = Integer.parseInt(req.getParameter("quantity"));
		int pointInt = sumInt/100;
		BigDecimal point = new BigDecimal(pointInt);
		ProductDTO product = prodService.selectProduct(prod_idx);
		String fileName = product.getProd_file().get(0).getFilename();
		String path = product.getProd_file().get(0).getPath();
		int discount = product.getDiscount();
		String type = product.getType();
		BigDecimal quantityBig = new BigDecimal(quantity);
		
		BigDecimal mulPrice = quantityBig.multiply(price);
		BigDecimal mulPoint = quantityBig.multiply(point);
		int cart_idx = cartService.selectCart(uid);
		System.out.println(cart_idx);
		CartDTO cart = new CartDTO();
		cart.setDiscount(discount);
		cart.setFileName(fileName);
		cart.setPath(path);
		cart.setPoint(mulPoint);
		cart.setPrice(mulPrice);
		cart.setProd_name(prod_name);
		cart.setQuantity(quantity);
		cart.setSum(sum);
		cart.setType(type);
		cart.setCart_idx(cart_idx);
		cart.setUid(uid);
		
		cartService.insertCart(cart);
		
		resp.sendRedirect("/farmstory/market/list.do");

	}
}
