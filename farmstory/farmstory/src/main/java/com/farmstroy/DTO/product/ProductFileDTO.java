package com.farmstroy.DTO.product;

import lombok.Getter;
import lombok.Setter;


public class ProductFileDTO {
	private int prod_idx;
	private String filename;
	private String path;
	private int type;
	public int getProd_idx() {
		return prod_idx;
	}
	public void setProd_idx(int prod_idx) {
		this.prod_idx = prod_idx;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "ProductFileDTO [prod_idx=" + prod_idx + ", filename=" + filename + ", path=" + path + ", type=" + type
				+ "]";
	}
	
	
}
