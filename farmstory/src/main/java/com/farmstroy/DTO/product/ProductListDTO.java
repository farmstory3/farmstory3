package com.farmstroy.DTO.product;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductListDTO {
	private String path;
	private String url;
	private int prod_idx;
	private String prod_name;
	private String type;
	private BigDecimal price;
	private int stock;
	private String regDate;
	private int discount;
	private BigDecimal point;
}
