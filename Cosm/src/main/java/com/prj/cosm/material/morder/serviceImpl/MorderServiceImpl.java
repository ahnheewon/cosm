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
	public List<MorderVO> mioInputList() {
		// 자재 입고 리스트 조회
		return moMapper.mioInputList();
	}

	@Override
	public List<MorderVO> mioOutputList() {
		// 자재 출고 리스트 조회 
		return moMapper.mioOutputList();
	}

}
