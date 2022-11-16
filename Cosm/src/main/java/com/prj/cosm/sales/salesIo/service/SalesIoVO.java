package com.prj.cosm.sales.salesIo.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class SalesIoVO {
//완제품 관리(출고, 검수)
	/*
order_date
delivery_date
state
note
client_no
regist_LOT
code_no
Field -> 검수여부, 생산이랑 상의*/
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date orderDate; // 주문일자
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date deliveryDate; // 납기일자
	private String state; // 진행상황
	private String note; // 요청메세지
	private int clientNo; // 거래처번호
	private String registLOT; // LOT_NO
	private String codeNo; // 코드번호
	private String Field; // 검수여부

}
