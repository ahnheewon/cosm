package com.prj.cosm.produce.bom.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prj.cosm.produce.bom.mapper.BomMapper;
import com.prj.cosm.produce.bom.service.BomService;
import com.prj.cosm.produce.bom.service.BomVO;

@Service
public class BomServiceImpl implements BomService {
	
	@Autowired
	BomMapper mapper;
	
	@Override
	public List<BomVO> selectBomList() {
		// TODO Auto-generated method stub
		return mapper.getBomList();
	}

	@Override
	public BomVO selectBomNo() {
		// TODO Auto-generated method stub
		return mapper.getBomNo();
	}

	@Override
	public int insertBomInfo(BomVO bomVO) {
		// TODO Auto-generated method stub
		return mapper.insertBom(bomVO);
	}

	@Override
	public int updateBomInfo(BomVO bomVO) {
		// TODO Auto-generated method stub
		return mapper.updateBom(bomVO);
	}

	@Override
	public int deleteBomInfo(int bomNo) {
		// TODO Auto-generated method stub
		return mapper.deleteBom(bomNo);
	}

}
