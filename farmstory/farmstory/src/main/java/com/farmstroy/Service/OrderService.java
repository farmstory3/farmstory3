package com.farmstroy.Service;

import java.util.List;

import com.farmstroy.DAO.order.OrderDAO;
import com.farmstroy.DTO.order.Order_ProdDTO;

public enum OrderService {
	INSTANCE;
	
	private OrderDAO dao = OrderDAO.getInstance();
	
	public List<Order_ProdDTO> selectOrders() {
		return dao.selectOrders();
	}

	public int deleteProduct(List<String> productIdx) {
		
		return dao.deleteOrder(productIdx);
	}
}
