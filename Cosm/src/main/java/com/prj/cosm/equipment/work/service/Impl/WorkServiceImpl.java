package com.prj.cosm.equipment.work.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prj.cosm.equipment.work.mapper.WorkMapper;
import com.prj.cosm.equipment.work.service.WorkService;
import com.prj.cosm.equipment.work.service.WorkVO;

@Service
public class WorkServiceImpl implements WorkService {

	@Autowired
	WorkMapper mapper;
//============================================================================================================================

	@Override
	public List<WorkVO> getWorkList() {
		return mapper.getWorkList();
	}

	@Override
	public WorkVO getWorkInfo(int equipNo) {
		return null;
	}

	@Override
	public int insertWork(WorkVO vo) {
		return 0;
	}

	@Override
	public int insertWorkTime(WorkVO vo) {
		return 0;
	}

	@Override
	public int updateWork(WorkVO vo) {
		return 0;
	}

	@Override
	public int deleteWork(int equipNo) {
		return 0;
	}

	@Override
	public int deleteWorkTime(int equipNo) {
		return 0;
	}

	@Override
	public int updateDeleteWorkNo(int equipNo) {
		return 0;
	}

	@Override
	public int updateDeleteTimeWorkNo(int equipNo) {
		return 0;
	}

	@Override
	public WorkVO getWorkNo() {
		return null;
	}
	
																	

//============================================================================================================================
	
	
}
