package com.prj.cosm.produce.instruct.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prj.cosm.produce.instruct.mapper.InsMapper;
import com.prj.cosm.produce.instruct.service.InsService;
import com.prj.cosm.produce.instruct.service.InsVO;

@Service
public class InsServiceImpl implements InsService {

	@Autowired
	InsMapper mapper;

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


}
