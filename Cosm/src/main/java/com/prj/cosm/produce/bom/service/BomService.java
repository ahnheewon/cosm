package com.prj.cosm.produce.bom.service;

import java.util.List;

public interface BomService {

	//전체조회
	public List<BomVO> selectBomList();
	
	//bom번호
	public BomVO selectBomNo();
	
	//등록
	public int insertBomInfo(BomVO bomVO);
	
	//수정
	public int updateBomInfo(BomVO bomVO);
	
	//삭제
	public int deleteBomInfo(int bomNo);
}
