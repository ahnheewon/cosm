package com.prj.cosm.material.morder.mapper;

import java.util.List;

import com.prj.cosm.material.morder.service.MorderVO;

public interface MorderMapper {

	// 입고 리스트 전체조회
	public List<MorderVO> mioInputList(MorderVO vo);

	// 출고 리스트 전체조회
	public List<MorderVO> mioOutputList(MorderVO vo);
	
	// 입고 대기 리스트 전체 조회
	public List<MorderVO> getStandbyList();
	
}
