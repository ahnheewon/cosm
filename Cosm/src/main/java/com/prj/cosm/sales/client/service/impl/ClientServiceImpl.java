package com.prj.cosm.sales.client.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prj.cosm.sales.client.mapper.ClientMapper;
import com.prj.cosm.sales.client.service.ClientService;
import com.prj.cosm.sales.orders.service.OrdersVO;

@Service
public class ClientServiceImpl implements ClientService  {

	@Autowired
	ClientMapper mapper;
	
	@Override
	public int getOrderNo() {
		//주문번호 +1
		return 0;
	}

	@Override
	public List<OrdersVO> salesOrderList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrdersVO selectOrderInfo(OrdersVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrdersVO insertOrder(OrdersVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrdersVO deleteOrderInfo(OrdersVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

}
