package com.prj.cosm.equipment.equip.service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prj.cosm.equipment.equip.mapper.EquipMapper;
import com.prj.cosm.equipment.equip.service.EquipService;
import com.prj.cosm.equipment.equip.service.EquipVO;

@Service
public class equipServiceImpl implements EquipService {

	@Autowired
	EquipMapper mapper;
	
	
	
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
	public EquipVO getEquipNo() {
		return mapper.getEquipNo();
	}

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


	
}
