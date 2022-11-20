package com.prj.cosm.produce.goods.service;

import java.util.List;

public interface GoodsService {

	//전체조회
	public List<GoodsVO> selectGoodList();
	
	//제품번호조회
	public GoodsVO selectGoodNo();
	
	//등록
	public Integer insertGoodInfo(GoodsVO goodsVO);
	
	//수정
	public int updateGoodInfo(GoodsVO goodsVO);
	
	//삭제
	public int deleteGoodInfo(int goodsNo);
}
