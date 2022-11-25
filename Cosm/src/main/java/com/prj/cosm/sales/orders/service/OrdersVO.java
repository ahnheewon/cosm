package com.prj.cosm.sales.orders.service;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class OrdersVO {
//고객 주문정보
	/*	order_no	NUMBER		NOT NULL,
		product_no	NUMBER		NULL,
		order_date	DATE		NULL,
		delivery_date	DATE		NULL,
		total_num	NUMBER		NULL,
		pro_price	NUMBER		NULL,
		surtax	NUMBER		NULL,
		note	VARCHAR2(2000)		NULL,
		order_code	VARCHAR2(10)		NULL,
		order_progress_code	VARCHAR2(10)		NULL,
		delivery_info	VARCHAR2(10)		NULL,
		io_code	VARCHAR2(10)		NULL,
		total_price	NUMBER		NULL
	*/

		private String orderNo; 			//주문번호
		private String productNo; 			//제품번호
		@DateTimeFormat(pattern = "yyyy-MM-dd")
		@JsonFormat(pattern = "yyyy-MM-dd")
		private Date orderDate; 			//주문일자  
		@DateTimeFormat(pattern = "yyyy-MM-dd")
		@JsonFormat(pattern = "yyyy-MM-dd")
		private Date deliveryDate; 			//납기일자 
		private int totalNum; 				//수량 
		private int proPrice; 			//공급가액(부가세 제외한 금액)
		private int surtax;					//부가세 
		private String note; 				//비고(요청사항)
		private String orderCode; 			//코드번호- 주문타입
		private String orderProgressCode;	//진행상황
		private String deliveryInfo; 		//배송상황
		private String ioCode;				//출납상황
		private int totalPrice; 			//총금액
	
		
		//체크박스 삭제, 셀렉트박스 상태변경, 체큿 생산지시 요청
		private List<String> noList;
		
		//조인할 아이들
	
	
	
}
