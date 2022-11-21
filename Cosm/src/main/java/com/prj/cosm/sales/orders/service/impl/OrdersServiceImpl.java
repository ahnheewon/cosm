package com.prj.cosm.sales.orders.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prj.cosm.sales.orders.mapper.OrdersMapper;
import com.prj.cosm.sales.orders.service.OrdersService;
import com.prj.cosm.sales.orders.service.OrdersVO;

@Service
public class OrdersServiceImpl implements OrdersService {

	@Autowired
	OrdersMapper mapper;

	@Override
	public int getOrderNo() {
		// 주문번호순 정렬
		return mapper.getOrderNo();
	}

	@Override
	public List<OrdersVO> salesOrderList() {
		// 주문전체조회
		return mapper.orderList();
	}

	@Override
	public OrdersVO selectOrderInfo(OrdersVO vo) {
		// 주문 상세조회 - 단건
		return mapper.orderInfo(vo);
	}

	@Override
	public int insertOrder(OrdersVO vo) {
		// TODO 주문등록
		return mapper.insertOrder(vo);
	}

	@Override
	public int deleteOrder(OrdersVO vo) {
		// 주문 삭제
		return mapper.deleteOrder(vo);
	}

	@Override
	public int deleteOrderInfo(OrdersVO vo) {
		// 단건 수정
		return mapper.deleteOrder(vo);
	}

	@Override
	public int deleteCheck(List<String> noList) {
		// 체크박스 주문정보 여러건 삭제
		int result = 0;
		System.out.println(noList);
		// 여러개 지우기
		for (String no : noList) {
			result += mapper.deleteCheck(no);
		}
		// int a = result > 0 ? 1 : 0;
		return result;
	}

	// 여러건 수정
	@Override
	public int updatePro(List<OrdersVO> list) {
		int result = 0;
		System.out.println("생상지시 상황 : " + list);
		for (OrdersVO vo : list) {
			result += mapper.updateOrder(vo);
		}
		return result;
	}

	@Override
	public int recNos(List<OrdersVO> vo) {
		// 신규 -> 접수
		int result = mapper.recNos(vo);
		return result;
	}

}
