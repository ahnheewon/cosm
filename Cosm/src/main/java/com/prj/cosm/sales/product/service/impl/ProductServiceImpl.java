package com.prj.cosm.sales.product.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prj.cosm.sales.product.mapper.ProductMapper;
import com.prj.cosm.sales.product.service.ProductService;
import com.prj.cosm.sales.product.service.ProductVO;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductMapper mapper;
	
	@Override
	public List<ProductVO> proList() {
		// 전체조회
		return mapper.proList();
	}

}
