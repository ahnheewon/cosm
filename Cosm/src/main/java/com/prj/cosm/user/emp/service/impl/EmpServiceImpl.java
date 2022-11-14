package com.prj.cosm.user.emp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prj.cosm.user.emp.mapper.EmpMapper;
import com.prj.cosm.user.emp.service.EmpService;
import com.prj.cosm.user.emp.service.EmpVO;

@Service
public class EmpServiceImpl implements EmpService {

	@Autowired
	EmpMapper mapper;
	
	@Override
	public List<EmpVO> empSelectList() {
		return mapper.empSelectList();
	}

	@Override
	public EmpVO empSelect(EmpVO vo) {
		return mapper.empSelect(vo);
	}

	@Override
	public EmpVO empInsert(EmpVO vo) {
		return mapper.empInsert(vo);
	}

	@Override
	public EmpVO empUpdate(EmpVO vo) {
		return mapper.empUpdate(vo);
	}

	@Override
	public EmpVO empDelete(EmpVO vo) {
		return mapper.empDelete(vo);
	}

}
