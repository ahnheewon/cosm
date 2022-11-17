package com.prj.cosm.sales.orders.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prj.cosm.sales.orders.mapper.OrdersMapper;
import com.prj.cosm.sales.orders.service.OrdersService;
import com.prj.cosm.sales.orders.service.OrdersVO;

@Service
public class OrdersServiceImpl implements OrdersService{

	@Autowired
	OrdersMapper mapper;
	
	@Override
	public int getOrderNo() {
		// TODO Auto-generated method stub
		return 0;
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
		return 0;
	}

	@Override
	public int deleteCheck(List<String> delOno) {
		// 체크박스 주문정보 단건삭제
		  int result = 0;
		   for (String no : delOno) {
		   result += mapper.deleteCheck(no);
		   }
		   int a = result > 0 ? 1 : 0;
		   return a;
		}
	}

