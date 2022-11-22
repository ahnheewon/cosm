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
	public WorkVO getWorkInfo(int workNo) {
		return mapper.getWorkInfo(workNo);
	}
	
	@Override
	public int insertWork(WorkVO vo) {
		return mapper.insertWork(vo);
	}
	
	@Override
	public int insertWorkSign(WorkVO vo) {
		return mapper.insertWorkSign(vo);
	}
	
	@Override
	public int updateWork(WorkVO vo) {
		return mapper.updateWork(vo);
	}
	
	@Override
	public int updateWorkSign(WorkVO vo) {
		return mapper.updateWorkSign(vo);
	}
	
	@Override
	public int deleteWork(int workNo) {
		return mapper.deleteWork(workNo);				
	}
	
	@Override
	public int deleteSign(int workNo) {
		return mapper.deleteSign(workNo);
	}
	
	@Override
	public int updateDeleteWorkNo(int workNo) {
		return mapper.updateDeleteWorkNo(workNo);
	}
	
	@Override
	public int updateDeleteSignNo(int workNo) {
		return mapper.updateDeleteSignNo(workNo);
	}
	
	@Override
	public WorkVO getWorkNo() {
		return mapper.getWorkNo();
	}

													

//============================================================================================================================
	
	
}
