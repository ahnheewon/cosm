package com.prj.cosm.sales.salesIo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prj.cosm.sales.salesIo.mapper.SalesIoMapper;
import com.prj.cosm.sales.salesIo.service.SalesIoService;
import com.prj.cosm.sales.salesIo.service.SalesIoVO;

@Service
public class SalesIoServiceImpl implements SalesIoService {

	@Autowired
	SalesIoMapper mapper;

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
		
		return result;
	}

	@Override
	public int delOutOrder(List<String> sioList) {
		// 다중삭제
		int result = 0;
		for (String no : sioList) {
			result += mapper.delOutOrder(no);
		}
		return result;
	}

	@Override
	public int outList(List<SalesIoVO> vo) {
		return 0;
	}

}
