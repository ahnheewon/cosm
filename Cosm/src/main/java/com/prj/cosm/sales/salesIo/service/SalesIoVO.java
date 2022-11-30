package com.prj.cosm.sales.salesIo.service;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class SalesIoVO {
//완제품 관리(출고, 검수)
	/*
	SALES_NO,
	ORDER_DATE,
	DELIVERY_DATE,
	STATE,
	NOTE,
	CODE_NO,
	CKECK,
	ORDER_NO,
	USERS_NO,
	REGIST_LOT,
	ORDER_CODE
	*/
	
	private String salesNo;					//완제품번호
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date orderDate; 				//주문일자
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date deliveryDate;				//납기일자
	private String state;					//진행상황
	private String note;					//요청메세지
	private String codeNo;					//코드번호
	private String ckeck;					//검수여부
	private String orderNo;					//주문번호
	private String usersNo;					//회원번호
	private String registLot;				//lot_no
	private String orderCode;
	private String clientName;
	private String goodsName;
	
	//다중 수정 삭제
	private List<String> sioList;
}
