package com.prj.cosm.produce.bom.mapper;

import java.util.List;

import com.prj.cosm.produce.bom.service.BomVO;

public interface BomMapper {
	
	public List<BomVO> getBomList();
	
	public BomVO getBomNo();
	
	public int insertBom(BomVO bomVO);
	
	public int updateBom(BomVO bomVO);
	
	public int deleteBom(int bomNo);
}
