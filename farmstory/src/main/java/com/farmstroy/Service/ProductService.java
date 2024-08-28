package com.farmstroy.Service;

import java.util.ArrayList;
import java.util.List;

import com.farmstroy.DAO.product.ProductDAO;
import com.farmstroy.DTO.product.ProductDTO;
import com.farmstroy.DTO.product.ProductListDTO;
import com.farmstroy.util.SQL;

public enum ProductService {
	INSTANCE;
	
	private ProductDAO dao = ProductDAO.getInstance();

	public List<ProductDTO> selectProducts() {
		
		return dao.selectProducts();
	}
	
	public List<ProductListDTO> selectProductList(){
		return dao.selectProductList();
	}

	public void deleteProduct(List<String> productIdx) {
		dao.deleteProduct(productIdx);
	}
	
	public List<ProductListDTO> selectMarketProductList() {
		
		return dao.selectMarketProductList();
	}
}
