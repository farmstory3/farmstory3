package com.farmstroy.DTO.product;

import java.math.BigDecimal;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public class ProductDTO {
	private int prod_idx;
	private String prod_name;
	private String nickname;
	private String type;
	private BigDecimal price;
	private BigDecimal point;
	private BigDecimal deliveryFee;
	private String regDate;
	private int stock;
	private String etc;
	private int discount;
	private List<ProductFileDTO> prod_file;
	
	public ProductDTO() {
		this.prod_idx = prod_idx;
		this.prod_name = prod_name;
		this.nickname = nickname;
		this.type = type;
		this.price = price;
		this.point = point;
		this.deliveryFee = deliveryFee;
		this.regDate = regDate;
		this.stock = stock;
		this.etc = etc;
		this.discount = discount;
		this.prod_file = prod_file;
	}
	
	public ProductDTO(int prod_idx, String prod_name, String nickname, String type, BigDecimal price, BigDecimal point,
			BigDecimal deliveryFee, String regDate, int stock, String etc, int discount,
			List<ProductFileDTO> prod_file) {
		this.prod_idx = prod_idx;
		this.prod_name = prod_name;
		this.nickname = nickname;
		this.type = type;
		this.price = price;
		this.point = point;
		this.deliveryFee = deliveryFee;
		this.regDate = regDate;
		this.stock = stock;
		this.etc = etc;
		this.discount = discount;
		this.prod_file = prod_file;
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
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
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
	public BigDecimal getPoint() {
		return point;
	}
	public void setPoint(BigDecimal point) {
		this.point = point;
	}
	public BigDecimal getDeliveryFee() {
		return deliveryFee;
	}
	public void setDeliveryFee(BigDecimal deliveryFee) {
		this.deliveryFee = deliveryFee;
	}
	
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getEtc() {
		return etc;
	}
	public void setEtc(String etc) {
		this.etc = etc;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public List<ProductFileDTO> getProd_file() {
		return prod_file;
	}
	public void setProd_file(List<ProductFileDTO> prod_file) {
		this.prod_file = prod_file;
	}
	
	
	
}
