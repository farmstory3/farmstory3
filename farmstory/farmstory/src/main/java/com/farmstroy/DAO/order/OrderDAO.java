package com.farmstroy.DAO.order;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.farmstroy.DTO.order.Order_ProdDTO;
import com.farmstroy.util.DBHelper;
import com.farmstroy.util.SQL;

public class OrderDAO extends DBHelper{
	private static OrderDAO instance = new OrderDAO();
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	public static OrderDAO getInstance() {
		return instance;
	}
	
	private OrderDAO() {}

	public List<Order_ProdDTO> selectOrders() {
		List<Order_ProdDTO> orders = new ArrayList<Order_ProdDTO>();
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.SELECT_ORDERS);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				Order_ProdDTO order = new Order_ProdDTO();
				int orderIdx = rs.getInt("order_idx");
                String prodName = rs.getString("prod_name");
                BigDecimal price = rs.getBigDecimal("price");
                int quantity = rs.getInt("quantity");
                BigDecimal deliveryFee = rs.getBigDecimal("deliveryFee");
                BigDecimal totalPrice = rs.getBigDecimal("total_price");
                String uid = rs.getString("uid");
                String orderRDate = rs.getString("order_rdate");
                
                order.setOrder_idx(orderIdx);
                order.setProd_name(prodName);
                order.setPrice(price);
                order.setQuantity(quantity);
                order.setDeliveryFee(deliveryFee);
                order.setTotal_price(totalPrice);
                order.setUid(uid);
                order.setOrder_rdate(orderRDate);
				orders.add(order);
			}
			
			
		} catch (Exception e) {
			logger.error(e.getMessage());
		}finally {
			closeAll();
		}
		return orders;
	}

	public int deleteOrder(List<String> productIdx) {
		int result = 0;
		if (productIdx == null || productIdx.isEmpty()) {
            return result;
        }
		String placeholders = String.join(",", productIdx.stream().map(id -> "?").toArray(String[]::new));
		String sql = "DELETE FROM `order` WHERE order_idx IN (" + placeholders + ")";
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
		}finally {
			closeAll();
		}
		result = 1;
		return result;
	}
}
