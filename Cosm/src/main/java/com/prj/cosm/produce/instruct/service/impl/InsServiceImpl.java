package com.prj.cosm.produce.instruct.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prj.cosm.equipment.equip.service.EquipService;
import com.prj.cosm.produce.bom.mapper.BomMapper;
import com.prj.cosm.produce.instruct.mapper.InsMapper;
import com.prj.cosm.produce.instruct.service.InsService;
import com.prj.cosm.produce.instruct.service.InsVO;
import com.prj.cosm.produce.regist.mapper.RegistMapper;

@Service
public class InsServiceImpl implements InsService {
	@Autowired
	BomMapper bomMapper;
	
	@Autowired
	InsMapper mapper;
  
	@Autowired
	EquipService equipService;

	@Autowired
	RegistMapper registMapper;
  
	@Override
	public List<Map<String, Object>> selectInsList() {
		return mapper.getInsList();
	}

	@Override
	public InsVO selectInsNo() {

		return mapper.getInsNo();
	}

	@Override
	public int insertInsInfo(InsVO insVO) {
//		equipService.doWork(insVO);
		mapper.updateRTP(insVO);
		return mapper.insertIns(insVO);
	}

	@Override
	public int updateInsInfo(InsVO insVO) {

		return mapper.updateIns(insVO);
	}

	@Override
	public int deleteInsInfo(String instructNo) {

		return mapper.deleteIns(instructNo);
	}

	@Override
	public List<InsVO> getMaterialNoList() {
		// 자재번호 리스트
		return mapper.getMaterialNoList();
	}

	@Override
	public List<InsVO> getPlayList() {
		// 진행상황 리스트
		return mapper.getPlayList();
	}

	@Override
	public List<Map<String, Object>> completeList() {
		// 생산완료된 생산지시리스트
		return mapper.completeList();
	}

	@Override
	public int updateInsPlay(InsVO InsVO) {
		
		return mapper.updateInsPlay(InsVO);
	}

	@Override
	public int updateInsPlay2(InsVO InsVO) {
		registMapper.updateOrderInfo(InsVO);
		return mapper.updateInsPlay2(InsVO);
	}

	@Override
	public List<Map<String, Object>> allInsList(InsVO vo) {
		// TODO Auto-generated method stub
		return mapper.allInsList(vo);
	}

}
