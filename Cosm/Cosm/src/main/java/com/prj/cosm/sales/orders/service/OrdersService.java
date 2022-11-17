package com.prj.cosm.sales.orders.service;

import java.util.List;

public interface OrdersService {
//고객의 주문정보

	// 주문번호순으로 정렬
	public int getOrderNo();

	// 주문 전체조회
	public List<OrdersVO> salesOrderList();

	// 주문 단건조회
	public OrdersVO selectOrderInfo(OrdersVO vo);

	// 주문 등록
	// public int insertOrder(int orderNo);
	public int insertOrder(OrdersVO vo);

	// 주문 내역삭제
	// public int deleteOrderInfo(int orderNo);
	public int deleteOrderInfo(OrdersVO vo);

	// 수정
	public int deleteOrder(OrdersVO vo);

	// 주문정보 삭제 - 영업팀
	public int deleteCheck(List<String> delOno);
	
	
	/*
	 * 데이터 다건 추가시 public class GridData<T> { private List<T> updatedRows; private
	 * List<T> deletedRows; private List<T> createdRows; }
	 */
}
