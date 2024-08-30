package com.farmstroy.DTO.order;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;


public class OrderDTO {
	private int order_idx;
	private int prod_idx;
	private String uid;
	private String order_rdate;
	private int quantity;
	private BigDecimal price;
	private BigDecimal total_price;
	public int getOrder_idx() {
		return order_idx;
	}
	public void setOrder_idx(int order_idx) {
		this.order_idx = order_idx;
	}
	public int getProd_idx() {
		return prod_idx;
	}
	public void setProd_idx(int prod_idx) {
		this.prod_idx = prod_idx;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getOrder_rdate() {
		return order_rdate;
	}
	public void setOrder_rdate(String order_rdate) {
		this.order_rdate = order_rdate;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public BigDecimal getTotal_price() {
		return total_price;
	}
	public void setTotal_price(BigDecimal total_price) {
		this.total_price = total_price;
	}
	@Override
	public String toString() {
		return "OrderDTO [order_idx=" + order_idx + ", prod_idx=" + prod_idx + ", uid=" + uid + ", order_rdate="
				+ order_rdate + ", quantity=" + quantity + ", price=" + price + ", total_price=" + total_price + "]";
	}
	
}
