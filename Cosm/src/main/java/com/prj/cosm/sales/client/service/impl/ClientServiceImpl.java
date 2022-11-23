package com.prj.cosm.sales.client.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prj.cosm.sales.client.mapper.ClientMapper;
import com.prj.cosm.sales.client.service.ClientService;
import com.prj.cosm.sales.client.service.ClientVO;
import com.prj.cosm.sales.orders.service.OrdersVO;

@Service
public class ClientServiceImpl implements ClientService  {

	@Autowired
	ClientMapper mapper;
	
	@Override
	public int clientIn(ClientVO cvo) {
		// 고객 가입
		return mapper.clientIn(cvo);
	}

	@Override
	public List<ClientVO> myInfo(ClientVO cvo) {
		// 고객 정보조회
		return mapper.myInfo(cvo);
	}

	@Override
	public int updateMy(ClientVO cvo) {
		// 고객 정보수정
		return 0;
	}

	@Override
	public int deleteMy(ClientVO cvo) {
		// 고객 탈퇴-삭제
		return 0;
	}

	@Override
	public List<ClientVO> myOrderList() {
		// 내주문조회
		return null;
	}

	@Override
	public void insertOrder(ClientVO cvo) {
		//주문등록
		
	}

}
