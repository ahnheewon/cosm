package com.prj.cosm.sales.orders.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.prj.cosm.sales.orders.service.OrdersVO;

public interface OrdersMapper {
//주문
	
		//주문번호순 정렬 -> xml에서 타입 맞춰줘야함 
		public int getOrderNo();
		
		//신규주문 전체조회
		public List<OrdersVO> getOrderList();
		
		//접수주문 전체조회
		public List<OrdersVO> getReceiptList();
		
		//접수주문 - 단건조회
		public OrdersVO getOrderInfo(OrdersVO vo);
		
		//주문 등록 
		public int insertOrder(OrdersVO vo);
		
		//삭제
		public int deleteOrder(@Param("orderNo")int orderNo);
		
		//신규
		//수정 - 주문상태 - 재고입출고 상황 - 배송상황
		//1. 변수에 값 보내는 방법 - 1) param, 2) vo
		//2. 외부에서 들어오는 변수의 갯수 생각
		public int updateOrder(OrdersVO vo);
		
 
		//체크박스 -> 여러건 삭제 
		public int deleteCheck(String noList);
		
		//접수
		public int recNos(List<OrdersVO> vo);
		
	
		
}
