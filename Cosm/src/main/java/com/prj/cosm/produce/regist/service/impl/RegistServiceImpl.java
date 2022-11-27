package com.prj.cosm.produce.regist.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prj.cosm.produce.regist.mapper.RegistMapper;
import com.prj.cosm.produce.regist.service.RegistService;
import com.prj.cosm.produce.regist.service.RegistVO;

@Service
public class RegistServiceImpl implements RegistService {
	
	@Autowired
	RegistMapper mapper;
	
	@Override
	public List<Map<String, Object>> selectRegistList() {
		
		return mapper.getRegistList();
	}

	@Override
	public RegistVO selectRegistLOT() {
		// TODO Auto-generated method stub
		return mapper.getRegistLOT();
	}

	@Override
	public int insertRegistInfo(RegistVO registVO) {
		// TODO Auto-generated method stub
		return mapper.insertRegist(registVO);
	}

	@Override
	public int deleteRegistInfo(String registLOT) {
		// TODO Auto-generated method stub
		return mapper.deleteRegist(registLOT);
	}

	@Override
	public RegistVO selectRegistLabel() {
		// TODO Auto-generated method stub
		return mapper.getRegistLabel();
	}

	@Override
	public List<RegistVO> getPlayList() {
		// TODO Auto-generated method stub
		return mapper.getPlayList();
	}

	@Override
	public List<RegistVO> getUnitList() {
		// TODO Auto-generated method stub
		return mapper.getUnitList();
	}

	@Override
	public List<Map<String, Object>> completeList(RegistVO vo) {
		// TODO Auto-generated method stub
		return mapper.completeList(vo);
	}

	@Override
	public List<Map<String, Object>> errorList(RegistVO vo) {
		// TODO Auto-generated method stub
		return mapper.errorList(vo);
	}

}
