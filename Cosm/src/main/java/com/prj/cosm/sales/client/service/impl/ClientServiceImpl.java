package com.prj.cosm.sales.client.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prj.cosm.sales.client.mapper.ClientMapper;
import com.prj.cosm.sales.client.service.ClientService;
import com.prj.cosm.sales.client.service.ClientVO;
import com.prj.cosm.user.alert.mapper.AlertMapper;
import com.prj.cosm.user.alert.service.AlertVO;
import com.prj.cosm.user.emp.mapper.EmpMapper;
import com.prj.cosm.user.emp.service.EmpVO;

@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	ClientMapper mapper;

	@Autowired
	AlertMapper aMapper;

	@Autowired
	EmpMapper eMapper;

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
	public int insertOrder(ClientVO cvo) {
		// 주문등록
		
		return mapper.insertOrder(cvo);
	}

	@Override
	public List<ClientVO> getOrderList(ClientVO cvo) {
		// 주문내역조회
		return mapper.getOrderList(cvo);
	}

}
