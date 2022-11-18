package com.prj.cosm.produce.goods.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prj.cosm.produce.goods.mapper.GoodsMapper;
import com.prj.cosm.produce.goods.service.GoodsService;
import com.prj.cosm.produce.goods.service.GoodsVO;

@Service
public class GoodsServiceImpl implements GoodsService {

	@Autowired
	GoodsMapper mapper;
	
	@Override
	public List<GoodsVO> selectGoodList() {
		return mapper.getGoodList();
	}

	@Override
	public GoodsVO selectGoodNo() {
		// TODO Auto-generated method stub
		return mapper.getGoodNo();
	}

	@Override
	public Integer insertGoodInfo(GoodsVO goodsVO) {
		// TODO Auto-generated method stub
		return mapper.insertGood(goodsVO);
	}

	@Override
	public int updateGoodInfo(GoodsVO goodsVO) {
		// TODO Auto-generated method stub
		return mapper.updateGood(goodsVO);
	}

	@Override
	public int deleteGoodInfo(int goodsNo) {
		// TODO Auto-generated method stub
		return mapper.deleteGood(goodsNo);
	}

}
