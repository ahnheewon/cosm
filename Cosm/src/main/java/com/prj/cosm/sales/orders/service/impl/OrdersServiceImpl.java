package com.prj.cosm.sales.orders.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prj.cosm.sales.orders.mapper.OrdersMapper;
import com.prj.cosm.sales.orders.service.OrdersService;
import com.prj.cosm.sales.orders.service.OrdersVO;
import com.prj.cosm.user.alert.mapper.AlertMapper;
import com.prj.cosm.user.alert.service.AlertVO;
import com.prj.cosm.user.emp.mapper.EmpMapper;
import com.prj.cosm.user.emp.service.EmpVO;

@Service
public class OrdersServiceImpl implements OrdersService {

	@Autowired
	OrdersMapper mapper;

	@Autowired
	AlertMapper aMapper;

	@Autowired
	EmpMapper eMapper;

	@Override
	public int getOrderNo() {
		// 주문번호순
		return mapper.getOrderNo();
	}

	@Override
	public List<OrdersVO> getOrderList() {
		// 신규주문 조회
		return mapper.getOrderList();
	}

	@Override
	public List<OrdersVO> getReceiptList() {
		// 접수주문 조회
		return mapper.getReceiptList();
	}

	@Override
	public int insertOrder(OrdersVO vo) {
		// 등록
		// int count = mapper.insertOrder(vo);
		List<EmpVO> eList = new ArrayList<>();
		eList = eMapper.getReceiveUsers("D0109"); // 받는사람
		for (EmpVO eVO : eList) {
			AlertVO aVO = new AlertVO();
			aVO.setAlertContent("/orders/sMain"+"^"+vo.getGoodsName()+"의 신규 주문이 있습니다.");
			aVO.setAlertReceive(eVO.getUsersNo());
			aMapper.insertAlert(aVO);
		}
		return mapper.insertOrder(vo);
	}
	/*
	 * public Map getResult(int count, OrdersVO vo) { Map<String, Object> result =
	 * new HashMap<String, Object>(); result.put("result", count);
	 * result.put("data", vo); return result; }
	 */

	@Override
	public int deleteOrder(int orderNo) {
		// 삭제
		return mapper.deleteOrder(orderNo);
	}

	@Override
	public int updateOrder(OrdersVO vo) {
		// 수정
		return mapper.updateOrder(vo);
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
		for (OrdersVO vo : list) {
			result += mapper.updateOrder(vo);
		}
		return result;
	}

	@Override
	public int recNos(List<OrdersVO> vo) {
		// 신규 -> 접수

		int result = mapper.recNos(vo);

		List<EmpVO> eList = new ArrayList<>();
		eList = eMapper.getReceiveUsers("D0105"); // 받는사람
		for (EmpVO eVO : eList) {
			AlertVO aVO = new AlertVO();
			aVO.setAlertContent("/produce/planList"+"^"+"접수 완료된 주문이 있습니다.");
			aVO.setAlertReceive(eVO.getUsersNo());
			aMapper.insertAlert(aVO);
		}

		return result;
	}

	@Override
	public OrdersVO getOrderInfo(OrdersVO vo) {
		//접수주문 단건조회
		return mapper.getOrderInfo(vo);
	}

}
