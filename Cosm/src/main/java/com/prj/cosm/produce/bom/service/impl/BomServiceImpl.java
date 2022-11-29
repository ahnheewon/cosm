package com.prj.cosm.produce.bom.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prj.cosm.produce.bom.mapper.BomMapper;
import com.prj.cosm.produce.bom.service.BomService;
import com.prj.cosm.produce.bom.service.BomVO;
import com.prj.cosm.produce.plan.service.PlanVO;

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
	public int deleteBomInfo(String bomNo) {
		// TODO Auto-generated method stub
		return mapper.deleteBom(bomNo);
	}

	@Override
	public List<BomVO> getMaterialNoList() {
		// TODO Auto-generated method stub
		return mapper.getMaterialNoList();
	}

	@Override
	public List<BomVO> getGoodsNoList() {
		// TODO Auto-generated method stub
		return mapper.getGoodsNoList();
	}

	@Override
	public BomVO getBomInfo(String goodsNo) {
		// TODO Auto-generated method stub
		return mapper.getBomInfo(goodsNo);
	}

	@Override
	public void insertMaterialInfo(PlanVO planVO) {
		// TODO Auto-generated method stub
		 mapper.insertMaterialInfo(planVO);
	}

	@Override
	public void insertMaterialInfo2(PlanVO planVO) {
		// TODO Auto-generated method stub
		mapper.insertMaterialInfo2(planVO);
	}

	@Override
	public List<BomVO> selectMaterialList() {
		// TODO Auto-generated method stub
		return mapper.selectMaterialList();
	}

}
