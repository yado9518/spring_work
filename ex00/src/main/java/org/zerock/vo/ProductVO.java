package org.zerock.vo;

import lombok.Data;

@Data
public class ProductVO {
	
	private String name; //상품명
	private double price; //상품가격
	
	public ProductVO(String name, double price) {
		this.name=name; this.price=price;
	}
	
}
