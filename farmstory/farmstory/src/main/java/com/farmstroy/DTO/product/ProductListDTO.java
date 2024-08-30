package com.farmstroy.DTO.product;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

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
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getProd_idx() {
		return prod_idx;
	}
	public void setProd_idx(int prod_idx) {
		this.prod_idx = prod_idx;
	}
	public String getProd_name() {
		return prod_name;
	}
	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public BigDecimal getPoint() {
		return point;
	}
	public void setPoint(BigDecimal point) {
		this.point = point;
	}
	@Override
	public String toString() {
		return "ProductListDTO [path=" + path + ", url=" + url + ", prod_idx=" + prod_idx + ", prod_name=" + prod_name
				+ ", type=" + type + ", price=" + price + ", stock=" + stock + ", regDate=" + regDate + ", discount="
				+ discount + ", point=" + point + "]";
	}
	
	
}
