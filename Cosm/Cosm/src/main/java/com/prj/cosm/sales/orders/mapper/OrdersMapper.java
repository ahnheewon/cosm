package com.prj.cosm.sales.orders.mapper;

import java.util.List;

import com.prj.cosm.sales.orders.service.OrdersVO;

public interface OrdersMapper {
//주문
	
		//주문번호순으로 정렬 -> xml에서 타입 맞춰줘야함 
		public int getOrderNo();
		
		//주문 전체조회
		public List<OrdersVO> orderList();
		
		//주문 단건조회
		public OrdersVO orderInfo(OrdersVO vo);
		
		//주문 등록 
		//public int insertOrder(int orderNo);
		public int insertOrder(OrdersVO vo);
		
		//주문 내역삭제
		//체크박스 -> 여러건 삭제 
		public int deleteOrder(OrdersVO vo);
		
		//수정 - 주문상태 - 재고입출고 상황 - 배송상황
		//1. 변수에 값 보내는 방법 - 1) param, 2) vo
		//2. 외부에서 들어오는 변수의 갯수 생각
		public int updateOrder(OrdersVO vo);
		
		
		//주문정보 삭제 - 영업팀
		public int deleteCheck(String  delOno);
		
}
