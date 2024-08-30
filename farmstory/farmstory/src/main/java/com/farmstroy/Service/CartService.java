package com.farmstroy.Service;

import java.util.List;

import com.farmstroy.DAO.cart.CartDAO;
import com.farmstroy.DTO.cart.CartDTO;

public enum CartService {
	INSTANCE;
	
	private CartDAO dao = CartDAO.getInstance();

	public int selectCart(String uid) {
		
		return dao.selectCart(uid);
	}

	public void insertCart(CartDTO cart) {
		
		dao.insertCart(cart);
	}

	public List<CartDTO> selectCartItems(String uid) {
		return dao.selectCartItems(uid);
	}

	public void deleteItems(List<Integer> cartIdsList) {
		
		for (Integer cartId : cartIdsList) {
			dao.deleteItems(cartId);
        }
		
	}

	public CartDTO selectCartItemsSum(String uid) {
		return dao.selectCartItemsSum(uid);
	}

	
	
}
