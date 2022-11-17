package com.prj.cosm.equipment.equip.service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prj.cosm.equipment.equip.mapper.equipMapper;
import com.prj.cosm.equipment.equip.service.equipService;
import com.prj.cosm.equipment.equip.service.equipVO;

@Service
public class equipServiceImpl implements equipService {

	@Autowired
	equipMapper mapper;
	
	
	
	@Override
	public List<equipVO> getEquipList() {
		
		return mapper.getEquipList();
	}

	@Override
	public equipVO getEquipInfo(equipVO vo) {
		return mapper.getEquipInfo(vo);
	}

	@Override
	public Map insertEquip(equipVO vo) {
		int count = mapper.insertEquip(vo);
		return getResult(count,vo);
	}

	@Override
	public int updateEquip(equipVO vo) {
		return mapper.updateEquip(vo);
	}

	@Override
	public int deleteEquip(int equipNo) {
		return mapper.deleteEquip(equipNo);
	}

	@Override
	public equipVO getEquipNo() {
		return mapper.getEquipNo();
	}

	@Override
	public equipVO getProcessNo() {
	
	return mapper.getProcessNo(); 
	}
	

	@Override
	public List<equipVO> getProcessList() {
		return mapper.getProcessList();
	}

	@Override
	public equipVO getProcessInfo(equipVO vo) {
		return mapper.getProcessInfo(vo);
	}

	@Override
	public Map insertProcess(equipVO vo) {
		int count = mapper.insertProcess(vo);
		return getResult(count,vo);
	}

	@Override
	public int updateProcess(equipVO vo) {
		return mapper.updateProcess(vo);
	}

	@Override
	public int deleteProcess(int processNo) {
		return mapper.deleteProcess(processNo);
	}
	
	public Map getResult(int count,equipVO vo) {
		Map<String, Object> result = new HashMap<String,Object>();
		result.put("result", count);
		result.put("data", vo);
		return result;

	}
	
}
