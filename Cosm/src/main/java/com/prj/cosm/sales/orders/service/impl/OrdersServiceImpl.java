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
		// TODO Auto-generated method stub
		return mapper.getOrderNo();
	}

	@Override
	public List<OrdersVO> salesOrderList() {
		// TODO Auto-generated method stub
		return mapper.orderList();
	}

	@Override
	public OrdersVO selectOrderInfo(OrdersVO vo) {
		// TODO Auto-generated method stub
		return mapper.orderInfo(vo);
	}

	@Override
	public int insertOrder(OrdersVO vo) {
		// TODO Auto-generated method stub
		return mapper.insertOrder(vo);
	}

	@Override
	public int deleteOrder(OrdersVO vo) {
		// TODO Auto-generated method stub
		return mapper.deleteOrder(vo);
	}

	@Override
	public int deleteOrderInfo(OrdersVO vo) {
		// TODO Auto-generated method stub
		return mapper.deleteOrder(vo);
	}

	@Override
	public int deleteCheck(List<String> noList) {
		// 체크박스 주문정보 단건삭제
		int result = 0;
		System.out.println(noList);
		// 여러개 지우기
		for (String no : noList) {
			result += mapper.deleteCheck(no);
		}
		// int a = result > 0 ? 1 : 0;
		return result;
	}

	// orderProgressCode
	@Override
	public int updatePro(List<String> noList) {
		// 생산지시 업데이트
		int result = 0;
		System.out.println("생상지시 상황 : " + noList);
		for (String no : noList) {
			result += mapper.updatePro(no);
		}
		return result;
	}
}
