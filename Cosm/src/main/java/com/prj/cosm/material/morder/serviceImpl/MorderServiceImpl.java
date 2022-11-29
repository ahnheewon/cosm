package com.prj.cosm.material.morder.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prj.cosm.material.morder.mapper.MorderMapper;
import com.prj.cosm.material.morder.service.MorderService;
import com.prj.cosm.material.morder.service.MorderVO;
import com.prj.cosm.user.alert.mapper.AlertMapper;
import com.prj.cosm.user.alert.service.AlertVO;
import com.prj.cosm.user.emp.mapper.EmpMapper;
import com.prj.cosm.user.emp.service.EmpVO;

@Service
public class MorderServiceImpl implements MorderService {

	@Autowired
	MorderMapper moMapper;

	@Autowired
	AlertMapper aMapper;

	@Autowired
	EmpMapper eMapper;

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
	public int insertInputOrder(List<MorderVO> mvo) {
		// 입고대기 리스트 -> 입고 리스트(입고완료)
		int result = 0;
		for (MorderVO vo : mvo) {		
			result += moMapper.insertInputOrder(vo);
			moMapper.updateCode(vo);
			vo.setMNo(vo.getMoMaterialId());
			moMapper.updateMStock(vo);
		}	
		
		List<EmpVO> eList = new ArrayList<>();
		eList = eMapper.getReceiveUsers("D0105");
		for (EmpVO eVO : eList) {
			AlertVO aVO = new AlertVO();
			aVO.setAlertContent("필요 자재가 입고되었습니다.");
			aVO.setAlertReceive(eVO.getUsersNo());
			aMapper.insertAlert(aVO);
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
