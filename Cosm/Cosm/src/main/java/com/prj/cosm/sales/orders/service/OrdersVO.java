package com.prj.cosm.sales.orders.service;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class OrdersVO {
//고객 주문정보
	/*ORDER_NO,
		CLIENT_NO,
		PRODUCT_NO,
		ORDER_DATE,
		DELIVERY_DATE,
		PRODUCT_NAME,
		TOTAL_NUM,
		TOTAL_PRICE,
		SURTAX,
		NOTE,
		ORDER_CODE,
		ORDER_PROGRESS_CODE,
		DELIVERY_INFO,
		IO_CODE
		*/

	private int orderNo; 			//주문번호 //	order_no
	private int clientNo; 			//거래처번호 //	client_no
	private int productNo; 			//제품번호 //	product_no
	 @DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date orderDate; 		//주문일자  order_date
	 @DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date deliveryDate; 		//납기일자 /	delivery_date
	private String productName; 	//제품명/ 	product_name
	private int totalNum; 			//수량 //	total_num
	private int totalPrice; 		//공급가액(부가세 제외한 금액)  //	total_price
	private int surtax;				//부가세 //	surtax
	private String note; 				//비고(요청사항) /	note
	private String orderCode; 		//코드번호- 주문타입 //	order_code
	private String orderProgressCode; //진행상황 //	order_progress_code
	private String deliveryInfo; 	// 배송상황
	private String ioCode;			//출납상황
	
	
	//체크박스 삭제할 번호 field
	private List<String> delOno;
	
	//조인할 아이들
	
	
	
}
