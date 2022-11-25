package com.prj.cosm.material.morder.service;

import java.util.List;

import com.prj.cosm.material.material.service.MaterialVO;

public interface MorderService {


	// 입고 리스트 전체조회
	public List<MorderVO> mioInputList();

	// 출고 리스트 전체조회
	public List<MorderVO> mioOutputList();

}
