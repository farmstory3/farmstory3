package com.farmstroy.DAO.product;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.farmstroy.DTO.product.ProductDTO;
import com.farmstroy.DTO.product.ProductListDTO;
import com.farmstroy.util.DBHelper;
import com.farmstroy.util.SQL;

public class ProductDAO extends DBHelper{
	private static ProductDAO instance = new ProductDAO();
	
	public static ProductDAO getInstance() {
		return instance;
	}
	
	private ProductDAO() {};
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	public List<ProductDTO> selectProducts() {
		List<ProductDTO> products = new ArrayList<ProductDTO>();
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.SELECT_PRODUCTS);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				ProductDTO product = new ProductDTO();
				product.setProd_idx(rs.getInt("prod_idx"));
				product.setProd_name(rs.getString("prod_name"));
				product.setNickname(rs.getString("nick"));
				product.setType(rs.getString("type"));
				product.setPrice(rs.getBigDecimal("price"));
				product.setPoint(rs.getBigDecimal("point"));
				product.setDeliveryFee(rs.getBigDecimal("deliveryFee"));
				product.setDiscount(rs.getBigDecimal("discount"));
				product.setStock(rs.getInt("discount"));
				product.setEtc(rs.getString("etc"));
				product.setRegDate(rs.getString("regdate"));
				products.add(product);
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		closeAll();
		return products;
	}
	
	public List<ProductListDTO> selectProductList() {
		List<ProductListDTO> productLists = new ArrayList<ProductListDTO>();
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.SELECT_PROD_LIST);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				ProductListDTO productList = new ProductListDTO();
				productList.setPath(rs.getString(1));
				productList.setUrl(rs.getString(2));
				productList.setProd_idx(rs.getInt(3));
				productList.setProd_name(rs.getString(4));
				productList.setType(rs.getString(5));
				productList.setPrice(rs.getBigDecimal(6));
				productList.setStock(rs.getInt(7));
				productList.setRegDate(rs.getString(8));
				productLists.add(productList);
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		closeAll();
		return productLists;
	}
	// jh
	public List<ProductListDTO> selectMarketProductList() {
		List<ProductListDTO> productLists = new ArrayList<ProductListDTO>();
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.SELECT_MARKETPRODUCTS);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				ProductListDTO productList = new ProductListDTO();
				productList.setPath(rs.getString(1));
				productList.setUrl(rs.getString(2));
				productList.setProd_idx(rs.getInt(3));
				productList.setProd_name(rs.getString(4));
				productList.setType(rs.getString(5));
				productList.setPrice(rs.getBigDecimal(6));
				productList.setStock(rs.getInt(7));
				productList.setRegDate(rs.getString(8));
				productList.setPoint(rs.getBigDecimal(9));
				productList.setDiscount(rs.getInt(10));
				productLists.add(productList);
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		closeAll();
		return productLists;
	}
	
	

	public void deleteProduct(List<String> productIdx) {
		if (productIdx == null || productIdx.isEmpty()) {
            return;
        }
		String placeholders = String.join(",", productIdx.stream().map(id -> "?").toArray(String[]::new));

        String sql = "DELETE FROM product WHERE prod_idx IN (" + placeholders + ")";
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(sql);
			
			for (int i = 0; i < productIdx.size(); i++) {
                psmt.setString(i + 1, productIdx.get(i));
            }
			
			psmt.executeUpdate();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		closeAll();
		
	}
	
}
