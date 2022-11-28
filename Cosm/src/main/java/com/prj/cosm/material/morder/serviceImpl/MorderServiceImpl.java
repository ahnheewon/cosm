package com.prj.cosm.material.morder.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.prj.cosm.material.morder.mapper.MorderMapper;
import com.prj.cosm.material.morder.service.MorderService;
import com.prj.cosm.material.morder.service.MorderVO;

@Service
public class MorderServiceImpl implements MorderService {

	@Autowired
	MorderMapper moMapper;


	@Override
	public List<MorderVO> mioInputList(MorderVO vo) {
		// 자재 입고 리스트 조회
		return moMapper.mioInputList(vo);
	}

	@Override
	public List<MorderVO> mioOutputList(MorderVO vo) {
		// 자재 출고 리스트 조회 
		return moMapper.mioOutputList(vo);
	}

	@Override
	public List<MorderVO> getStandbyList() {
		// 입고 대기 리스트 조회
		return moMapper.getStandbyList();
	}

	@Override
	public int  insertInputOrder(List<MorderVO> mvo) {
		// 입고대기 리스트 -> 입고 리스트(입고완료)
		
		int result = 0;
		for (MorderVO vo : mvo) {
			result += moMapper.insertInputOrder(vo);
					moMapper.updateCode(vo);
					vo.setMNo(vo.getMoMaterialId());
					moMapper.updateMStock(vo);
		}
		return result;
		
	}

	@Override
	public int updateCode(MorderVO vo) {
		// 입고 확정시 발주 코드 업데이트
		return moMapper.updateCode(vo);
	}

	@Override
	public int updateMStock(MorderVO vo) {
		// 입고 확정시 현재재고 업데이트
		return moMapper.updateMStock(vo);
	}


	

}
