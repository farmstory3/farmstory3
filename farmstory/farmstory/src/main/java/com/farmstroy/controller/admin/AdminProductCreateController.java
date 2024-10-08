package com.farmstroy.controller.admin;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.farmstroy.DTO.article.fileDTO;
import com.farmstroy.DTO.product.ProductDTO;
import com.farmstroy.DTO.product.ProductFileDTO;
import com.farmstroy.DTO.product.ProductListDTO;
import com.farmstroy.Service.ProductService;
import com.farmstroy.Service.fileService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/admin/prodcreate.do")
public class AdminProductCreateController extends HttpServlet{
	private fileService fileservice = fileService.INSTANCE;
	private ProductService productService = ProductService.INSTANCE;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ProductDTO product = new ProductDTO();
		product.setProd_name(req.getParameter("prod_name"));
		product.setType(req.getParameter("type"));
		product.setPrice(new BigDecimal(req.getParameter("price")));
		product.setPoint(new BigDecimal(req.getParameter("point")));
		product.setDiscount(Integer.parseInt(req.getParameter("discount")));
		product.setDeliveryFee(new BigDecimal(req.getParameter("deliveryfee")));
		product.setStock(Integer.parseInt(req.getParameter("stock")));
		product.setEtc(req.getParameter("etc"));
		
		List<ProductFileDTO> productFiles = new ArrayList<ProductFileDTO>();
		List<fileDTO> files = fileservice.fileUpload(req);
		

		for(int i=0; i<files.size(); i++) {
			ProductFileDTO file = new ProductFileDTO();
			file.setFilename(files.get(i).getsName());
			file.setPath("/farmstory/uploads/");
			file.setType(i);
			productFiles.add(file);
		}
		
		
		
		product.setProd_file(productFiles);
		
		int result = productService.insertProduct(product);
		
		if(result!=0) {
			List<ProductListDTO> productLists = productService.selectProductList();
			
			
			req.setAttribute("productLists", productLists);
			RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/adminprod/adminproduct.jsp");
			dispatcher.forward(req, resp);
		} else {
			RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/adminprod/adminprodcreate.jsp");
			dispatcher.forward(req, resp);
		}
	}
}
