package com.farmstroy.DTO.order;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Order_ProdDTO {
	private int order_idx;
	private int prod_idx;
	private String prod_name;
	private BigDecimal price;
	private int quantity;
	private BigDecimal deliveryFee;
	private BigDecimal total_price;
	private String uid;
	private String order_rdate;
}
