package com.farmstroy.DTO.product;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductFileDTO {
	private int prod_idx;
	private String filename;
	private String path;
	private int type;
}
