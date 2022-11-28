package com.prj.cosm.produce.bom.mapper;

import java.util.List;

import com.prj.cosm.produce.bom.service.BomVO;

public interface BomMapper {

	public List<BomVO> getBomList();

	public BomVO getBomNo();

	public int insertBom(BomVO bomVO);

	public int updateBom(BomVO bomVO);

	public int deleteBom(String bomNo);

	// 자재번호 리스트
	public List<BomVO> getMaterialNoList();

	// 제품번호 리스트
	public List<BomVO> getGoodsNoList();
	
	// 단건조회
	public BomVO getBomInfo(String goodsNo);
}
