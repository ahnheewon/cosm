package com.prj.cosm.produce.goods.mapper;

import java.util.List;

import com.prj.cosm.produce.goods.service.GoodsVO;

public interface GoodsMapper {
	
	public List<GoodsVO> getGoodList();
	
	public GoodsVO getGoodNo();
	
	public Integer insertGood(GoodsVO goodsVO);
	
	public int updateGood(GoodsVO goodsVO);
	
	public int deleteGood(int goodsNo);
}
