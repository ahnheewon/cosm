package com.prj.cosm.sales.orders.service;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class OrdersVO {
//고객 주문정보
	/*	
		ORDER_NO
		GOODS_NO
		ORDER_DATE
		DELIVERY_DATE
		TOTAL_NUM
		PRO_PRICE
		NOTE
		ORDER_CODE
		ORDER_PROGRESS_CODE
		DELIVERY_INFO
		IO_CODE
		TOTAL_PRICE
		USERS_NO
		SURTAX
		CLIENT_NAME
	*/

		private String orderNo; 			//주문번호
		private String goodsNo; 			//제품번호
		private String goodsName; 			//제품명
		private String clientName;			//거래처명
		@DateTimeFormat(pattern = "yyyy-MM-dd")
		@JsonFormat(pattern = "yyyy-MM-dd")
		private Date orderDate; 			//주문일자  
		@DateTimeFormat(pattern = "yyyy-MM-dd")
		@JsonFormat(pattern = "yyyy-MM-dd")
		private Date deliveryDate; 			//납기일자 
		private int totalNum; 				//수량 
		private int proPrice; 				//공급가액(부가세 제외한 금액)
		private int surtax;					//부가세 
		private String note; 				//비고(요청사항)
		private String orderCode; 			//코드번호- 주문타입
		private String orderProgressCode;	//진행상황
		private String deliveryInfo; 		//배송상황
		private String ioCode;				//출납상황
		private long totalPrice; 			//총금액
		private String usersNo;				//회원번호
		private String oImg;
		
		
		//체크박스 삭제, 셀렉트박스 상태변경, 체큿 생산지시 요청
		private List<String> noList;
		
		//조인할 아이들
	
	
	
}
