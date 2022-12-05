package com.prj.cosm.sales.salesIo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prj.cosm.sales.salesIo.mapper.SalesIoMapper;
import com.prj.cosm.sales.salesIo.service.SalesIoService;
import com.prj.cosm.sales.salesIo.service.SalesIoVO;
import com.prj.cosm.user.alert.mapper.AlertMapper;
import com.prj.cosm.user.alert.service.AlertVO;
import com.prj.cosm.user.emp.mapper.EmpMapper;
import com.prj.cosm.user.emp.service.EmpVO;

@Service
public class SalesIoServiceImpl implements SalesIoService {

	@Autowired
	SalesIoMapper mapper;

	@Autowired
	AlertMapper aMapper;

	@Autowired
	EmpMapper eMapper;

	@Override
	public int getSalesNo() {
		// 완제품 번호
		return mapper.getSalesNo();
	}

	@Override
	public List<SalesIoVO> getSalesIoList() {
		//
		return mapper.getSalesIoList();
	}

	@Override
	public SalesIoVO selectSalesInfo(String salesNo) {
		// TODO Auto-generated method stub
		return mapper.selectSalesInfo(salesNo);
	}

	@Override
	public int insertSalesInfo(SalesIoVO vo) {
		// TODO Auto-generated method stub
		return mapper.insertSalesInfo(vo);
	}

	@Override
	public int updateSales(SalesIoVO vo) {
		// TODO Auto-generated method stub
		return mapper.updateSales(vo);
	}

	@Override
	public int deleteSales(int salesNo) {
		// TODO Auto-generated method stub
		return mapper.deleteSales(salesNo);
	}

	@Override
	public int updateOutDay(List<SalesIoVO> list) {
		// TODO Auto-generated method stub
		return 0;
	}
//================================================================

	@Override
	public int updateOutInfo(List<SalesIoVO> list) {
		// 출고
		int result = 0;
		result = mapper.updateOutInfo(list);

		List<EmpVO> eList = new ArrayList<>();
		eList = eMapper.getReceiveUsers("D0105");
		for (EmpVO eVO : eList) {
			AlertVO aVO = new AlertVO();
			aVO.setAlertContent("/clinet/sMain" + "^"  + "건 생산이 완료되었습니다"); //고객 이름/주문번호 
			aVO.setAlertReceive(eVO.getUsersNo());
			aMapper.insertAlert(aVO);
		}

		return result;
	}

	/*
	 * @Override public int delOutOrder(List<SalesIoVO> vo) { // 다중삭제 int result =
	 * 0; for (String no : vo) { result += mapper.delOutOrder(vo); } return result;
	 * }
	 */

	@Override
	public int outList(List<SalesIoVO> vo) {
		return 0;
	}

	@Override
	public int delOutOrder(List<SalesIoVO> vo) {
		// TODO Auto-generated method stub
		return 0;
	}

}
