package com.farmstroy.DTO.article;

public class groupDTO {
	private String group;
	private String cate;
	
	public groupDTO(String group, String cate) {
		this.group = group;
		this.cate = cate;
	}
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	public String getCate() {
		return cate;
	}
	public void setCate(String cate) {
		this.cate = cate;
	}	
}
