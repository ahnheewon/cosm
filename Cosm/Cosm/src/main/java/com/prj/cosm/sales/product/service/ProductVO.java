package com.prj.cosm.sales.product.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class ProductVO {
//제품리스트 - 고객용
	/*
name
price
period
info
img
*/
	private String name; // 제품명
	private int price; // 단가
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date period; // 제작기간
	private String info; // 상세정보
	private String img; // 이미지
}
