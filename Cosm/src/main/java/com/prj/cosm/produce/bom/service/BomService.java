package com.prj.cosm.produce.bom.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.prj.cosm.produce.plan.service.PlanVO;

public interface BomService {

	// 전체조회
	public List<BomVO> selectBomList();

	// bom번호
	public BomVO selectBomNo();

	// 등록
	public int insertBomInfo(BomVO bomVO);

	// 수정
	public int updateBomInfo(BomVO bomVO);

	// 삭제
	public int deleteBomInfo(String bomNo);

	// 자재번호 리스트
	public List<BomVO> getMaterialNoList();

	// 제품번호 리스트
	public List<BomVO> getGoodsNoList();

	// bom생산계획에 쓸 단건 조회
	public BomVO getBomInfo(@Param("goodsNo") String goodsNo);

	// 지시시 자재 insert
	public void insertMaterialInfo(PlanVO planVO);

	// 지시시 자재2 insert
	public void insertMaterialInfo2(PlanVO planVO);
	
	//자재조회
	public List<BomVO> selectMaterialList();
}
