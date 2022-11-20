package com.prj.cosm.sales.salesIo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prj.cosm.sales.salesIo.mapper.SalesIoMapper;
import com.prj.cosm.sales.salesIo.service.SalesIoService;
import com.prj.cosm.sales.salesIo.service.SalesIoVO;

@Service
public class SalesIoServiceImpl implements SalesIoService {

	@Autowired
	SalesIoMapper mapper;
	
	@Override
	public List<SalesIoVO> inoutList() {
		// TODO Auto-generated method stub
		return mapper.inoutList();
	}

	@Override
	public SalesIoVO insertInfo(SalesIoVO vo) {
		// TODO Auto-generated method stub
		return mapper.insertInfo(vo);
	}

	
}
