package com.farmstroy.DTO.order;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDTO {
	private int order_idx;
	private int prod_idx;
	private String uid;
	private String order_rdate;
	private int quantity;
	private BigDecimal price;
	private BigDecimal total_price;
}
