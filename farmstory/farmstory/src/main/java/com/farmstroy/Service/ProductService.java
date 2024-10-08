package com.farmstroy.Service;

import java.util.List;

import com.farmstroy.DAO.product.ProductDAO;
import com.farmstroy.DTO.product.ProductDTO;
import com.farmstroy.DTO.product.ProductListDTO;

public enum ProductService {
	INSTANCE;
	
	private ProductDAO dao = ProductDAO.getInstance();

	public List<ProductDTO> selectProducts() {
		
		return dao.selectProducts();
	}
	
	public List<ProductListDTO> selectProductList(){
		return dao.selectProductList();
	}

	public int deleteProduct(List<String> productIdx) {
		return dao.deleteProduct(productIdx);
	}

	public int insertProduct(ProductDTO product) {
		return dao.insertProduct(product);
	}
	
public List<ProductListDTO> selectMarketProductList(String type) {
		
		return dao.selectMarketProductList(type);
	}
	//jh
	public int SELECT_MARKETPRODUCTS_COUNT() {
		return dao.SELECT_MARKETPRODUCTS_COUNT();
	}
	
	public List<String> SELECT_MARKETPRODUCTS_TYPE() {
		return dao.SELECT_MARKETPRODUCTS_TYPE();
	}
	
	public ProductDTO selectProduct(String prod_idx) {
		return dao.selectProduct(prod_idx);
	}
	
}
