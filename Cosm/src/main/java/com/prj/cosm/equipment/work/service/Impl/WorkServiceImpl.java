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
	public List<WorkVO> getWorkAllList() {
		return mapper.getWorkAllList();
	}
	
	@Override
	public List<WorkVO> getIncompleteWorkList() {
		return mapper.getIncompleteWorkList();
	}
	@Override
	public List<WorkVO> getIncompleteWork1() {
		return mapper.getIncompleteWork1();
	}
	@Override
	public List<WorkVO> getIncompleteWork2() {
		return mapper.getIncompleteWork2();
	}
	@Override
	public List<WorkVO> getIncompleteWork3() {
		return mapper.getIncompleteWork3();
	}
	
	@Override
	public List<WorkVO> getCompleteWorkList() {
		return mapper.getCompleteWorkList();
	}
	
	@Override
	public WorkVO getWorkInfo(int workNo, int workEquipNo) {
		return mapper.getWorkInfo(workNo,workEquipNo);
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
	public int updateSignSeq(WorkVO vo) {
		return mapper.updateSignSeq(vo);
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

	@Override
	public WorkVO getSignEmpNo(int signEmpNo) {
		
		return mapper.getSignEmpNo(signEmpNo);
	}

	@Override
	public int updateWorkCode(WorkVO vo) {
		
		return mapper.updateWorkCode(vo);
	}
												

//============================================================================================================================
	
	@Override
	public List<WorkVO> getPartList() {
		
		return mapper.getPartList();
	}

	@Override
	public WorkVO getPartInfo(String partNo) {
		return mapper.getPartInfo(partNo);
	}

	@Override
	public int updatePart(WorkVO vo) {
		
		return mapper.updatePart(vo);
	}

	@Override
	public int updatePartEquip(WorkVO vo) {
		return mapper.updatePartEquip(vo);
	}
	
}
