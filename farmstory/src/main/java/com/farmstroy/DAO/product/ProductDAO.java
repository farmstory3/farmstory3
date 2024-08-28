package com.farmstroy.DAO.product;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
				product.setProd_idx(rs.getInt(1));
				product.setProd_name(rs.getString(2));
				product.setNickname(rs.getString(3));
				product.setType(rs.getString(4));
				product.setPrice(rs.getBigDecimal(5));
				product.setPoint(rs.getBigDecimal(6));
				product.setDeliveryFee(rs.getBigDecimal(7));
				product.setStock(rs.getInt(8));
				product.setEtc(rs.getString(9));
				product.setRegDate(rs.getString(10));
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
				productList.setPath(rs.getString("path"));
				productList.setUrl(rs.getString("filename"));
				productList.setProd_idx(rs.getInt("prod_idx"));
				productList.setProd_name(rs.getString("prod_name"));
				productList.setType(rs.getString("type"));
				productList.setPrice(rs.getBigDecimal("price"));
				productList.setStock(rs.getInt("stock"));
				productList.setRegDate(rs.getString("regDate"));
				productLists.add(productList);
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		closeAll();
		return productLists;
	}

	public int deleteProduct(List<String> productIdx) {
		int result = 0;
		if (productIdx == null || productIdx.isEmpty()) {
            return result;
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
			result = 2;
			return result;
		}
		closeAll();
		result = 1;
		return result;
	}

	public int insertProduct(ProductDTO product) {
	    long generatedKey = 0;
	    int affectedRows = 0;
	    try {
	        conn = getConnection();
	        
	        conn.setAutoCommit(false);
	        
	        psmt = conn.prepareStatement(SQL.INSERT_PRODUCT, PreparedStatement.RETURN_GENERATED_KEYS);
	        psmt.setString(1, product.getProd_name());
	        psmt.setString(2, product.getType());
	        psmt.setBigDecimal(3, product.getPrice());
	        psmt.setBigDecimal(4, product.getPoint());
	        psmt.setBigDecimal(5, product.getDeliveryFee());
	        psmt.setInt(6, product.getDiscount());
	        psmt.setInt(7, product.getStock());
	        psmt.setString(8, product.getEtc());
	        affectedRows = psmt.executeUpdate();
	        
	        try (ResultSet generatedKeys = psmt.getGeneratedKeys()) {
	            if (generatedKeys.next()) {
	                generatedKey = generatedKeys.getLong(1);
	                System.out.println("Generated primary key: " + generatedKey);
	            } else {
	                throw new Exception("Creating board failed, no ID obtained.");
	            }
	        }
	        
	        for(int i=0; i< product.getProd_file().size(); i++) {
	            psmt2 = conn.prepareStatement(SQL.INSERT_PRODUCT_FILE);
	            psmt2.setInt(1, (int)generatedKey);
	            psmt2.setString(2, product.getProd_file().get(i).getFilename());
	            psmt2.setString(3, product.getProd_file().get(i).getPath());
	            psmt2.setInt(4, product.getProd_file().get(i).getType());
	            psmt2.executeUpdate(); // 파일 정보를 삽입하는 쿼리 실행
	        }
	        
	        conn.commit();
	    } catch (Exception e) {
	        try {
	            System.out.println("Transaction error, rolling back.");
	            e.printStackTrace(); // 예외 메시지 출력
	            conn.rollback();
	        } catch (SQLException e1) {
	            e1.printStackTrace();
	        }
	    } finally {
	        try {
	            if (conn != null) conn.close(); // 연결 닫기
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    return affectedRows;
	}
	
}
