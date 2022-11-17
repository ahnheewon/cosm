package com.prj.cosm.sales.product.mapper;

import java.util.List;

import com.prj.cosm.sales.product.service.ProductVO;

public interface ProductMapper {

	//제품 - 고객용

	//제품 이름 나열
	//public int getName();
	
	//제품 - 전체조회
	public List<ProductVO> proList();
	
	
}
