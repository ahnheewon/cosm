package com.prj.cosm.equipment.equip.service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prj.cosm.equipment.equip.mapper.EquipMapper;
import com.prj.cosm.equipment.equip.service.EquipService;
import com.prj.cosm.equipment.equip.service.EquipVO;

@Service
public class EquipServiceImpl implements EquipService {

	@Autowired
	EquipMapper mapper;
//============================================================================================================================
	
																			//설비

	@Override
	public List<EquipVO> getEquipList() {
		
		return mapper.getEquipList();
	}

	@Override
	public EquipVO getEquipInfo(int equipNo) {
		return mapper.getEquipInfo(equipNo);
	}

	@Override
	public void insertEquip(EquipVO vo) {
		mapper.insertEquip(vo); // 설비등록
		mapper.insertEquipTime(vo); // 설비시간등록
		
	}

	@Override
	public int updateEquip(EquipVO vo) {
		return mapper.updateEquip(vo);
	}

	@Override
	public int deleteEquip(int equipNo) {
		return mapper.deleteEquip(equipNo);
	}

	@Override
	public int deleteEquipTime(int equipNo) {
		return mapper.deleteEquipTime(equipNo);
	}
	
	
	@Override
	public int updateDeleteEquipNo(int equipNo) {
		return mapper.updateDeleteEquipNo(equipNo);
	}

	@Override
	public int updateDeleteTimeEquipNo(int equipNo) {
		
		return mapper.updateDeleteTimeEquipNo(equipNo);
	}

	
	@Override
	public EquipVO getEquipNo() {
		return mapper.getEquipNo();
	}
	
	@Override
	public List<EquipVO> getEquipProcess() {
		
		return mapper.getEquipProcess();
	}
	
//============================================================================================================================
	
																			//공정 
	
	@Override
	public EquipVO getProcessNo() {
	
	return mapper.getProcessNo(); 
	}
	

	@Override
	public List<EquipVO> getProcessList() {
		return mapper.getProcessList();
	}

	@Override
	public EquipVO getProcessInfo(int processNo) {
		return mapper.getProcessInfo(processNo);
	}

	@Override
	public Map insertProcess(EquipVO vo) {
		int count = mapper.insertProcess(vo);
		return getResult(count,vo);
	}

	@Override
	public int updateProcess(EquipVO vo) {
		return mapper.updateProcess(vo);
	}

	@Override
	public int deleteProcess(int processNo) {
		return mapper.deleteProcess(processNo);
	}
	
	public Map getResult(int count,EquipVO vo) {
		Map<String, Object> result = new HashMap<String,Object>();
		result.put("result", count);
		result.put("data", vo);
		return result;

	}

	@Override
	public int updateDeleteProcessNo(int processNo) {
		return mapper.updateDeleteProcessNo(processNo);
	}
	
	@Override
	public int updateDeleteEquipProcess(int equipProcess) {

		return mapper.updateDeleteEquipProcess(equipProcess);
	}


//===================================================================================================
	
																			//점검
	
	@Override
	public List<EquipVO> getTestList() {
		return mapper.getTestList();
	}

	@Override
	public EquipVO getTestInfo(int testNo) {
		return mapper.getTestInfo(testNo);
	}

	@Override
	public int insertTest(EquipVO vo) {
		return mapper.insertTest(vo);
	}

	@Override
	public int updateTest(EquipVO vo) {
		return mapper.updateTest(vo);
	}

	@Override
	public int deleteTest(int testNo) {
		return mapper.deleteTest(testNo);
	}

	@Override
	public int updateDeleteTestNo(int testNo) {
		return mapper.updateDeleteTestNo(testNo);
	}

	@Override
	public EquipVO getTestNo() {
		return mapper.getTestNo();
	}

//===================================================================================================
	
																			//고장
	
	@Override
	public List<EquipVO> getFailList() {
		return mapper.getFailList();
	}

	@Override
	public EquipVO getFailInfo(int failNo) {
		return mapper.getFailInfo(failNo);
	}

	@Override
	public int insertFail(EquipVO vo) {
		return mapper.insertFail(vo);
	}

	@Override
	public int updateFail(EquipVO vo) {
		return mapper.updateFail(vo);
	}

	@Override
	public int deleteFail(int failNo) {
		return mapper.deleteFail(failNo);
	}

	@Override
	public int updateDeleteFailNo(int failNo) {
		return mapper.updateDeleteFailNo(failNo);
	}

	@Override
	public EquipVO getFailNo() {
		return mapper.getFailNo();
	}






	
}
