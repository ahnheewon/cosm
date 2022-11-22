package com.prj.cosm.material.morder.mapper;

import java.util.List;

import com.prj.cosm.material.morder.service.MorderVO;

public interface MorderMapper {

	// 입고 리스트 전체조회
	public List<MorderVO> mioInputList();

	// 출고 리스트 전체조회
	public List<MorderVO> mioOutputList();

	
}
